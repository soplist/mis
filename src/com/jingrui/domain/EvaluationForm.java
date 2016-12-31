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
	
	private Integer pid;
	private User userByUid;
    private PmTask pmTaskByTid;
    private boolean statu;
    private Date finishTime;
    
    public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public User getUserByUid() {
		return userByUid;
	}
	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}
	public PmTask getPmTaskByTid() {
		return pmTaskByTid;
	}
	public void setPmTaskByTid(PmTask pmTaskByTid) {
		this.pmTaskByTid = pmTaskByTid;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
