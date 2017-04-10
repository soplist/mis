package com.jingrui.domain;

import java.util.Date;

/**
 * <p>Title: PerformanceAppraisalTask.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-5 ÉÏÎç10:31:43
 */

public class PerformanceAppraisalTask {
	
    private Integer id;
    private boolean finishStatus;
    private Integer userId;
    private Integer evaluationType;
    private Date launchTime;
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isFinishStatus() {
		return finishStatus;
	}
	public void setFinishStatus(boolean finishStatus) {
		this.finishStatus = finishStatus;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getEvaluationType() {
		return evaluationType;
	}
	public void setEvaluationType(Integer evaluationType) {
		this.evaluationType = evaluationType;
	}
	public Date getLaunchTime() {
		return launchTime;
	}
	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}
	
}
