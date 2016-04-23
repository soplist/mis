package com.jingrui.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7754022511322707279L;
	private Integer pid;
	private String pmnName;
	private Boolean c;
	private Boolean r;
	private Boolean u;
	private Boolean d;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** minimal constructor */
	public Permission(String pmnName) {
		this.pmnName = pmnName;
	}

	/** full constructor */
	public Permission(String pmnName, Boolean c, Boolean r, Boolean u,
			Boolean d, Set users) {
		this.pmnName = pmnName;
		this.c = c;
		this.r = r;
		this.u = u;
		this.d = d;
		this.users = users;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPmnName() {
		return this.pmnName;
	}

	public void setPmnName(String pmnName) {
		this.pmnName = pmnName;
	}

	public Boolean getC() {
		return this.c;
	}

	public void setC(Boolean c) {
		this.c = c;
	}

	public Boolean getR() {
		return this.r;
	}

	public void setR(Boolean r) {
		this.r = r;
	}

	public Boolean getU() {
		return this.u;
	}

	public void setU(Boolean u) {
		this.u = u;
	}

	public Boolean getD() {
		return this.d;
	}

	public void setD(Boolean d) {
		this.d = d;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}