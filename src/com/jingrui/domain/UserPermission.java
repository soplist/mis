package com.jingrui.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: UserPermission.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-22 ÉÏÎç9:43:11
 */

public class UserPermission {

	private static final long serialVersionUID = 7754022511322707279L;
	private Integer id;
	private String permissionName;
	private Boolean performanceAppraisalSetting;
	private Boolean viewAllPerformanceAppraisal;
	private Boolean managerEvaluationSetting;
	private Boolean viewFinishedPerformanceAppraisalTask;
	private Boolean viewNotFinishedPerformanceAppraisalTask;
	private Boolean personalPerformanceAppraisalTask;
	private Boolean updatePassword;
	
	private Boolean customerInformationCreate;
	private Boolean customerInformationRetrieve;
	private Boolean customerInformationUpdate;
	private Boolean customerInformationDelete;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public Boolean getPerformanceAppraisalSetting() {
		return performanceAppraisalSetting;
	}
	public void setPerformanceAppraisalSetting(Boolean performanceAppraisalSetting) {
		this.performanceAppraisalSetting = performanceAppraisalSetting;
	}
	public Boolean getViewAllPerformanceAppraisal() {
		return viewAllPerformanceAppraisal;
	}
	public void setViewAllPerformanceAppraisal(Boolean viewAllPerformanceAppraisal) {
		this.viewAllPerformanceAppraisal = viewAllPerformanceAppraisal;
	}
	public Boolean getManagerEvaluationSetting() {
		return managerEvaluationSetting;
	}
	public void setManagerEvaluationSetting(Boolean managerEvaluationSetting) {
		this.managerEvaluationSetting = managerEvaluationSetting;
	}
	public Boolean getViewFinishedPerformanceAppraisalTask() {
		return viewFinishedPerformanceAppraisalTask;
	}
	public void setViewFinishedPerformanceAppraisalTask(
			Boolean viewFinishedPerformanceAppraisalTask) {
		this.viewFinishedPerformanceAppraisalTask = viewFinishedPerformanceAppraisalTask;
	}
	public Boolean getViewNotFinishedPerformanceAppraisalTask() {
		return viewNotFinishedPerformanceAppraisalTask;
	}
	public void setViewNotFinishedPerformanceAppraisalTask(
			Boolean viewNotFinishedPerformanceAppraisalTask) {
		this.viewNotFinishedPerformanceAppraisalTask = viewNotFinishedPerformanceAppraisalTask;
	}
	public Boolean getPersonalPerformanceAppraisalTask() {
		return personalPerformanceAppraisalTask;
	}
	public void setPersonalPerformanceAppraisalTask(
			Boolean personalPerformanceAppraisalTask) {
		this.personalPerformanceAppraisalTask = personalPerformanceAppraisalTask;
	}
	public Boolean getUpdatePassword() {
		return updatePassword;
	}
	public void setUpdatePassword(Boolean updatePassword) {
		this.updatePassword = updatePassword;
	}
	public Boolean getCustomerInformationCreate() {
		return customerInformationCreate;
	}
	public void setCustomerInformationCreate(Boolean customerInformationCreate) {
		this.customerInformationCreate = customerInformationCreate;
	}
	public Boolean getCustomerInformationRetrieve() {
		return customerInformationRetrieve;
	}
	public void setCustomerInformationRetrieve(Boolean customerInformationRetrieve) {
		this.customerInformationRetrieve = customerInformationRetrieve;
	}
	public Boolean getCustomerInformationUpdate() {
		return customerInformationUpdate;
	}
	public void setCustomerInformationUpdate(Boolean customerInformationUpdate) {
		this.customerInformationUpdate = customerInformationUpdate;
	}
	public Boolean getCustomerInformationDelete() {
		return customerInformationDelete;
	}
	public void setCustomerInformationDelete(Boolean customerInformationDelete) {
		this.customerInformationDelete = customerInformationDelete;
	}
	
}
