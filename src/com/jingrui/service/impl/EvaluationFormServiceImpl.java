package com.jingrui.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.ColleagueEvaluationForm;
import com.jingrui.domain.CompanyEvaluationForm;
import com.jingrui.domain.DepartmentEvaluationForm;
import com.jingrui.domain.EvaluationForm;
import com.jingrui.domain.ManagerEvaluationForm;
import com.jingrui.domain.PersonalEvaluationForm;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.UserLoginInformation;
import com.jingrui.parameter.AssessmentTableType;
import com.jingrui.service.EvaluationFormService;

/**
 * <p>Title: EvaluationFormServiceImpl.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-16 ÏÂÎç3:41:51
 */

public class EvaluationFormServiceImpl implements EvaluationFormService {
	
	private BaseDAO<EvaluationForm> baseDao;

	public BaseDAO<EvaluationForm> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<EvaluationForm> baseDao) {
		this.baseDao = baseDao;
	}
	
	public void addEvaluationForm(EvaluationForm evaluationForm) {
		// TODO Auto-generated method stub
		baseDao.add(evaluationForm);
	}
	
	public List<EvaluationForm> getNotFinishedEvaluationFormByUserId(Integer userId){
		List<EvaluationForm> personalList = getNotFinishedPersonalEvaluationFormByUserId(userId);
		List<EvaluationForm> departmentList = getNotFinishedDepartmentEvaluationFormByUserId(userId);
		List<EvaluationForm> managerList = getNotFinishedManagerEvaluationFormByUserId(userId);
		List<EvaluationForm> companyList = getNotFinishedCompanyEvaluationFormByUserId(userId);
		List<EvaluationForm> colleagueList = getNotFinishedColleagueEvaluationFormByUserId(userId);
		
		List<EvaluationForm> allList = new ArrayList<EvaluationForm>();
		allList.addAll(personalList);
		allList.addAll(departmentList);
		allList.addAll(managerList);
		allList.addAll(companyList);
		allList.addAll(colleagueList);
		return allList;
	}
	
	public List<EvaluationForm> getNotFinishedPersonalEvaluationFormByUserId(Integer userId){
		List<EvaluationForm> list = baseDao.qryInfo("from PersonalEvaluationForm where evaluationType="+AssessmentTableType.PERSONAL_EVALUATION+" and userId="+userId+" and finish=false");
		return list;
	}
	
    public List<EvaluationForm> getNotFinishedDepartmentEvaluationFormByUserId(Integer userId){
    	List<EvaluationForm> list = baseDao.qryInfo("from DepartmentEvaluationForm where evaluationType="+AssessmentTableType.DEPARTMENT_EVALUATION+" and userId="+userId+" and finish=false");
    	return list;
	}
    
    public List<EvaluationForm> getNotFinishedManagerEvaluationFormByUserId(Integer userId){
    	List<EvaluationForm> list = baseDao.qryInfo("from ManagerEvaluationForm where evaluationType="+AssessmentTableType.MANAGER_EVALUATION+" and userId="+userId+" and finish=false");
    	return list;
	}
    
    public List<EvaluationForm> getNotFinishedCompanyEvaluationFormByUserId(Integer userId){
    	List<EvaluationForm> list = baseDao.qryInfo("from CompanyEvaluationForm where evaluationType="+AssessmentTableType.COMPANY_EVALUATION+" and userId="+userId+" and finish=false");
    	return list;
	}
    
    public List<EvaluationForm> getNotFinishedColleagueEvaluationFormByUserId(Integer userId){
    	List<EvaluationForm> list = baseDao.qryInfo("from ColleagueEvaluationForm where evaluationType="+AssessmentTableType.COLLEAGUE_EVALUATION+" and userId="+userId+" and finish=false");
    	return list;
	}
	
	public void addPersonalEvaluationForm(PersonalEvaluationForm personalEvaluationForm) {
		// TODO Auto-generated method stub
		baseDao.add(personalEvaluationForm);
	}
	
	public void addDepartmentEvaluationForm(DepartmentEvaluationForm departmentEvaluationForm) {
		// TODO Auto-generated method stub
		baseDao.add(departmentEvaluationForm);
	}
	
	public void addManagerEvaluationForm(ManagerEvaluationForm managerEvaluationForm) {
		// TODO Auto-generated method stub
		baseDao.add(managerEvaluationForm);
	}
	
	public void addCompanyEvaluationForm(CompanyEvaluationForm companyEvaluationForm) {
		// TODO Auto-generated method stub
		baseDao.add(companyEvaluationForm);
	}
	
	public void addColleagueEvaluationForm(ColleagueEvaluationForm colleagueEvaluationForm) {
		// TODO Auto-generated method stub
		baseDao.add(colleagueEvaluationForm);
	}
}
