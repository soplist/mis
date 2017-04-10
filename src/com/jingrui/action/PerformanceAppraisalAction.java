package com.jingrui.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.ColleagueEvaluationForm;
import com.jingrui.domain.CommonPerformanceAppraisalTask;
import com.jingrui.domain.CompanyEvaluationForm;
import com.jingrui.domain.DepartmentEvaluationForm;
import com.jingrui.domain.ManagerEvaluationForm;
import com.jingrui.domain.ManagerPerformanceAppraisalTask;
import com.jingrui.domain.PersonalEvaluationForm;
import com.jingrui.domain.User;
import com.jingrui.domain.UserInformation;
import com.jingrui.exception.DepartmentNotFoundException;
import com.jingrui.service.EvaluationFormService;
import com.jingrui.service.PerformanceAppraisalTaskService;
import com.jingrui.util.BuildCompanyStructure;
import com.jingrui.util.LoadManagerPerformanceAppraisalConfigXml;
import com.jingrui.util.StaffEvaluationUserInformationSet;
import com.jingrui.util.UserSet;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: PerformanceAppraisalAction.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-16 ÉÏÎç9:52:08
 */

public class PerformanceAppraisalAction extends ActionSupport{
	
	private BuildCompanyStructure buildCompanyStructure;
	private EvaluationFormService evaluationFormService;
	private PerformanceAppraisalTaskService performanceAppraisalTaskService;
	private LoadManagerPerformanceAppraisalConfigXml loadManagerPerformanceAppraisalConfigXml;
	
	private static final int EVALUATION_TYPE_PERSONAL = 1;
	private static final int EVALUATION_TYPE_DEPARTMENT = 2;
	private static final int EVALUATION_TYPE_MANAGER = 3;
	private static final int EVALUATION_TYPE_COMPANY = 4;
	private static final int EVALUATION_TYPE_COLLEAGUE = 5;
	private static final String USER_INFORMATION_SESSION_KEY = "userInformation";
	private static final int COMMON_PERFORMANCE_APPRAISAL_TASK_TYPE = 1;
	private static final int MANAGER_PERFORMANCE_APPRAISAL_TASK_TYPE = 2;
	private static final boolean INITIAL_PERFORMANCE_APPRAISAL_TASK_STATUS = false;
	private static final boolean INITIAL_EVALUATION_FORM_STATUS = false;
	private static final int STAFF_EVALUATION_USERINFORMATION_SET_CAPACITY = 5;
	private static final boolean INITIAL_STAFF_EVALUATION_USERINFORMATION_SET_FULL_STATUS = false;
	
	private HttpSession session;
    
	public PerformanceAppraisalAction(){
		this.session=ServletActionContext.getRequest().getSession();
	}
	
	public EvaluationFormService getEvaluationFormService() {
		return evaluationFormService;
	}

	public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
		this.evaluationFormService = evaluationFormService;
	}

	public BuildCompanyStructure getBuildCompanyStructure() {
		return buildCompanyStructure;
	}

	public void setBuildCompanyStructure(BuildCompanyStructure buildCompanyStructure) {
		this.buildCompanyStructure = buildCompanyStructure;
	}
	
	public PerformanceAppraisalTaskService getPerformanceAppraisalTaskService() {
		return performanceAppraisalTaskService;
	}

	public void setPerformanceAppraisalTaskService(
			PerformanceAppraisalTaskService performanceAppraisalTaskService) {
		this.performanceAppraisalTaskService = performanceAppraisalTaskService;
	}
	
	public LoadManagerPerformanceAppraisalConfigXml getLoadManagerPerformanceAppraisalConfigXml() {
		return loadManagerPerformanceAppraisalConfigXml;
	}

	public void setLoadManagerPerformanceAppraisalConfigXml(
			LoadManagerPerformanceAppraisalConfigXml loadManagerPerformanceAppraisalConfigXml) {
		this.loadManagerPerformanceAppraisalConfigXml = loadManagerPerformanceAppraisalConfigXml;
	}

	public String launchCommonTask(){
		
		//testInsertEvaluationForm();
		//testInsertPerformanceAppraisalTask();
		ArrayList<UserInformation> validUserInformationList = buildCompanyStructure.getValidUserList();
		UserInformation currentUserInformation = (UserInformation) session.getAttribute(USER_INFORMATION_SESSION_KEY);
		
		for (UserInformation validUserInformation : validUserInformationList) {
			int common_performance_appraisal_task_id = initCommonPerformanceAppraisalTask(validUserInformation);
			
			initPersonalEvaluationForm(validUserInformation,common_performance_appraisal_task_id);
			
			initDepartmentEvaluationForm(validUserInformation,common_performance_appraisal_task_id);
			
			initManagertEvaluationForm(validUserInformation,common_performance_appraisal_task_id);
			
			initCompanyEvaluationForm(validUserInformation,common_performance_appraisal_task_id);
			
			initColleagueEvaluationForm(validUserInformation,common_performance_appraisal_task_id);
		}
		return "success";
	}
	
	public Integer initCommonPerformanceAppraisalTask(UserInformation userInformation){
		CommonPerformanceAppraisalTask commonPerformanceAppraisalTask = new CommonPerformanceAppraisalTask();
		commonPerformanceAppraisalTask.setFinishStatus(INITIAL_PERFORMANCE_APPRAISAL_TASK_STATUS);
		commonPerformanceAppraisalTask.setUserId(userInformation.getId());
		commonPerformanceAppraisalTask.setEvaluationType(COMMON_PERFORMANCE_APPRAISAL_TASK_TYPE);
		commonPerformanceAppraisalTask.setLaunchTime(new Date());
		int common_performance_appraisal_task_id = performanceAppraisalTaskService.add(commonPerformanceAppraisalTask);
		return common_performance_appraisal_task_id;
	}
	
	public void initPersonalEvaluationForm(UserInformation userInformation,int common_performance_appraisal_task_id){
		PersonalEvaluationForm personalEvaluationForm = new PersonalEvaluationForm();
		personalEvaluationForm.setUserId(userInformation.getId());
		personalEvaluationForm.setEvaluationTaskId(common_performance_appraisal_task_id);
		personalEvaluationForm.setFinish(INITIAL_EVALUATION_FORM_STATUS);
		personalEvaluationForm.setEvaluationType(EVALUATION_TYPE_PERSONAL);
		evaluationFormService.addEvaluationForm(personalEvaluationForm);
	}
	
	public void initDepartmentEvaluationForm(UserInformation currentUserInformation,int common_performance_appraisal_task_id){
		HashMap<String,ArrayList<UserInformation>> departmentUserInformationHashMap = buildCompanyStructure.getDepartmentStructureHashMap();
		ArrayList<UserInformation> currentDepartmentUserInformationList = departmentUserInformationHashMap.get(currentUserInformation.getUserResumeInformation().getDepartment());
		for (UserInformation departmentUserInformation : currentDepartmentUserInformationList) {
			if(departmentUserInformation.getId() != currentUserInformation.getId()){
				DepartmentEvaluationForm departmentEvaluationForm = new DepartmentEvaluationForm();
				departmentEvaluationForm.setUserId(departmentUserInformation.getId());
				departmentEvaluationForm.setEvaluationTaskId(common_performance_appraisal_task_id);
				departmentEvaluationForm.setFinish(INITIAL_EVALUATION_FORM_STATUS);
				departmentEvaluationForm.setEvaluationType(EVALUATION_TYPE_DEPARTMENT);
				evaluationFormService.addEvaluationForm(departmentEvaluationForm);
			}
		}
	}
	
	public void initManagertEvaluationForm(UserInformation currentUserInformation,int common_performance_appraisal_task_id){
		HashMap<String, String> evaluationUnitMap = loadManagerPerformanceAppraisalConfigXml.getEvaluationUnitMap();
		ManagerEvaluationForm managerEvaluationForm = new ManagerEvaluationForm();
		
		String currentUserDepartment = currentUserInformation.getUserResumeInformation().getDepartment();
		String departmentManager = evaluationUnitMap.get(currentUserDepartment);
		Integer managerId = buildCompanyStructure.getUserInformationByName(departmentManager).getId();
		
		managerEvaluationForm.setUserId(managerId);
		managerEvaluationForm.setEvaluationTaskId(common_performance_appraisal_task_id);
		managerEvaluationForm.setFinish(INITIAL_EVALUATION_FORM_STATUS);
		managerEvaluationForm.setEvaluationType(EVALUATION_TYPE_MANAGER);
		evaluationFormService.addEvaluationForm(managerEvaluationForm);
	}
	
	public void initCompanyEvaluationForm(UserInformation currentUserInformation,int common_performance_appraisal_task_id){
		ArrayList<UserInformation> managerList = buildCompanyStructure.getManagerList();
		for (UserInformation companyUserInformation : managerList) {
			if(companyUserInformation.getId() != currentUserInformation.getId()){
				CompanyEvaluationForm companyEvaluationForm = new CompanyEvaluationForm();
				companyEvaluationForm.setUserId(companyUserInformation.getId());
				companyEvaluationForm.setEvaluationTaskId(common_performance_appraisal_task_id);
				companyEvaluationForm.setFinish(INITIAL_EVALUATION_FORM_STATUS);
				companyEvaluationForm.setEvaluationType(EVALUATION_TYPE_COMPANY);
				//evaluationFormService.addCompanyEvaluationForm(companyEvaluationForm);
				evaluationFormService.addEvaluationForm(companyEvaluationForm);
			}
		}
	}
	
	public void initColleagueEvaluationForm(UserInformation currentUserInformation,int common_performance_appraisal_task_id){
		try {
			ArrayList<UserInformation> otherDepartmentArrayList = buildCompanyStructure.otherDepartmentArrayList(currentUserInformation.getUserResumeInformation().getDepartment());
			Random random = new Random();
			int random_range = otherDepartmentArrayList.size();
			StaffEvaluationUserInformationSet staffEvaluationUserInformationSet = new StaffEvaluationUserInformationSet(currentUserInformation,STAFF_EVALUATION_USERINFORMATION_SET_CAPACITY);
		    if(random_range>5){
		        boolean full = INITIAL_STAFF_EVALUATION_USERINFORMATION_SET_FULL_STATUS;
		        while(!full){
		            int random_id = random.nextInt(random_range);
		            UserInformation u = otherDepartmentArrayList.get(random_id);
		            full = staffEvaluationUserInformationSet.add(u);
		        }
            }else{
			    for (UserInformation userInformation : otherDepartmentArrayList) {
			    	staffEvaluationUserInformationSet.add(userInformation);
			    }
		    }
		    for (UserInformation userInformation : staffEvaluationUserInformationSet.getUserInformationSet()) {
		    	ColleagueEvaluationForm colleagueEvaluationForm = new ColleagueEvaluationForm();
				colleagueEvaluationForm.setUserId(userInformation.getId());
				colleagueEvaluationForm.setEvaluationTaskId(common_performance_appraisal_task_id);
				colleagueEvaluationForm.setFinish(INITIAL_EVALUATION_FORM_STATUS);
				colleagueEvaluationForm.setEvaluationType(EVALUATION_TYPE_COLLEAGUE);
				evaluationFormService.addEvaluationForm(colleagueEvaluationForm);
		    }
		} catch (DepartmentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void testInsertPerformanceAppraisalTask(){
		CommonPerformanceAppraisalTask commonPerformanceAppraisalTask = new CommonPerformanceAppraisalTask();
		commonPerformanceAppraisalTask.setFinishStatus(false);
		commonPerformanceAppraisalTask.setUserId(1);
		commonPerformanceAppraisalTask.setEvaluationType(COMMON_PERFORMANCE_APPRAISAL_TASK_TYPE);
		commonPerformanceAppraisalTask.setLaunchTime(new Date());
		int common_id = performanceAppraisalTaskService.add(commonPerformanceAppraisalTask);
		System.out.println("id:"+common_id);
		
		ManagerPerformanceAppraisalTask managerPerformanceAppraisalTask = new ManagerPerformanceAppraisalTask();
		managerPerformanceAppraisalTask.setFinishStatus(false);
		managerPerformanceAppraisalTask.setUserId(1);
		managerPerformanceAppraisalTask.setEvaluationType(MANAGER_PERFORMANCE_APPRAISAL_TASK_TYPE);
		managerPerformanceAppraisalTask.setLaunchTime(new Date());
		int manager_id = performanceAppraisalTaskService.add(managerPerformanceAppraisalTask);
		System.out.println("id:"+manager_id);
	}
	
	private void testInsertEvaluationForm(){
		
		PersonalEvaluationForm personalEvaluationForm = new PersonalEvaluationForm();
		personalEvaluationForm.setUserId(1);
		personalEvaluationForm.setEvaluationTaskId(1);
		personalEvaluationForm.setFinish(false);
		personalEvaluationForm.setEvaluationType(EVALUATION_TYPE_PERSONAL);
		personalEvaluationForm.setItem_1(9.5f);
		personalEvaluationForm.setItem_2(9.5f);
		personalEvaluationForm.setItem_3(9.5f);
		personalEvaluationForm.setItem_4(9.5f);
		personalEvaluationForm.setItem_5(9.5f);
		personalEvaluationForm.setItem_6(9.5f);
		personalEvaluationForm.setItem_7(9.5f);
		personalEvaluationForm.setItem_8(9.5f);
		personalEvaluationForm.setItem_9(9.5f);
		personalEvaluationForm.setItem_10(9.5f);
		//evaluationFormService.addPersonalEvaluationForm(personalEvaluationForm);
		evaluationFormService.addEvaluationForm(personalEvaluationForm);
		
		DepartmentEvaluationForm departmentEvaluationForm = new DepartmentEvaluationForm();
		departmentEvaluationForm.setUserId(1);
		departmentEvaluationForm.setEvaluationTaskId(1);
		departmentEvaluationForm.setFinish(false);
		departmentEvaluationForm.setEvaluationType(EVALUATION_TYPE_DEPARTMENT);
		departmentEvaluationForm.setItem_1(9.5f);
		departmentEvaluationForm.setItem_2(9.5f);
		departmentEvaluationForm.setItem_3(9.5f);
		departmentEvaluationForm.setItem_4(9.5f);
		departmentEvaluationForm.setItem_5(9.5f);
		departmentEvaluationForm.setItem_6(9.5f);
		departmentEvaluationForm.setItem_7(9.5f);
		departmentEvaluationForm.setItem_8(9.5f);
		departmentEvaluationForm.setItem_9(9.5f);
		departmentEvaluationForm.setItem_10(9.5f);
		//evaluationFormService.addDepartmentEvaluationForm(departmentEvaluationForm);
		evaluationFormService.addEvaluationForm(departmentEvaluationForm);
		
		ManagerEvaluationForm managerEvaluationForm = new ManagerEvaluationForm();
		managerEvaluationForm.setUserId(1);
		managerEvaluationForm.setEvaluationTaskId(1);
		managerEvaluationForm.setFinish(false);
		managerEvaluationForm.setEvaluationType(EVALUATION_TYPE_MANAGER);
		managerEvaluationForm.setItem_1(9.5f);
		//evaluationFormService.addManagerEvaluationForm(managerEvaluationForm);
		evaluationFormService.addEvaluationForm(managerEvaluationForm);
		
		CompanyEvaluationForm companyEvaluationForm = new CompanyEvaluationForm();
		companyEvaluationForm.setUserId(1);
		companyEvaluationForm.setEvaluationTaskId(1);
		companyEvaluationForm.setFinish(false);
		companyEvaluationForm.setEvaluationType(EVALUATION_TYPE_COMPANY);
		companyEvaluationForm.setItem_1(9.5f);
		//evaluationFormService.addCompanyEvaluationForm(companyEvaluationForm);
		evaluationFormService.addEvaluationForm(companyEvaluationForm);
		
		ColleagueEvaluationForm colleagueEvaluationForm = new ColleagueEvaluationForm();
		colleagueEvaluationForm.setUserId(1);
		colleagueEvaluationForm.setEvaluationTaskId(1);
		colleagueEvaluationForm.setFinish(false);
		colleagueEvaluationForm.setEvaluationType(EVALUATION_TYPE_COLLEAGUE);
		colleagueEvaluationForm.setItem_1(9.5f);
		colleagueEvaluationForm.setItem_2(9.5f);
		colleagueEvaluationForm.setItem_3(9.5f);
		colleagueEvaluationForm.setItem_4(9.5f);
		colleagueEvaluationForm.setItem_5(9.5f);
		colleagueEvaluationForm.setItem_6(9.5f);
		colleagueEvaluationForm.setItem_7(9.5f);
		colleagueEvaluationForm.setItem_8(9.5f);
		colleagueEvaluationForm.setItem_9(9.5f);
		colleagueEvaluationForm.setItem_10(9.5f);
		//evaluationFormService.addColleagueEvaluationForm(colleagueEvaluationForm);
		evaluationFormService.addEvaluationForm(colleagueEvaluationForm);
	}
	
	public String beforeRedirectToPerformanceAppraisalSettingPage(){
		
		return "success";
	}
}
