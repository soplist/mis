package com.jingrui.domain;

import java.util.HashSet;
import java.util.Set;

public class PmTask {
	private Integer pid;
	private Options optionsBySid;
	private boolean statu;
	private Set pmTablesForTid = new HashSet(0);
	private User userByUid;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Options getOptionsBySid() {
		return optionsBySid;
	}
	public void setOptionsBySid(Options optionsBySid) {
		this.optionsBySid = optionsBySid;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	public Set getPmTablesForTid() {
		return pmTablesForTid;
	}
	public void setPmTablesForTid(Set pmTablesForTid) {
		this.pmTablesForTid = pmTablesForTid;
	}
	public User getUserByUid() {
		return userByUid;
	}
	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}
}
