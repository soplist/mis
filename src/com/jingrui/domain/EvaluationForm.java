package com.jingrui.domain;

import java.util.Date;

/**
 * <p>Title: EvaluationForm.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @description this class is a parent class of all kind of evaluation form
 * @author wangkang
 * @version 1.0 creation time£º2016-12-31 ÉÏÎç10:22:24
 */

public class EvaluationForm implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer userId;
	private Integer evaluationTaskId;
    private boolean finish;
    private Integer evaluationType;
    private Date finishTime;
    
    private PerformanceAppraisalTask performanceAppraisalTaskByEvaluationTaskId;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getEvaluationTaskId() {
		return evaluationTaskId;
	}
	public void setEvaluationTaskId(Integer evaluationTaskId) {
		this.evaluationTaskId = evaluationTaskId;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	public Integer getEvaluationType() {
		return evaluationType;
	}
	public void setEvaluationType(Integer evaluationType) {
		this.evaluationType = evaluationType;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public PerformanceAppraisalTask getPerformanceAppraisalTaskByEvaluationTaskId() {
		return performanceAppraisalTaskByEvaluationTaskId;
	}
	public void setPerformanceAppraisalTaskByEvaluationTaskId(
			PerformanceAppraisalTask performanceAppraisalTaskByEvaluationTaskId) {
		this.performanceAppraisalTaskByEvaluationTaskId = performanceAppraisalTaskByEvaluationTaskId;
	}
}
