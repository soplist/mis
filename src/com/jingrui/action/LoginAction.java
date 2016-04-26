package com.jingrui.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jingrui.domain.Area;
import com.jingrui.domain.User;
import com.jingrui.service.DepartmentService;
import com.jingrui.service.UserService;
import com.opensymphony.xwork2.ActionContext;


public class LoginAction {
	private Integer uid;
	private String username;
    private String password;
    private String confirmPass;
    private String realName;
    private String sys;
    private UserService userService;
    private DepartmentService deptService;
    
    private static Logger logger = Logger.getLogger(LoginAction.class);
    
    public DepartmentService getDeptService() {
		return deptService;
	}
	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
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
    	if(""!=username&&""!=password){
    		User u = userService.findUserByName(username);
    		if(null!=u && password.equals(u.getPassword())){
    		     System.out.println("user name:"+u.getName()+", password:"+u.getPassword());
    		     Map session = (Map)ActionContext.getContext().getSession();
    		     session.put("user",u);
    		     if(sys.equals("1")){
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
    		     }else{
    		    	 return "scoreList";
    		     }
    		}else{
    			return "login";
    		}
    		//return "loginSuccess";
    	}
    	else{
    		return "login";
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
	
}
