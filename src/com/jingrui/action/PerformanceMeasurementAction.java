package com.jingrui.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.Joinin;
import com.jingrui.domain.Options;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.User;
import com.jingrui.service.JoininService;
import com.jingrui.service.PmTableService;
import com.jingrui.service.PmTaskService;
import com.jingrui.service.SettingService;
import com.jingrui.service.UserService;
import com.jingrui.util.UserSet;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PerformanceMeasurementAction  extends ActionSupport{

	private UserService userService;
	private SettingService settingService;
	private JoininService joininService;
	private PmTaskService pmTaskService;
	private PmTableService pmTableService;
	
	private Integer item1;
	private Integer item2;
	private Integer item3;
	private Integer item4;
	private Integer item5;
	private Integer item6;
	private Integer item7;
	private Integer item8;
	private Integer item9;
	private Integer item10;
	
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
	
	public Integer getItem1() {
		return item1;
	}
	public void setItem1(Integer item1) {
		this.item1 = item1;
	}
	public Integer getItem2() {
		return item2;
	}
	public void setItem2(Integer item2) {
		this.item2 = item2;
	}
	public Integer getItem3() {
		return item3;
	}
	public void setItem3(Integer item3) {
		this.item3 = item3;
	}
	public Integer getItem4() {
		return item4;
	}
	public void setItem4(Integer item4) {
		this.item4 = item4;
	}
	public Integer getItem5() {
		return item5;
	}
	public void setItem5(Integer item5) {
		this.item5 = item5;
	}
	public Integer getItem6() {
		return item6;
	}
	public void setItem6(Integer item6) {
		this.item6 = item6;
	}
	public Integer getItem7() {
		return item7;
	}
	public void setItem7(Integer item7) {
		this.item7 = item7;
	}
	public Integer getItem8() {
		return item8;
	}
	public void setItem8(Integer item8) {
		this.item8 = item8;
	}
	public Integer getItem9() {
		return item9;
	}
	public void setItem9(Integer item9) {
		this.item9 = item9;
	}
	public Integer getItem10() {
		return item10;
	}
	public void setItem10(Integer item10) {
		this.item10 = item10;
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
	
	public String previousEvaluate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String pm_table_id = request.getParameter("pm_table_id");
		Integer int_pm_table_id = Integer.parseInt(pm_table_id);
		//session.user.pmTablesForUid
		Map session = (Map)ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		Set<PmTable> tableList = user.getPmTablesForUid();
		
		PmTable pt_1 = null;
		for (PmTable pmTable : tableList) {
			System.out.println(pmTable.getPid()+","+int_pm_table_id+":"+(pmTable.getPid()==int_pm_table_id));
			if(pmTable.getPid().equals(int_pm_table_id)){
				pt_1 = pmTable;
			}
		}
		
		session.remove("table");
		session.put("table", pt_1);
		return "evaluate";
	}
	
	public String evaluate(){
		/*System.out.println(date);
		System.out.println(item1);
		System.out.println(item2);
		System.out.println(item3);
		System.out.println(item4);
		System.out.println(item5);
		System.out.println(item6);
		System.out.println(item7);
		System.out.println(item8);
		System.out.println(item9);
		System.out.println(item10);*/
		Map session = (Map)ActionContext.getContext().getSession();
		PmTable pt = (PmTable) session.get("table");
		pt.setItem1(item1);
		pt.setItem2(item2);
		pt.setItem3(item3);
		pt.setItem4(item4);
		pt.setItem5(item5);
		pt.setItem6(item6);
		pt.setItem7(item7);
		pt.setItem8(item8);
		pt.setItem9(item9);
		pt.setItem10(item10);
		pt.setStatu(true);
		
		pmTableService.update(pt);
		List<PmTable> pmTableList = pmTableService.getPmTableByPmTaskId(pt.getPmTaskByTid().getPid());
		boolean passed = true;
	    for (PmTable pmTable : pmTableList) {
			if(!pmTable.isStatu()){
				passed = false;
				break;
			}
		}
	    
	    if(passed){
	    	PmTask pmTask = pt.getPmTaskByTid();
		    pmTask.setStatu(true);
	    	pmTaskService.update(pmTask);
	    }
		
		
		return "success";
	}
	
	public String launchTask(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map)ActionContext.getContext().getSession();
		String user_id = request.getParameter("user_id");
		Integer int_user_id = Integer.parseInt(user_id);
		List<User> users = (List<User>) session.get("userList");
		
		User user_1 = null;
		for (User u : users) {
			if(u.getUid().equals(int_user_id)){
				user_1 = u;
			}
		}
		
		PmTask pt = new PmTask();
		pt.setOptionsBySid(user_1.getOption());
		pt.setStatu(false);
		pt.setUserByUid(user_1);
		Integer pt_id = pmTaskService.add(pt);
		System.out.println("pt_id:"+pt_id);
		
		Set<Joinin> joinins = user_1.getOption().getJoininsForSid();
		for (Joinin joinin : joinins) {
			PmTable pmtable = new PmTable();
			pmtable.setUserByUid(joinin.getUserByUid());
			pmtable.setPmTaskByTid(pt);
			pmtable.setStatu(false);
			pmtable.setType(joinin.getType());
			if(!pmtable.getType().equals(5)){
			    pmTableService.add(pmtable);
			}
		}
		
		//add company staff evaluate
		Random rand = new Random();
		int range = users.size();
		UserSet user3 = new UserSet();
		boolean full = false;
		while(!full){
		    int random_id = rand.nextInt(range);
		    User u = users.get(random_id);
		    full=user3.add(u);
		}
		for (User u : user3.getUserSet()) {
			PmTable pmtable = new PmTable();
			pmtable.setUserByUid(u);
			pmtable.setPmTaskByTid(pt);
			pmtable.setStatu(false);
			pmtable.setType(5);
			pmTableService.add(pmtable);
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
		if(type.equals("4")){
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
				if((joinin.getType()==4)&&(joinin.getOptionsBySid().getSid()==user_2.getOption().getSid())){
					joinin.setUserByUid(user_1);
					joininService.update(joinin);
					exist = true;
				}
			}
			if(!exist){
				Joinin joinin = new Joinin();
				joinin.setType(4);
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
