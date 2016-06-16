package com.jingrui.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.Joinin;
import com.jingrui.domain.Options;
import com.jingrui.domain.User;
import com.jingrui.service.JoininService;
import com.jingrui.service.SettingService;
import com.jingrui.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PerformanceMeasurementAction  extends ActionSupport{

	private UserService userService;
	private SettingService settingService;
	private JoininService joininService;
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6900409075716490995L;

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public SettingService getSettingService() {
		return settingService;
	}
	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}
	public JoininService getJoininService() {
		return joininService;
	}
	public void setJoininService(JoininService joininService) {
		this.joininService = joininService;
	}
	
	public String getAllPmSetting(){
		try{
			Map session = (Map)ActionContext.getContext().getSession();
			List<User> users = userService.findAllUser();
	   	    session.put("userList", users);
	   	    System.out.println("DeptEvaluate:"+users.get(0).getOption().getDeptEval());
	   	    System.out.println("SelfEvaluate:"+users.get(0).getOption().getSelfEval());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "setting";
	}
	
	public String updateJoinin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map)ActionContext.getContext().getSession();
		String type = request.getParameter("type");
		List<User> users = (List<User>) session.get("userList");
		if(type.equals("1")){
			String joinin_1 = request.getParameter("joinin_1");
			String user_id = request.getParameter("user_id");
			Integer int_join_user_id = Integer.parseInt(joinin_1);
			Integer int_user_id = Integer.parseInt(user_id);
			
			User user_1 = null;
			User user_2 = null;
			for (User u : users) {
				if(u.getUid()==int_join_user_id){
					user_1 = u;
				}
				if(u.getUid()==int_user_id){
					user_2 = u;
				}
				
			}
			
			Set<Joinin> joinins = user_2.getOption().getJoininsForSid();
			boolean exist = false;
			for (Joinin joinin : joinins) {
				if((joinin.getType()==1)&&(joinin.getOptionsBySid().getSid()==user_2.getOption().getSid())){
					joinin.setUserByUid(user_1);
					joininService.update(joinin);
					exist = true;
				}
			}
			if(!exist){
				Joinin joinin = new Joinin();
				joinin.setType(1);
				joinin.setUserByUid(user_1);
				joinin.setOptionsBySid(user_2.getOption());
				joininService.insert(joinin);
			}
			
		}
		else if(type.equals("2")){
			String user_id = request.getParameter("user_id");
			Integer int_user_id = Integer.parseInt(user_id);
			User user_1 = null;
			for (User u : users) {
				if(u.getUid()==int_user_id){
					user_1 = u;
				}
			}
			
			String deptJoinin = request.getParameter("deptJoinin");
			if(deptJoinin.equals(""))
				return "setting";
			String[] deptJoinins = deptJoinin.split(",");
			List<Joinin> dbjoinins = joininService.getJoininsByTypeAndSid(Integer.parseInt(type),user_1.getOption().getSid());
			for (String join : deptJoinins) {
				System.out.println("join:"+join);
				boolean exist = false;
				for (Joinin joinin : dbjoinins) {
					if((joinin.getUserByUid().getUid()==Integer.parseInt(join))){
						exist = true;
						break;
					}
				}
				if(!exist){
					Joinin j = new Joinin();
					j.setType(2);
					j.setOptionsBySid(user_1.getOption());
					User u = new User();
					u.setUid(Integer.parseInt(join));
					j.setUserByUid(u);
					joininService.insert(j);
				}
			}
			
			for (Joinin joinin : dbjoinins) {
				boolean exist = false;
				for (String join : deptJoinins) {
					if((joinin.getUserByUid().getUid()==Integer.parseInt(join))){
						exist = true;
						break;
					}
				}
				if(!exist){
					joininService.delete(joinin);
				}
			}
		}
		if(type.equals("3")){
			String joinin_1 = request.getParameter("joinin_1");
			String user_id = request.getParameter("user_id");
			Integer int_join_user_id = Integer.parseInt(joinin_1);
			Integer int_user_id = Integer.parseInt(user_id);
			
			User user_1 = null;
			User user_2 = null;
			for (User u : users) {
				if(u.getUid()==int_join_user_id){
					user_1 = u;
				}
				if(u.getUid()==int_user_id){
					user_2 = u;
				}
				
			}
			
			Set<Joinin> joinins = user_2.getOption().getJoininsForSid();
			boolean exist = false;
			for (Joinin joinin : joinins) {
				if((joinin.getType()==3)&&(joinin.getOptionsBySid().getSid()==user_2.getOption().getSid())){
					joinin.setUserByUid(user_1);
					joininService.update(joinin);
					exist = true;
				}
			}
			if(!exist){
				Joinin joinin = new Joinin();
				joinin.setType(3);
				joinin.setUserByUid(user_1);
				joinin.setOptionsBySid(user_2.getOption());
				joininService.insert(joinin);
			}
			
		}
		else if(type.equals("5")){
			String user_id = request.getParameter("user_id");
			Integer int_user_id = Integer.parseInt(user_id);
			User user_1 = null;
			for (User u : users) {
				if(u.getUid()==int_user_id){
					user_1 = u;
				}
			}
			
			String companyJoinin = request.getParameter("companyJoinin");
			if(companyJoinin.equals(""))
				return "setting";
			String[] companyJoinins = companyJoinin.split(",");
			List<Joinin> dbjoinins = joininService.getJoininsByTypeAndSid(Integer.parseInt(type),user_1.getOption().getSid());
			for (String join : companyJoinins) {
				System.out.println("join:"+join);
				boolean exist = false;
				for (Joinin joinin : dbjoinins) {
					if((joinin.getUserByUid().getUid()==Integer.parseInt(join))){
						exist = true;
						break;
					}
				}
				if(!exist){
					Joinin j = new Joinin();
					j.setType(5);
					j.setOptionsBySid(user_1.getOption());
					User u = new User();
					u.setUid(Integer.parseInt(join));
					j.setUserByUid(u);
					joininService.insert(j);
				}
			}
			
			for (Joinin joinin : dbjoinins) {
				boolean exist = false;
				for (String join : companyJoinins) {
					if((joinin.getUserByUid().getUid()==Integer.parseInt(join))){
						exist = true;
						break;
					}
				}
				if(!exist){
					joininService.delete(joinin);
				}
			}
		}
		return "setting";
	}
	
	public String updatePercentage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map)ActionContext.getContext().getSession();
		
		String per = request.getParameter("per");
		String userid = request.getParameter("uid");
		String kind = request.getParameter("kind");
		Integer intper = Integer.parseInt(per);
		Integer intuserid = Integer.parseInt(userid);
		
		List<User> users = (List<User>) session.get("userList");
		User currentUser=null;
		for (User user : users) {
			if(user.getUid()==intuserid){
				currentUser = user;
			}
		}
		Options opt = currentUser.getOption();
		int old_optid = opt.getSid();
		if(kind.equals("1"))
		    opt.setSelfEval(intper);
		if(kind.equals("2"))
		    opt.setDeptEval(intper);
		if(kind.equals("3"))
		    opt.setManagerEval(intper);
		if(kind.equals("4"))
		    opt.setCompanyEval(intper);
		if(kind.equals("5"))
		    opt.setColleaguesEval(intper);
		opt.setSettingTime(new Date());
		Integer settingid = settingService.insertSetting(opt);
		joininService.updateSidBySid(old_optid, settingid);
		
		currentUser.getOption().setSid(settingid);
		userService.update(currentUser);
		System.out.println("per:"+intper);
		
		System.out.println("setting id:"+settingid);
		System.out.println("userid:"+intuserid);
		
		session.remove("userList");
		List<User> users_1 = userService.findAllUser();
   	    session.put("userList", users_1);
		return "setting";
	}
	
}
