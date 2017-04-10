package com.jingrui.domain;

import java.util.Date;

/**
 * <p>Title: UserResumeInformation.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-11 ÉÏÎç9:50:05
 */

public class UserResumeInformation {
	private String name;
	private String department;
	private boolean managerStatus;
	private boolean bossStatus;
	private String position;
	private Date joinTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public boolean isManagerStatus() {
		return managerStatus;
	}
	public void setManagerStatus(boolean managerStatus) {
		this.managerStatus = managerStatus;
	}
	public boolean isBossStatus() {
		return bossStatus;
	}
	public void setBossStatus(boolean bossStatus) {
		this.bossStatus = bossStatus;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	
}
