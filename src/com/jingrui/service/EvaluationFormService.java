package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.ColleagueEvaluationForm;
import com.jingrui.domain.CompanyEvaluationForm;
import com.jingrui.domain.DepartmentEvaluationForm;
import com.jingrui.domain.EvaluationForm;
import com.jingrui.domain.ManagerEvaluationForm;
import com.jingrui.domain.PersonalEvaluationForm;

/**
 * <p>Title: EvaluationFormService.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-16 ÉÏÎç10:32:16
 */

public interface EvaluationFormService {
	public void addEvaluationForm(EvaluationForm evaluationForm);
	public void addPersonalEvaluationForm(PersonalEvaluationForm personalEvaluationForm);
	public void addDepartmentEvaluationForm(DepartmentEvaluationForm departmentEvaluationForm);
	public void addManagerEvaluationForm(ManagerEvaluationForm managerEvaluationForm);
	public void addCompanyEvaluationForm(CompanyEvaluationForm companyEvaluationForm);
	public void addColleagueEvaluationForm(ColleagueEvaluationForm colleagueEvaluationForm);
	public List<EvaluationForm> getNotFinishedEvaluationFormByUserId(Integer userId);
	
}
