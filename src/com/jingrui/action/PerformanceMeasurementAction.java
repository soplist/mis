package com.jingrui.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class PerformanceMeasurementAction extends ActionSupport{

	private UserService userService;
	private SettingService settingService;
	private JoininService joininService;
	private PmTaskService pmTaskService;
	private PmTableService pmTableService;
	
	private Float item1;
	private Float item2;
	private Float item3;
	private Float item4;
	private Float item5;
	private Float item6;
	private Float item7;
	private Float item8;
	private Float item9;
	private Float item10;
	private Float item11;
	private Float item12;
	private Float item13;
	
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
	
	public Float getItem1() {
		return item1;
	}
	public void setItem1(Float item1) {
		this.item1 = item1;
	}
	public Float getItem2() {
		return item2;
	}
	public void setItem2(Float item2) {
		this.item2 = item2;
	}
	public Float getItem3() {
		return item3;
	}
	public void setItem3(Float item3) {
		this.item3 = item3;
	}
	public Float getItem4() {
		return item4;
	}
	public void setItem4(Float item4) {
		this.item4 = item4;
	}
	public Float getItem5() {
		return item5;
	}
	public void setItem5(Float item5) {
		this.item5 = item5;
	}
	public Float getItem6() {
		return item6;
	}
	public void setItem6(Float item6) {
		this.item6 = item6;
	}
	public Float getItem7() {
		return item7;
	}
	public void setItem7(Float item7) {
		this.item7 = item7;
	}
	public Float getItem8() {
		return item8;
	}
	public void setItem8(Float item8) {
		this.item8 = item8;
	}
	public Float getItem9() {
		return item9;
	}
	public void setItem9(Float item9) {
		this.item9 = item9;
	}
	public Float getItem10() {
		return item10;
	}
	public void setItem10(Float item10) {
		this.item10 = item10;
	}
	public Float getItem11() {
		return item11;
	}
	public void setItem11(Float item11) {
		this.item11 = item11;
	}
	public Float getItem12() {
		return item12;
	}
	public void setItem12(Float item12) {
		this.item12 = item12;
	}
	public Float getItem13() {
		return item13;
	}
	public void setItem13(Float item13) {
		this.item13 = item13;
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
	
	public String previousManagerOrCompanyEvaluate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = (Map)ActionContext.getContext().getSession();
		
		String type = request.getParameter("managerEvaluateOrCompanyEvaluate");
		session.remove("managerEvaluateOrCompanyEvaluate");
		session.put("managerEvaluateOrCompanyEvaluate", type);
		
		return "evaluate";
	}
	
	public String previousEvaluate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String pm_table_id = request.getParameter("pm_table_id");
		String type = request.getParameter("type");
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
		if(type.equals("1"))
		    return "evaluate";
		else if(type.equals("2")){
			return "evaluate_1";
		}
		else{
			return "evaluate_2";
		}
			
	}
	
	public String evaluate1(){
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
		if(null!=pt){
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
		    pt.setSimple(false);
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
		
		return "login";
	}
	
	public String evaluate2(){
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
		pt.setItem11(item11);
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
	
	public String evaluate3(){
		Map session = (Map)ActionContext.getContext().getSession();
		PmTable pt = (PmTable) session.get("table");
		if(null!=pt){
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
		    pt.setItem11(item11);
		    pt.setItem12(item12);
		    pt.setItem13(item13);
		    pt.setStatu(true);
		    pt.setSimple(false);
		    pmTableService.update(pt);
		    
		    PmTask pmTask = pt.getPmTaskByTid();
			pmTask.setStatu(true);
		    pmTaskService.update(pmTask);
			
			return "success";
		}
		
		return "login";
	}
	
	public String evaluate4(){
		Map session = (Map)ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		
		System.out.println("type:"+type);
		System.out.println("data:"+data);
		
		String[] idAndscore = data.split(",");
		
		if(type.equals("3")){
			List<PmTable> managerPmTables = (List<PmTable>) session.get("managerPmTables");
			for(int i=0;i<idAndscore.length;i+=2){
				String id = idAndscore[i];
				String score = idAndscore[i+1];
				Integer int_id = Integer.parseInt(id);
				Float float_score = Float.parseFloat(score);
				PmTable currentPtTable = null;
				for (PmTable pmTable : managerPmTables) {
					if(pmTable.getPid().equals(int_id)){
						currentPtTable = pmTable;
						break;
					}
				}
				currentPtTable.setItem11(float_score);
				currentPtTable.setStatu(true);
				
				pmTableService.update(currentPtTable);
			}
		}
        if(type.equals("4")){
        	List<PmTable> companyPmTables = (List<PmTable>) session.get("companyPmTables");
        	for(int i=0;i<idAndscore.length;i+=2){
				String id = idAndscore[i];
				String score = idAndscore[i+1];
				Integer int_id = Integer.parseInt(id);
				Float float_score = Float.parseFloat(score);
				PmTable currentPtTable = null;
				for (PmTable pmTable : companyPmTables) {
					if(pmTable.getPid().equals(int_id)){
						currentPtTable = pmTable;
						break;
					}
				}
				currentPtTable.setItem11(float_score);
				currentPtTable.setStatu(true);
				
				pmTableService.update(currentPtTable);
			}
		}
			
		return "success";
	}
	
	public String launchTask(){
		try{
		    HttpServletRequest request = ServletActionContext.getRequest();
		    Map session = (Map)ActionContext.getContext().getSession();
		
		
		    String user_id = request.getParameter("user_id");
		    Integer int_user_id = Integer.parseInt(user_id);
		    List<User> allUsers = (List<User>) session.get("userList");
		    List<User> inDepartmentUsers = new ArrayList<User>();
		    List<User> outDepartmentUsers = new ArrayList<User>();
		    List<User> managers = new ArrayList<User>();
		    
		    User user_1 = null;
		    for (User u : allUsers) {
			    if(u.getUid().equals(int_user_id)){
				    user_1 = u;
			    }
		    }
		    
		    DateFormat format1 = new SimpleDateFormat("yyyy-MM");
	        String month = format1.format(new Date());
	        boolean exist = pmTaskService.currentMonthPMExist(user_1, month);
	        if(exist){
	        	HttpServletResponse  response=ServletActionContext.getResponse();
	            response.setContentType("text/html;charset=UTF-8");
	    		try {
	    			PrintWriter out=response.getWriter();
	    			out.println("exist");
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		return null;
	        }
		    
		    for(User u : allUsers){
			    if(u.getDepartment().getDid().equals(user_1.getDepartment().getDid())){
				    inDepartmentUsers.add(u);
			    }else{
				    outDepartmentUsers.add(u);
			    }
		    }
		    
		    
		    PmTask pt = new PmTask();
		    pt.setOptionsBySid(user_1.getOption());
		    pt.setStatu(false);
		    pt.setUserByUid(user_1);
		    pt.setLaunchTime(new Date());
		    Integer pt_id = pmTaskService.add(pt);
		    System.out.println("pt_id:"+pt_id);
		    
		    
		    if(user_1.getIsboss()){
		    	PmTable companyEvaluate = new PmTable();
		        companyEvaluate.setUserByUid(user_1);
		        companyEvaluate.setPmTaskByTid(pt);
		        companyEvaluate.setStatu(false);
		        companyEvaluate.setType(4);
		        companyEvaluate.setSimple(true);
		        pmTableService.add(companyEvaluate);
		    }else{
		    	for(User u : allUsers){
		    		if(u.getIsmanager()){
		    			managers.add(u);
		    		}
		    	}
		    }
		
		    Set<Joinin> joinins = user_1.getOption().getJoininsForSid();
		    for (Joinin joinin : joinins) {
			    PmTable pmtable = new PmTable();
			    pmtable.setUserByUid(joinin.getUserByUid());
			    pmtable.setPmTaskByTid(pt);
			    pmtable.setStatu(false);
			    pmtable.setType(joinin.getType());
			    if(joinin.getType().equals(3)||joinin.getType().equals(4))
				    pmtable.setSimple(true);
			    if(!pmtable.getType().equals(1)&&!pmtable.getType().equals(2)&&!pmtable.getType().equals(4)&&!pmtable.getType().equals(5)){
			        pmTableService.add(pmtable);
			    }
		    }
		    //add self evaluate
		    PmTable selfEvaluate = new PmTable();
		    selfEvaluate.setUserByUid(user_1);
		    selfEvaluate.setPmTaskByTid(pt);
		    selfEvaluate.setStatu(false);
		    selfEvaluate.setType(1);
		    pmTableService.add(selfEvaluate);
		
		
		    //add department evaluate
		    for (User u : inDepartmentUsers) {
			    if(!u.getUid().equals(user_1.getUid())){
			        PmTable departmentEvaluate = new PmTable();
			        departmentEvaluate.setUserByUid(u);
			        departmentEvaluate.setPmTaskByTid(pt);
			        departmentEvaluate.setStatu(false);
			        departmentEvaluate.setType(2);
			        pmTableService.add(departmentEvaluate);
			    }
		    }
		    
		    
		    //add company evaluate
		    for (User u : managers) {
			    if(!u.getUid().equals(user_1.getUid())){
			        PmTable companyEvaluate = new PmTable();
			        companyEvaluate.setUserByUid(u);
			        companyEvaluate.setPmTaskByTid(pt);
			        companyEvaluate.setStatu(false);
			        companyEvaluate.setType(4);
			        companyEvaluate.setSimple(true);
			        pmTableService.add(companyEvaluate);
			    }
		    }
		    
		
		    //add staff evaluate
		    Random rand = new Random();
		    int range = outDepartmentUsers.size();
		    UserSet user5 = new UserSet(user_1);
		    if(range>5){
		        boolean full = false;
		        while(!full){
		            int random_id = rand.nextInt(range);
		            User u = outDepartmentUsers.get(random_id);
		            full=user5.add(u);
		        }
            }else{
			    for (User u : outDepartmentUsers) {
				    user5.add(u);
			    }
		    }
		    for (User u : user5.getUserSet()) {
			    PmTable pmtable = new PmTable();
			    pmtable.setUserByUid(u);
			    pmtable.setPmTaskByTid(pt);
			    pmtable.setStatu(false);
			    pmtable.setType(5);
			    pmTableService.add(pmtable);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "setting";
	}
	
	public String launchManagerTask(){
		try{
		    HttpServletRequest request = ServletActionContext.getRequest();
		    Map session = (Map)ActionContext.getContext().getSession();
		
		
		    String user_id = request.getParameter("user_id");
		    Integer int_user_id = Integer.parseInt(user_id);
		    List<User> allUsers = (List<User>) session.get("userList");
		    
		    User user_1 = null;
		    User boss = null;
		    for (User u : allUsers) {
			    if(u.getUid().equals(int_user_id)){
				    user_1 = u;
			    }
			    if(u.getIsboss()){
			    	boss = u;
			    }
		    }
		    
		    PmTask pt = new PmTask();
		    pt.setOptionsBySid(user_1.getOption());
		    pt.setStatu(false);
		    pt.setUserByUid(user_1);
		    pt.setManagerEvaluate(true);
		    pt.setLaunchTime(new Date());
		    Integer pt_id = pmTaskService.add(pt);
		    
		    PmTable pmtable = new PmTable();
		    pmtable.setUserByUid(boss);
		    pmtable.setPmTaskByTid(pt);
		    pmtable.setStatu(false);
		    pmtable.setType(6);
		    pmTableService.add(pmtable);
		    
		}catch(Exception e){
			e.printStackTrace();
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
				if(u.getUid().equals(int_join_user_id)){
					user_1 = u;
				}
				if(u.getUid().equals(int_user_id)){
					user_2 = u;
				}
				
			}
			
			Set<Joinin> joinins = user_2.getOption().getJoininsForSid();
			boolean exist = false;
			for (Joinin joinin : joinins) {
				if((joinin.getType().equals(1))&&(joinin.getOptionsBySid().getSid().equals(user_2.getOption().getSid()))){
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
				if(u.getUid().equals(int_user_id)){
					user_1 = u;
				}
			}
			
			String deptJoinin = request.getParameter("deptJoinin");
			String[] deptJoinins = deptJoinin.split(",");
			List<Joinin> dbjoinins = joininService.getJoininsByTypeAndSid(Integer.parseInt(type),user_1.getOption().getSid());
			
			if(!deptJoinin.equals(""))
			for (String join : deptJoinins) {
				System.out.println("join:"+join);
				boolean exist = false;
				for (Joinin joinin : dbjoinins) {
					if((joinin.getUserByUid().getUid().equals(Integer.parseInt(join)))){
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
				if(!deptJoinin.equals(""))
				for (String join : deptJoinins) {
					if((joinin.getUserByUid().getUid().equals(Integer.parseInt(join)))){
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
				if(u.getUid().equals(int_join_user_id)){
					user_1 = u;
				}
				if(u.getUid().equals(int_user_id)){
					user_2 = u;
				}
				
			}
			
			Set<Joinin> joinins = user_2.getOption().getJoininsForSid();
			boolean exist = false;
			for (Joinin joinin : joinins) {
				if((joinin.getType().equals(3))&&(joinin.getOptionsBySid().getSid().equals(user_2.getOption().getSid()))){
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
				if(u.getUid().equals(int_join_user_id)){
					user_1 = u;
				}
				if(u.getUid().equals(int_user_id)){
					user_2 = u;
				}
				
			}
			
			Set<Joinin> joinins = user_2.getOption().getJoininsForSid();
			boolean exist = false;
			for (Joinin joinin : joinins) {
				if((joinin.getType().equals(4))&&(joinin.getOptionsBySid().getSid().equals(user_2.getOption().getSid()))){
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
				if(u.getUid().equals(int_user_id)){
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
					if((joinin.getUserByUid().getUid().equals(Integer.parseInt(join)))){
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
					if((joinin.getUserByUid().getUid().equals(Integer.parseInt(join)))){
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
			if(user.getUid().equals(intuserid)){
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
