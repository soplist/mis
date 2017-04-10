package com.jingrui.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.Area;
import com.jingrui.domain.Customer;
import com.jingrui.domain.EvaluationForm;
import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.Page;
import com.jingrui.domain.Permission;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.Task;
import com.jingrui.domain.User;
import com.jingrui.domain.UserInformation;
import com.jingrui.domain.UserLoginInformation;
import com.jingrui.domain.UserPermission;
import com.jingrui.service.CustomerService;
import com.jingrui.service.DepartmentService;
import com.jingrui.service.EvaluationFormService;
import com.jingrui.service.PmTableService;
import com.jingrui.service.PmTaskService;
import com.jingrui.service.TaskService;
import com.jingrui.service.UserLoginInformationService;
import com.jingrui.service.UserPermissionService;
import com.jingrui.service.UserService;
import com.jingrui.util.BASE64;
import com.jingrui.util.BuildCompanyStructure;
import com.jingrui.util.LoadChineseCharactersListXml;
import com.jingrui.util.PageUtil;
import com.jingrui.util.StatisticsHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int PERFORMANCE_APPRAISCAL_SYSTEM = 1;
	private static final int CUSTOMER_MESSAGE_SYSTEM = 2;
	private static final int POINTS_MANAGEMENT_SYSTEM = 3;
	private static final int BOSS_VISUAL_ANGLE_SYSTEM = 4;
	private static final String USERNAME_NOT_EXISTS_KEY = "login_error_1";
	private static final String USERNAME_CAN_NOT_EMPTY_KEY = "login_error_2";
	private static final String PASSWORD_CAN_NOT_EMPTY_KEY = "login_error_3";
	private static final String CHOOSE_LOGIN_SYSTEM_KEY = "login_error_4";
	private static final String PASSWORD_ERROR_KEY = "login_error_5";
	private static final String INIT_PASSWORD_NOT_EXIST_KEY = "login_error_6";
	private static final int LOGIN_SYSTEM_NOT_CHOOSE = 0;
	private static final String EMPTY_STRING = "";
	private static final String ERROR = "error";
	private static final String USER_INFORMATION_SESSION_KEY = "userInformation";
	private static final String USER_PERMISSION_SESSION_KEY = "userPermission";
	private static final String NOT_FINISHED_EVALUATION_FORM_SESSION_KEY = "notFinishedEvaluationForm";
	
	private String username;
    private String password;
    private String confirmPass;
    //private String sys;
    private Integer system;
    
    private UserService userService;
    private DepartmentService deptService;
    private TaskService taskService;
	private PmTaskService pmTaskService;
	private PmTableService pmTableService;
	private CustomerService customerService;
	private UserLoginInformationService userLoginInformationService;
	
	private BuildCompanyStructure buildCompanyStructure;
	private LoadChineseCharactersListXml loadChineseCharactersListXml;
	private BASE64 base64;
	private UserPermissionService userPermissionService;
	private EvaluationFormService evaluationFormService;
	
	private UserInformation userInformation;
	private HttpSession session;
	private User user;
	
	public LoadChineseCharactersListXml getLoadChineseCharactersListXml() {
		return loadChineseCharactersListXml;
	}
	public void setLoadChineseCharactersListXml(
			LoadChineseCharactersListXml loadChineseCharactersListXml) {
		this.loadChineseCharactersListXml = loadChineseCharactersListXml;
	}
	
    
    private static Logger logger = Logger.getLogger(LoginAction.class);
    
	public BuildCompanyStructure getBuildCompanyStructure() {
		return buildCompanyStructure;
	}
	public void setBuildCompanyStructure(BuildCompanyStructure buildCompanyStructure) {
		this.buildCompanyStructure = buildCompanyStructure;
	}
	
	
    public LoginAction() {
		// TODO Auto-generated constructor stub
    	System.out.println("LoginAction create!");
    	
    	this.session=ServletActionContext.getRequest().getSession();
	}
    public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String execute() throws Exception{
		logger.info("login");
		
		user = userService.findUserByName(username);
    	session.setAttribute("user", user);
    	
    	/*if(userInformation != null){
    		session.setAttribute(USER_INFORMATION_SESSION_KEY, userInformation);
    		UserPermission userPermission = userPermissionService.getUserPermissionById(userInformation.getUserConfigInformation().getPermission());
    		session.setAttribute(USER_PERMISSION_SESSION_KEY, userPermission);
    		List<EvaluationForm> notFinishedEvaluationForm = evaluationFormService.getNotFinishedEvaluationFormByUserId(userInformation.getId());
    		session.setAttribute(NOT_FINISHED_EVALUATION_FORM_SESSION_KEY, notFinishedEvaluationForm);
    	}*/
    	
    	//HttpServletRequest request = ServletActionContext.getRequest();
    	//System.out.println("path:"+request.getContextPath());
    	//System.out.println("path:"+getClass().getClassLoader().getResource("com/jingrui/xml/user").getPath());
    	
    	//system.out.println("");
    	String redirectString = jumpToSubsystem();
    	
    	return redirectString;
    	
    	/*if(sys.equals("1")){
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
    	}else if(sys.equals("4")){
    		
    		
    		return "bossVisualAngle";
    	}
    	else{
    		return "login";
    	}*/
    		//return "loginSuccess";
    	
    }
	
	public void initPermissionSystem(){
		
	}
	
	public String jumpToSubsystem(){
		switch(system){
	    case PERFORMANCE_APPRAISCAL_SYSTEM:
	    	
	    	handleBeforeLoginPerformanceAppraiscalSystem();
	    	
    		return "performanceMeasurement";
    		
	    case CUSTOMER_MESSAGE_SYSTEM:
	    	
	    	handleBeforeLoginCustomerMessageSystem();
    		
            return "customerList";
	    case POINTS_MANAGEMENT_SYSTEM:
	    	
	    	handleBeforeLoginPointsManagementSystem();
    		    	 
    		return "scoreList";
	    case BOSS_VISUAL_ANGLE_SYSTEM:
	    	
	    	return "bossVisualAngle";
	    	
	    default:
	    	return "login";
	
	    }
	}
	
	public void handleBeforeLoginPerformanceAppraiscalSystem(){
		List<PmTable> current_user_not_finished_pmtables = pmTableService.queryNotFinishedByUser(user);
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
		
		Long currentUserFinishedTotalPmTableCount = pmTableService.getFinishedTotalCountByUser(user);
		Page current_user_finished_pmtable_page = PageUtil.createPage(25, currentUserFinishedTotalPmTableCount, 1);
		List<PmTable> current_user_finished_pmtables = pmTableService.queryFinishedByPageAndUser(current_user_finished_pmtable_page, user);
		List<PmTask> current_user_pmtask = pmTaskService.getPmTasksByUser(user);
		
		session.setAttribute("current_user_finished_pmtable_page", current_user_finished_pmtable_page);
		session.setAttribute("current_user_finished_pmtables", current_user_finished_pmtables);
		session.setAttribute("current_user_pmtask", current_user_pmtask);
		
		Long totalPmTaskCount = pmTaskService.getTotalCount();
		Page pmtask_page = PageUtil.createPage(10, totalPmTaskCount, 1);
		List<PmTask> tasks = pmTaskService.queryByPage(pmtask_page);
		session.setAttribute("pmtask_page", pmtask_page);
		session.setAttribute("allPmTask", tasks);
		
	}
	
    public void handleBeforeLoginCustomerMessageSystem(){
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
	}
    
    public void handleBeforeLoginPointsManagementSystem(){
		
    	List<Task> taskList_1 = taskService.getApproveTask();
		session.setAttribute("approveTaskList", taskList_1);
		
		TreeMap<String,Integer> statisticsTable=StatisticsHelper.getStatistics(user.getNoticePeoplesForUserId());
		session.setAttribute("statisticsTable", statisticsTable);
		    	 
		List<String> months = new ArrayList<String>();
		Set<NoticePeople> noticePeoples = user.getNoticePeoplesForUserId();
		for (NoticePeople np : noticePeoples) {
		    String month = np.getTaskByTaskId().getDate().substring(0, 7);
		    if(!months.contains(month)){
		        months.add(month);
		    }
		}
		session.setAttribute("months", months);   
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = format.format(new Date());
		List<NoticePeople> nps = StatisticsHelper.getNoticePeoplesByMonth(date.substring(0, 7),user.getNoticePeoplesForUserId());
		session.setAttribute("nps", nps);
    	
	}
	
    public void validateExecute() {
    	try{
    		System.out.println("validate:"+username);
    		this.clearErrorsAndMessages();
    	    if(username.equals(EMPTY_STRING)){
			    this.addFieldError(ERROR, loadChineseCharactersListXml.getNodeListMap().get(USERNAME_CAN_NOT_EMPTY_KEY));
		    }
    	    if(password.equals(EMPTY_STRING)){
			    this.addFieldError(ERROR, loadChineseCharactersListXml.getNodeListMap().get(PASSWORD_CAN_NOT_EMPTY_KEY));
		    }
    	    if(system == LOGIN_SYSTEM_NOT_CHOOSE){
    	    	this.addFieldError(ERROR, loadChineseCharactersListXml.getNodeListMap().get(CHOOSE_LOGIN_SYSTEM_KEY));
    	    }
    	    if(!username.equals(EMPTY_STRING)&&!password.equals(EMPTY_STRING)){
    	    	User u = userService.findUserByName(username);
        	    if(null==u){
        	    	this.addFieldError("error", "用户不存在");
        	    }
        	    else{
        	    	if(!u.getPassword().equals(password)){
            	    	this.addFieldError("error", "密码不正确");
            	    }
        	    }
    	    	/*
    	    	userInformation = buildCompanyStructure.getUserInformationByUsername(username);
    	    	if(userInformation != null){
    	    		System.out.println("name:"+userInformation.getUserResumeInformation().getName());
    	    		
    	    		UserLoginInformation userLoginInformation = userLoginInformationService.getUserLoginInformationByUserId(userInformation.getId());
    	    		if(userLoginInformation == null){
    	    			this.addFieldError(ERROR, loadChineseCharactersListXml.getNodeListMap().get(INIT_PASSWORD_NOT_EXIST_KEY));
    	    		}else{
    	    			String dbPassword = new String(base64.decryptBASE64(userLoginInformation.getPassword()));
    	    			
        	    		if(!dbPassword.equals(password)){
        	    			this.addFieldError(ERROR, loadChineseCharactersListXml.getNodeListMap().get(PASSWORD_ERROR_KEY));
        	    		}
    	    		}
    	    	}else{
    	    		this.addFieldError(ERROR, loadChineseCharactersListXml.getNodeListMap().get(USERNAME_NOT_EXISTS_KEY));
    	    	}*/
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
		ServletActionContext.getRequest().getSession().removeAttribute(USER_INFORMATION_SESSION_KEY);
		ServletActionContext.getRequest().getSession().removeAttribute(USER_PERMISSION_SESSION_KEY);
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
	/*public String getSys() {
		return sys;
	}
	public void setSys(String sys) {
		this.sys = sys;
	}*/
	
	public Integer getSystem() {
		return system;
	}
	public void setSystem(Integer system) {
		this.system = system;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public UserLoginInformationService getUserLoginInformationService() {
		return userLoginInformationService;
	}
	public void setUserLoginInformationService(
			UserLoginInformationService userLoginInformationService) {
		this.userLoginInformationService = userLoginInformationService;
	}
	
	public BASE64 getBase64() {
		return base64;
	}
	public void setBase64(BASE64 base64) {
		this.base64 = base64;
	}
	public UserPermissionService getUserPermissionService() {
		return userPermissionService;
	}
	public void setUserPermissionService(UserPermissionService userPermissionService) {
		this.userPermissionService = userPermissionService;
	}
	public EvaluationFormService getEvaluationFormService() {
		return evaluationFormService;
	}
	public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
		this.evaluationFormService = evaluationFormService;
	}
}
