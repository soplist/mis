package com.jingrui.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.Department;
import com.jingrui.domain.ManagerEvaluateSetting;
import com.jingrui.domain.Options;
import com.jingrui.domain.Permission;
import com.jingrui.domain.User;
import com.jingrui.domain.UserInformation;
import com.jingrui.domain.UserLoginInformation;
import com.jingrui.service.DepartmentService;
import com.jingrui.service.ManagerEvaluateSettingService;
import com.jingrui.service.PermissionService;
import com.jingrui.service.SettingService;
import com.jingrui.service.UserLoginInformationService;
import com.jingrui.service.UserService;
import com.jingrui.util.BASE64;
import com.jingrui.util.LoadChineseCharactersListXml;
import com.jingrui.util.Message;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: AccountAction.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-12 ÏÂÎç3:09:36
 */

public class AccountAction extends ActionSupport{
	
	private PermissionService permissionService;
    private UserService userService;
    private DepartmentService departmentService;
    private SettingService settingService;
    private ManagerEvaluateSettingService managerEvaluateSettingService;
    
	private HttpSession session;
	private String password;
	
	private static final String USER_INFORMATION_SESSION_KEY = "userInformation";
	private static final String UPDATE_PASSWORD_SUCCESS_KEY = "update_password_message_1";
	private static final String USER_NOT_EXIST_KEY = "update_password_message_2";
	private static final String MESSAGE_SESSION_KEY = "message";
	
	private static final Integer INIT_SELF_EVAL = 10;
	private static final Integer INIT_DEPARTMENT_EVAL = 25;
	private static final Integer INIT_MANAGER_EVAL = 30;
	private static final Integer INIT_COMPANY_EVAL = 25;
	private static final Integer INIT_COLLEAGUES_EVAL = 10;
	
	private static final float INIT_MANAGER_EVALUATE_SETTING_ITEM_1 = 0;
	private static final float INIT_MANAGER_EVALUATE_SETTING_ITEM_6 = 0;
	private static final float INIT_MANAGER_EVALUATE_SETTING_ITEM_12 = 0;
	private static final float INIT_MANAGER_EVALUATE_SETTING_ITEM_13 = 0;
	
	private UserLoginInformationService userLoginInformationService;
	
	private LoadChineseCharactersListXml loadChineseCharactersListXml;
	
	private Message message;
	private BASE64 base64;
	
	public AccountAction(){
		this.session=ServletActionContext.getRequest().getSession();
	}
	
	public String beforeAddUserAccount(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Permission> allPermission = permissionService.getAll();
		List<Department> departmentList = departmentService.listDptm();
	    request.setAttribute("departmentList",departmentList);
		request.setAttribute("allPermission", allPermission);
		return "success";
	}
	
	public String userSwitch(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Boolean value = Boolean.valueOf(request.getParameter("value"));
		String userId = request.getParameter("userId");
		System.out.println("value:"+value+",userId"+userId);
		
		User user = userService.getUserById(new Integer(userId));
		user.setValidity(!value);
		
		userService.update(user);
		
		return "success";
	}
	
	public String addUserAccount(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String real_name = request.getParameter("real_name");
		String permission = request.getParameter("permission");
		String department = request.getParameter("department");
		String manager = request.getParameter("manager");
		String boss = request.getParameter("boss");
		String position = request.getParameter("position");
		String joined_time = request.getParameter("joined_time");
		String validity = request.getParameter("validity");
		System.out.println("accept---username:password:"+password+",real_name:"+real_name+",permission:"+permission+",department:"+department+",manager:"+manager+",boss:"+boss+",position:"+position+",joined_time:"+joined_time+",validity:"+validity);
		
		Options initOption = new Options();
		initOption.setSettingTime(new Date());
		initOption.setSelfEval(INIT_SELF_EVAL);
		initOption.setDeptEval(INIT_DEPARTMENT_EVAL);
		initOption.setManagerEval(INIT_MANAGER_EVAL);
		initOption.setCompanyEval(INIT_COMPANY_EVAL);
		initOption.setColleaguesEval(INIT_COLLEAGUES_EVAL);
		Integer settingId = settingService.insertSetting(initOption);
		
		ManagerEvaluateSetting initManagerEvaluateSetting = new ManagerEvaluateSetting();
		initManagerEvaluateSetting.setItem1(INIT_MANAGER_EVALUATE_SETTING_ITEM_1);
		initManagerEvaluateSetting.setItem6(INIT_MANAGER_EVALUATE_SETTING_ITEM_6);
		initManagerEvaluateSetting.setItem12(INIT_MANAGER_EVALUATE_SETTING_ITEM_12);
		initManagerEvaluateSetting.setItem13(INIT_MANAGER_EVALUATE_SETTING_ITEM_13);
		Integer managerEvaluateSettingId = managerEvaluateSettingService.insert(initManagerEvaluateSetting);
		
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setRealName(real_name);
		
		Permission p = new Permission();
		p.setPid(new Integer(permission));
		user.setPermission(p);
		
		Department d = new Department();
		d.setDid(new Integer(department));
		user.setDepartment(d);
		
		Options option = new Options();
		option.setSid(settingId);
		user.setOption(option);
		
		user.setIsmanager(Boolean.valueOf(manager));
		user.setIsboss(Boolean.valueOf(boss));
		user.setPosition(position);
		
		try {
			user.setJoined(new SimpleDateFormat("yyyy-MM-dd").parse(joined_time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ManagerEvaluateSetting managerEvaluateSetting = new ManagerEvaluateSetting();
		managerEvaluateSetting.setMid(managerEvaluateSettingId);
		user.setManagerEvaluateSetting(managerEvaluateSetting);
		
		user.setValidity(Boolean.valueOf(validity));
		
		userService.add(user);
		
		return "success";
	}

	public String updatePassword(){
		UserInformation userInformation = (UserInformation) session.getAttribute(USER_INFORMATION_SESSION_KEY);
		if(userInformation != null){
			UserLoginInformation userLoginInformation = userLoginInformationService.getById(userInformation.getId());
			
			if(userLoginInformation == null){
			    
			    try {
			    	UserLoginInformation newUserLoginInformation = new UserLoginInformation();
				    newUserLoginInformation.setUserId(userInformation.getId());
					newUserLoginInformation.setPassword(new String(base64.encryptBASE64(password.getBytes())));
					userLoginInformationService.add(newUserLoginInformation);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			}
			else{
				try {
				    userLoginInformation.setPassword(new String(base64.encryptBASE64(password.getBytes())));
				    userLoginInformationService.update(userLoginInformation);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			message.setContent(loadChineseCharactersListXml.getNodeListMap().get(UPDATE_PASSWORD_SUCCESS_KEY));
			session.setAttribute(MESSAGE_SESSION_KEY, message);
			
		    return "success";
		}else{
			message.setContent(loadChineseCharactersListXml.getNodeListMap().get(USER_NOT_EXIST_KEY));
			session.setAttribute(MESSAGE_SESSION_KEY, message);
			
			return "failure";
		}
		
	}
	
	public String beforeUpdatePassword(){
		return "updatePassword";
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserLoginInformationService getUserLoginInformationService() {
		return userLoginInformationService;
	}

	public void setUserLoginInformationService(
			UserLoginInformationService userLoginInformationService) {
		this.userLoginInformationService = userLoginInformationService;
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public LoadChineseCharactersListXml getLoadChineseCharactersListXml() {
		return loadChineseCharactersListXml;
	}

	public void setLoadChineseCharactersListXml(
			LoadChineseCharactersListXml loadChineseCharactersListXml) {
		this.loadChineseCharactersListXml = loadChineseCharactersListXml;
	}
	
	public BASE64 getBase64() {
		return base64;
	}

	public void setBase64(BASE64 base64) {
		this.base64 = base64;
	}
	
	public PermissionService getPermissionService() {
		return permissionService;
	}
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public SettingService getSettingService() {
		return settingService;
	}

	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}
	
	public ManagerEvaluateSettingService getManagerEvaluateSettingService() {
		return managerEvaluateSettingService;
	}

	public void setManagerEvaluateSettingService(
			ManagerEvaluateSettingService managerEvaluateSettingService) {
		this.managerEvaluateSettingService = managerEvaluateSettingService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
