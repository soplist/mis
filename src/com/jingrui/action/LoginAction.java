package com.jingrui.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.Area;
import com.jingrui.domain.Customer;
import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.Page;
import com.jingrui.domain.Permission;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.Task;
import com.jingrui.domain.User;
import com.jingrui.service.CustomerService;
import com.jingrui.service.DepartmentService;
import com.jingrui.service.PmTableService;
import com.jingrui.service.PmTaskService;
import com.jingrui.service.TaskService;
import com.jingrui.service.UserService;
import com.jingrui.util.PageUtil;
import com.jingrui.util.StatisticsHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private String confirmPass;
    private String sys;
    private UserService userService;
    private DepartmentService deptService;
    private TaskService taskService;
	private PmTaskService pmTaskService;
	private PmTableService pmTableService;
	private CustomerService customerService;
    
    private static Logger logger = Logger.getLogger(LoginAction.class);
	
    public LoginAction() {
		// TODO Auto-generated constructor stub
    	System.out.println("LoginAction create!");
	}
    public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String execute() throws Exception{
		logger.info("login");
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		User u = userService.findUserByName(username);
    	session.setAttribute("user", u);
    	
    	if(sys.equals("1")){
    		List<PmTable> current_user_not_finished_pmtables = pmTableService.queryNotFinishedByUser(u);
    		List<PmTable> SelfAndDeptAndStaffPmTables = new ArrayList<PmTable>();
    		List<PmTable> managerPmTables = new ArrayList<PmTable>();
    		List<PmTable> companyPmTables = new ArrayList<PmTable>();
    		for (PmTable pmTable : current_user_not_finished_pmtables) {
    			if(pmTable.getType().equals(3)&&!pmTable.isStatu()){
    				managerPmTables.add(pmTable);
    			}
    			else if(pmTable.getType().equals(4)&&!pmTable.isStatu()){
    				companyPmTables.add(pmTable);
    			}
    			else{
    				SelfAndDeptAndStaffPmTables.add(pmTable);
    			}
			}
    		session.setAttribute("SelfAndDeptAndStaffPmTables", SelfAndDeptAndStaffPmTables);
    		session.setAttribute("managerPmTables", managerPmTables);
    		session.setAttribute("companyPmTables", companyPmTables);
    		
    		//if(u.getPermission().getViewAllPm()){
        		//List<PmTask> allPmTask = pmTaskService.getAll();
        		//session.remove("allPmTask");
    		 	//session.put("allPmTask",allPmTask);
        	//}
    		Long totalPmTaskCount = pmTaskService.getTotalCount();
    		Page pmtask_page = PageUtil.createPage(10, totalPmTaskCount, 1);
    		List<PmTask> tasks = pmTaskService.queryByPage(pmtask_page);
    		session.setAttribute("pmtask_page", pmtask_page);
    		session.setAttribute("allPmTask", tasks);
    		
    		Long currentUserFinishedTotalPmTableCount = pmTableService.getFinishedTotalCountByUser(u);
    		Page current_user_finished_pmtable_page = PageUtil.createPage(25, currentUserFinishedTotalPmTableCount, 1);
    		List<PmTable> current_user_finished_pmtables = pmTableService.queryFinishedByPageAndUser(current_user_finished_pmtable_page, u);
    		List<PmTask> current_user_pmtask = pmTaskService.getPmTasksByUser(u);
    		
    		
    		session.setAttribute("current_user_finished_pmtable_page", current_user_finished_pmtable_page);
    		session.setAttribute("current_user_finished_pmtables", current_user_finished_pmtables);
    		session.setAttribute("current_user_pmtask", current_user_pmtask);
    		
    		return "performanceMeasurement";
    	}else if(sys.equals("2")){
    		session.setAttribute("dptmlist", deptService.listDptm());
	    	 
    	    String []s= {"汉滨区","旬阳县","石泉县","汉阴县","平利县","白河县","紫阳县","岚皋县","宁陕县","镇坪县"};
    		List<Area> areaList = new ArrayList<Area>();
    		for(int i=0;i<s.length;i++){
    		 	Area a = new Area(s[i],s[i]);
    		 	areaList.add(a);
    		}
    		session.removeAttribute("areaList");
    		session.setAttribute("areaList", areaList); 
    		
    		HttpServletRequest request = ServletActionContext.getRequest();
    	    
    	    Long TotalCustomerCount = customerService.getTotalCount();
    	    Page customer_page = PageUtil.createPage(100, TotalCustomerCount, 1);
    	    List<Customer> customer_per_page = customerService.queryCustomersByPage(customer_page);
    	    request.removeAttribute("list");
    	    
    	    session.setAttribute("customer_page", customer_page);
    	    request.setAttribute("list",customer_per_page);
    		
            return "customerList";
    	}else if(sys.equals("3")){
    		List<Task> taskList_1 = taskService.getApproveTask();
    		session.setAttribute("approveTaskList", taskList_1);
    		
    		TreeMap<String,Integer> statisticsTable=StatisticsHelper.getStatistics(u.getNoticePeoplesForUserId());
    		session.setAttribute("statisticsTable", statisticsTable);
    		    	 
    		List<String> months = new ArrayList<String>();
    		Set<NoticePeople> noticePeoples = u.getNoticePeoplesForUserId();
    		for (NoticePeople np : noticePeoples) {
    		    String month = np.getTaskByTaskId().getDate().substring(0, 7);
    		    if(!months.contains(month)){
    		        months.add(month);
    		    }
			}
    		session.setAttribute("months", months);   
    		
    		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    		String date = format.format(new Date());
    		List<NoticePeople> nps = StatisticsHelper.getNoticePeoplesByMonth(date.substring(0, 7),u.getNoticePeoplesForUserId());
    		session.setAttribute("nps", nps);
    		    	 
    		return "scoreList";
    	}else{
    		return "login";
    	}
    		//return "loginSuccess";
    	
    }
	
    public void validateExecute() {
    	try{
    		System.out.println("validate:"+username);
    		this.clearErrorsAndMessages();
    	    if(username.equals("")){
			    this.addFieldError("error", "用户名不能为空");
		    }
    	    if(password.equals("")){
			    this.addFieldError("error", "密码不能为空");
		    }
    	    if(sys.equals("0")){
    	    	this.addFieldError("error", "请选择登录系统");
    	    }
    	    if(!username.equals("")&&!password.equals("")){
    	    	User u = userService.findUserByName(username);
        	    if(null==u){
        	    	this.addFieldError("error", "用户不存在");
        	    }
        	    else{
        	    	if(!u.getPassword().equals(password)){
            	    	this.addFieldError("error", "密码不正确");
            	    }
        	    }
    	    }
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
	
	public String modifyPass(){
		return "modify";
	}
	
	public String modifyPassDel(){
		logger.info("modify password");
		System.out.println("modifyPassDel User.username:"+this.username);
		System.out.println("modifyPassDel User.password:"+this.password);
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		u.setPassword(this.password);
		
		if(this.confirmPass.equals(this.password)){
			if(this.password.equals("")){
				session.removeAttribute("error");
				String error="password can not be empty.";
				session.setAttribute("error", error);
			    return "failure";
			}
			session.removeAttribute("error");
		    userService.modifyUserPass(u);
		    return "success";
		}else{
			String error="the two input password must same.";
			session.setAttribute("error", error);
		    return "failure";
		}
	}
	
	public String logout(){
		logger.info("logout");
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "logsucc";
	}
	
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	public PmTaskService getPmTaskService() {
		return pmTaskService;
	}
	public void setPmTaskService(PmTaskService pmTaskService) {
		this.pmTaskService = pmTaskService;
	}
	
	public PmTableService getPmTableService() {
		return pmTableService;
	}
	public void setPmTableService(PmTableService pmTableService) {
		this.pmTableService = pmTableService;
	}
	
	public DepartmentService getDeptService() {
		return deptService;
	}
	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}
    public TaskService getTaskService() {
		return taskService;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	public String getSys() {
		return sys;
	}
	public void setSys(String sys) {
		this.sys = sys;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
}
