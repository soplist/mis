package com.jingrui.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.jingrui.domain.Area;
import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.Page;
import com.jingrui.domain.Permission;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.Task;
import com.jingrui.domain.User;
import com.jingrui.service.DepartmentService;
import com.jingrui.service.PmTaskService;
import com.jingrui.service.TaskService;
import com.jingrui.service.UserService;
import com.jingrui.util.PageUtil;
import com.jingrui.util.StatisticsHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	private Integer uid;
	private String username;
    private String password;
    private String confirmPass;
    private String realName;
    private String sys;
    private UserService userService;
    private DepartmentService deptService;
    private TaskService taskService;
	private Integer pid;
	private PmTaskService pmTaskService;
    
    private static Logger logger = Logger.getLogger(LoginAction.class);
    
    public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSys() {
		return sys;
	}
	public void setSys(String sys) {
		this.sys = sys;
	}
	
    
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
		Map session = (Map)ActionContext.getContext().getSession();
		User u = userService.findUserByName(username);
    	
    	
    	session.put("user",u);
    	System.out.println(sys.equals("2"));
    	if(sys.equals("2")){
    	    session.put("dptmlist",deptService.listDptm());
    		    	 
    	    String []s= {"汉滨区","旬阳县","石泉县","汉阴县","平利县","白河县","紫阳县","岚皋县","宁陕县","镇坪县"};
    		List<Area> areaList = new ArrayList<Area>();
    		for(int i=0;i<s.length;i++){
    		 	Area a = new Area(s[i],s[i]);
    		 	areaList.add(a);
    		}
    		session.remove("areaList");
    		session.put("areaList",areaList);
    		    	 
            return "customerList";
    	}else if(sys.equals("1")){
    		List<Task> taskList_1 = taskService.getApproveTask();
    		session.put("approveTaskList", taskList_1);
    		    	 
    		TreeMap<String,Integer> table=StatisticsHelper.getStatistics(u.getNoticePeoplesForUserId());
    		session.put("task_a", table);
    		    	 
    		List<String> months = new ArrayList<String>();
    		Set<NoticePeople> noticePeoples = u.getNoticePeoplesForUserId();
    		for (NoticePeople np : noticePeoples) {
    		    String month = np.getTaskByTaskId().getDate().substring(0, 7);
    		    if(!months.contains(month)){
    		        months.add(month);
    		    }
			}
    		session.put("months", months);
    		    	 
    		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    		String date = format.format(new Date());
    		List<NoticePeople> nps = StatisticsHelper.getNoticePeoplesByMonth(date.substring(0, 7),u.getNoticePeoplesForUserId());
    		session.put("nps", nps);
    		    	 
    		return "scoreList";
    	}else if(sys.equals("3")){
    		Set<PmTable> pmTablesForCurrentUser=u.getPmTablesForUid();
    		List<PmTable> SelfAndDeptAndStaffAndManagerPmTables = new ArrayList<PmTable>();
    		List<PmTable> managerPmTables = new ArrayList<PmTable>();
    		List<PmTable> companyPmTables = new ArrayList<PmTable>();
    		for (PmTable pmTable : pmTablesForCurrentUser) {
    			if(pmTable.getType().equals(3)&&!pmTable.isStatu()){
    				managerPmTables.add(pmTable);
    			}
    			else if(pmTable.getType().equals(4)&&!pmTable.isStatu()){
    				companyPmTables.add(pmTable);
    			}
    			else{
    				SelfAndDeptAndStaffAndManagerPmTables.add(pmTable);
    			}
			}
    		session.put("SelfAndDeptAndStaffAndManagerPmTables", SelfAndDeptAndStaffAndManagerPmTables);
    		session.put("managerPmTables", managerPmTables);
    		session.put("companyPmTables", companyPmTables);
    		
    		//if(u.getPermission().getViewAllPm()){
        		//List<PmTask> allPmTask = pmTaskService.getAll();
        		//session.remove("allPmTask");
    		 	//session.put("allPmTask",allPmTask);
        	//}
    		Long totalPmTaskCount = pmTaskService.getTotalCount();
    		Page page = PageUtil.createPage(10, totalPmTaskCount, 1);
    		List<PmTask> tasks = pmTaskService.queryByPage(page);
    		session.put("page", page);
    		session.put("allPmTask", tasks);
    		
    		return "performanceMeasurement";
    	}else{
    		return "login";
    	}
    		//return "loginSuccess";
    	
    }
	
    @Override
    public void validate() {
    	try{
    		System.out.println(username);
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
		System.out.println("modifyPassDel User.uid:"+this.uid);
		System.out.println("modifyPassDel User.username:"+this.username);
		System.out.println("modifyPassDel User.password:"+this.password);
		User u = new User();
		u.setUid(new Integer(this.uid));
		u.setName(this.username);
		u.setPassword(this.password);
		u.setRealName(this.realName);
		Permission p = new Permission();
		p.setPid(this.pid);
		u.setPermission(p);
		Map session = (Map)ActionContext.getContext().getSession();
		if(this.confirmPass.equals(this.password)){
			if(this.password.equals("")){
				session.remove("error");
				String error="password can not be empty.";
				session.put("error",error);
			    return "failure";
			}
			session.remove("error");
		    userService.modifyUserPass(u);
		    return "success";
		}else{
			
			String error="the two input password must same.";
			session.put("error",error);
		    return "failure";
		}
	}
	
	public String logout(){
		logger.info("logout");
		ActionContext.getContext().getSession().remove("user");
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	
}
