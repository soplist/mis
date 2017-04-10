package com.jingrui.domain;

/**
 * <p>Title: UserInformation.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-11 ÉÏÎç9:46:46
 */

public class UserInformation {
    private int id;
    private boolean workStatus;
    private String username;
    
    private UserConfigInformation userConfigInformation;
    private UserResumeInformation userResumeInformation;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(boolean workStatus) {
		this.workStatus = workStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserConfigInformation getUserConfigInformation() {
		return userConfigInformation;
	}
	public void setUserConfigInformation(UserConfigInformation userConfigInformation) {
		this.userConfigInformation = userConfigInformation;
	}
	public UserResumeInformation getUserResumeInformation() {
		return userResumeInformation;
	}
	public void setUserResumeInformation(UserResumeInformation userResumeInformation) {
		this.userResumeInformation = userResumeInformation;
	}
	
}
