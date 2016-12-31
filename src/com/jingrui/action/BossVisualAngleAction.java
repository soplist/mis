package com.jingrui.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.jingrui.dao.SqlServerDB;
import com.jingrui.dao.impl.SqlServerDBImpl;
import com.jingrui.domain.Customer;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.User;
import com.jingrui.domain.UserCustomerInfo;
import com.jingrui.domain.UserInfo;
import com.jingrui.domain.UserInfoManagerPmTask;
import com.jingrui.domain.UserInfoPmTask;
import com.jingrui.service.CustomerService;
import com.jingrui.service.PmTableService;
import com.jingrui.service.PmTaskService;
import com.jingrui.service.SqlServerService;
import com.jingrui.service.TestService;
import com.jingrui.service.UserService;
import com.jingrui.sqlserver.SqlServerDAO;
import com.jingrui.sqlserver.impl.SqlServerDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BossVisualAngleAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1069266487897023636L;
	private SqlServerService sqlServerService;
	
	private PmTaskService pmTaskService;
	private CustomerService customerService;
	private UserService userService;
	
    private List<UserInfoPmTask> pmTaskUserList;
	private List<UserInfo> userList;
	private List<UserInfoManagerPmTask> managerPmTaskUserList;
	
	private List<UserCustomerInfo> customerMessageInputList;
	
	@JSON(serialize=false)
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@JSON(serialize=false)
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public List<UserCustomerInfo> getCustomerMessageInputList() {
		return customerMessageInputList;
	}

	public void setCustomerMessageInputList(
			List<UserCustomerInfo> customerMessageInputList) {
		this.customerMessageInputList = customerMessageInputList;
	}

	public List<UserInfoManagerPmTask> getManagerPmTaskUserList() {
		return managerPmTaskUserList;
	}

	public void setManagerPmTaskUserList(
			List<UserInfoManagerPmTask> managerPmTaskUserList) {
		this.managerPmTaskUserList = managerPmTaskUserList;
	}

	public List<UserInfo> getUserList() {
	    return userList;
	}

	public void setUserList(List<UserInfo> userList) {
	    this.userList = userList;
	}
	
	public List<UserInfoPmTask> getPmTaskUserList() {
		return pmTaskUserList;
	}

	public void setPmTaskUserList(List<UserInfoPmTask> pmTaskUserList) {
		this.pmTaskUserList = pmTaskUserList;
	}
	
	@JSON(serialize=false)
	public PmTaskService getPmTaskService() {
		return pmTaskService;
	}

	public void setPmTaskService(PmTaskService pmTaskService) {
		this.pmTaskService = pmTaskService;
	}
	@JSON(serialize=false)
	public SqlServerService getSqlServerService() {
		return sqlServerService;
	}

	public void setSqlServerService(SqlServerService sqlServerService) {
		this.sqlServerService = sqlServerService;
	}

	

    

	//if use method name start with 'get',ajax will request twice
	public String catchPointsChartData() throws Exception{
    	//String result = "{\"employees\": [{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" },{ \"firstName\":\"George\" , \"lastName\":\"Bush\" },{ \"firstName\":\"Thomas\" , \"lastName\":\"Carter\" }]}";
    	//HttpServletResponse response = ServletActionContext.getResponse();
		//response.setContentType("application/json; charset=UTF-8");
		//response.setHeader("Cache-Control", "no-cache");
		//PrintWriter out = response.getWriter();
		//out.print(result);

		//System.out.println("result = " + result);
		//out.flush();
		//out.close();
		userList = sqlServerService.catchUser();  
		//sqlServerDAO = new SqlServerDAOImpl();
		//sqlServerDB = new SqlServerDBImpl();
		//sqlServerDB.query();
		System.out.println("catchPointsChartData"); 
		return SUCCESS;  
    }

	
	public String catchPmTaskData() throws Exception{
		List<PmTask> list = pmTaskService.queryPmTaskLastMonth();
		pmTaskUserList = encapsulatesPmTask(list);
		return SUCCESS;
	}
	
	public String catchManagerPmTaskData() throws Exception{
		List<PmTask> list = pmTaskService.queryManagerPmTaskLastMonth();
		managerPmTaskUserList = encapsulatesManagerPmTask(list);
		return SUCCESS;
	}
	
	public String catchInputCustomerData() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = sdf.format(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -30);
		String date2 = sdf.format(calendar.getTime());
		System.out.println("date1:"+date1+",date2:"+date2);
		List<Customer> originalList = customerService.queryCustomerBetweenTwoTimes(date2, date1);
		//for (Customer customer : originalList) {
			//System.out.println("company:"+customer.getCompany()+",add date:"+customer.getAddDate()+",add user:"+customer.getAddUser().getRealName());
		//}
		handleCustomerData(originalList);
		return SUCCESS;
	}
	
	private void handleCustomerData(List<Customer> customers){
		List<User> users = userService.getAllUserValidity();
		customerMessageInputList = new ArrayList<UserCustomerInfo>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//init return data
		for (User user : users) {
			UserCustomerInfo uci = new UserCustomerInfo();
			uci.setName(user.getRealName());
			Map<String,Integer> mapValue = uci.getMapValue();
			Calendar calendar = Calendar.getInstance();
			for(int i=1;i<=30;i++){
				String date = sdf.format(calendar.getTime());
				calendar.add(Calendar.DATE, -1);
				mapValue.put(date, 0);
			}
			customerMessageInputList.add(uci);
		}
		
		for (Customer customer : customers) {
			String addUser = customer.getAddUser().getRealName();
			String addDate = sdf.format(customer.getAddDate());
			for (UserCustomerInfo uci : customerMessageInputList) {
				if(uci.getName().equals(addUser)){
					Map<String,Integer> mapValue = uci.getMapValue();
					Integer valueForDay = mapValue.get(addDate);
					mapValue.put(addDate, valueForDay+1);
				}
			}
		}
	}
	
	private List<UserInfoManagerPmTask> encapsulatesManagerPmTask(List<PmTask> list1){
		List<UserInfoManagerPmTask> list2 = new ArrayList<UserInfoManagerPmTask>();
		for (PmTask pt : list1) {
			UserInfoManagerPmTask userInfoManagerPmTask = new UserInfoManagerPmTask();
			
			float sum_leader_value = 0;
			float sum_self_value = 0;
			float sum_staff_value = 0;
			
			int leader_count = 0;
			int self_count = 0;
			int staff_count = 0;
			
			for (PmTable pmTable : pt.getPmTablesForTid()) {
				if(pmTable.getManagerType()==1){
					sum_leader_value += (pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5())*0.4+(pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9())*0.3+(pmTable.getItem10()+pmTable.getItem11())*0.15+(pmTable.getItem12()+pmTable.getItem13())*0.15;
					leader_count++;
				}
				else if(pmTable.getManagerType()==2){
					sum_self_value += (pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5())*0.4+(pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9())*0.3+(pmTable.getItem10()+pmTable.getItem11())*0.15+(pmTable.getItem12()+pmTable.getItem13())*0.15;
					self_count++;
				}
				else if(pmTable.getManagerType()==3){
					sum_staff_value += (pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5())*0.4+(pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9())*0.3+(pmTable.getItem10()+pmTable.getItem11())*0.15+(pmTable.getItem12()+pmTable.getItem13())*0.15;
					staff_count++;
				}
			}
			
			userInfoManagerPmTask.setName(pt.getUserByUid().getRealName());
			if(leader_count!=0){
			    userInfoManagerPmTask.setLeaderValue(sum_leader_value/leader_count);
			}else{
				userInfoManagerPmTask.setLeaderValue(0.00f);
			}
			if(self_count!=0){
			    userInfoManagerPmTask.setSelfValue(sum_self_value/self_count);
			}else{
				userInfoManagerPmTask.setSelfValue(0.00f);
			}
			if(staff_count!=0){
			    userInfoManagerPmTask.setStaffValue(sum_staff_value/staff_count);
			}else{
				userInfoManagerPmTask.setStaffValue(0.00f);
			}
			list2.add(userInfoManagerPmTask);
		}
		return list2;
	}
	
	private List<UserInfoPmTask> encapsulatesPmTask(List<PmTask> list1){
		List<UserInfoPmTask> list2 = new ArrayList<UserInfoPmTask>();
		
		for (PmTask pt : list1) {
			UserInfoPmTask userInfoPmTask = new UserInfoPmTask();
			
			float sum_self_value = 0;
			float sum_department_value = 0;
			float sum_manager_value = 0;
			float sum_company_value = 0;
			float sum_staff_value = 0;
			
			int sum_self_count = 0;
			int sum_department_count = 0;
			int sum_manager_count = 0;
			int sum_company_count = 0;
			int sum_staff_count = 0;
			
			for (PmTable pmTable : pt.getPmTablesForTid()) {
				
				if(pmTable.getType()==1){
					if(!pmTable.isSimple()){
						sum_self_value += pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5()+pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9()+pmTable.getItem10();
						sum_self_count++;
					}
					else{
						sum_self_value += pmTable.getItem11();
						sum_self_count++;
					}
				}
				else if(pmTable.getType()==2){
					if(!pmTable.isSimple()){
						sum_department_value += pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5()+pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9()+pmTable.getItem10();
						sum_department_count++;
					}
					else{
						sum_department_value += pmTable.getItem11();
						sum_department_count++;
					}
				}
                else if(pmTable.getType()==3){
                	if(!pmTable.isSimple()){
						sum_manager_value += pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5()+pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9()+pmTable.getItem10();
						sum_manager_count++;
					}
					else{
						sum_manager_value += pmTable.getItem11();
						sum_manager_count++;
					}
				}
                else if(pmTable.getType()==4){
                	if(!pmTable.isSimple()){
						sum_company_value += pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5()+pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9()+pmTable.getItem10();
						sum_company_count++;
					}
					else{
						sum_company_value += pmTable.getItem11();
						sum_company_count++;
					}
				}
                else if(pmTable.getType()==5){
                	if(!pmTable.isSimple()){
						sum_staff_value += pmTable.getItem1()+pmTable.getItem2()+pmTable.getItem3()+pmTable.getItem4()+pmTable.getItem5()+pmTable.getItem6()+pmTable.getItem7()+pmTable.getItem8()+pmTable.getItem9()+pmTable.getItem10();
						sum_staff_count++;
					}
					else{
						sum_staff_value += pmTable.getItem11();
						sum_staff_count++;
					}
				}
				
				
			}
			
			userInfoPmTask.setName(pt.getUserByUid().getRealName());
			if(sum_self_count!=0){
			    userInfoPmTask.setSelfValue(sum_self_value/sum_self_count);
			}
			else{
				userInfoPmTask.setSelfValue(0.00f);
			}
			
			if(sum_department_count!=0){
			    userInfoPmTask.setDepartmentValue(sum_department_value/sum_department_count);
			}
			else{
				userInfoPmTask.setDepartmentValue(0.00f);
			}
			
			if(sum_manager_count!=0){
			    userInfoPmTask.setManagerValue(sum_manager_value/sum_manager_count);
			}
			else{
				userInfoPmTask.setManagerValue(0.00f);
			}
			
			if(sum_company_count!=0){
			    userInfoPmTask.setCompanyValue(sum_company_value/sum_company_count);
			}
			else{
				userInfoPmTask.setCompanyValue(0.00f);
			}
			
			if(sum_staff_count!=0){
			    userInfoPmTask.setStaffValue(sum_staff_value/sum_staff_count);
			}
			else{
				userInfoPmTask.setStaffValue(0.00f);
			}
			
			list2.add(userInfoPmTask);
		}
		return list2;
	}
}
