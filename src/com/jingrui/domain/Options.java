package com.jingrui.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Options implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4601175922127960473L;
	private Integer sid;
	private Date settingTime;
	private Integer selfEval;
	private Integer deptEval;
	private Integer managerEval;
	private Integer companyEval;
	private Integer colleaguesEval;
    private Set users = new HashSet(0);
    private String tag="Setting";
    private Set joininsForSid = new HashSet(0);
	private Set pmTasksForSid = new HashSet(0);
    
    public Options(){
		
	}
	
    public Options(Integer sid,Date settingTime,Integer selfEval,
    		Integer deptEval,Integer managerEval,Integer companyEval,Integer colleaguesEval,Set users){
		this.sid = sid;
		this.settingTime = settingTime;
		this.selfEval = selfEval;
		this.deptEval = deptEval;
		this.managerEval = managerEval;
		this.companyEval = companyEval;
		this.colleaguesEval = colleaguesEval;
		this.users = users;
	}
    
    public Options(Integer sid,Date settingTime,Integer selfEval,
    		Integer deptEval,Integer managerEval,Integer companyEval,Integer colleaguesEval,Set users,Set joininsForSid){
		this.sid = sid;
		this.settingTime = settingTime;
		this.selfEval = selfEval;
		this.deptEval = deptEval;
		this.managerEval = managerEval;
		this.companyEval = companyEval;
		this.colleaguesEval = colleaguesEval;
		this.users = users;
		this.joininsForSid = joininsForSid;
	}
    
    public Options(Integer sid,Date settingTime,Integer selfEval,
    		Integer deptEval,Integer managerEval,Integer companyEval,Integer colleaguesEval,Set users,Set joininsForSid,Set pmTasksForSid){
		this.sid = sid;
		this.settingTime = settingTime;
		this.selfEval = selfEval;
		this.deptEval = deptEval;
		this.managerEval = managerEval;
		this.companyEval = companyEval;
		this.colleaguesEval = colleaguesEval;
		this.users = users;
		this.joininsForSid = joininsForSid;
		this.pmTasksForSid = pmTasksForSid;
	}
    
    public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Date getSettingTime() {
		return settingTime;
	}

	public void setSettingTime(Date settingTime) {
		this.settingTime = settingTime;
	}

	public Integer getSelfEval() {
		return selfEval;
	}

	public void setSelfEval(Integer selfEval) {
		this.selfEval = selfEval;
	}

	public Integer getDeptEval() {
		return deptEval;
	}

	public void setDeptEval(Integer deptEval) {
		this.deptEval = deptEval;
	}

	public Integer getManagerEval() {
		return managerEval;
	}

	public void setManagerEval(Integer managerEval) {
		this.managerEval = managerEval;
	}

	public Integer getCompanyEval() {
		return companyEval;
	}

	public void setCompanyEval(Integer companyEval) {
		this.companyEval = companyEval;
	}

	public Integer getColleaguesEval() {
		return colleaguesEval;
	}

	public void setColleaguesEval(Integer colleaguesEval) {
		this.colleaguesEval = colleaguesEval;
	}
	
    public Set getUsers() {
		return users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}
	

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Set getJoininsForSid() {
		return joininsForSid;
	}

	public void setJoininsForSid(Set joininsForSid) {
		this.joininsForSid = joininsForSid;
	}
	
	public Set getPmTasksForSid() {
		return pmTasksForSid;
	}

	public void setPmTasksForSid(Set pmTasksForSid) {
		this.pmTasksForSid = pmTasksForSid;
	}
}
