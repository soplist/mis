package com.jingrui.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7791017111274422943L;
	private Integer did;
	private String departmentName;
	private Set staffScores = new HashSet(0);
	private Set customers = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department(String departmentName, Set staffScores) {
		this.departmentName = departmentName;
		this.staffScores = staffScores;
	}
	/** full constructor */
	public Department(String departmentName, Set staffScores,Set customers) {
		this.departmentName = departmentName;
		this.staffScores = staffScores;
		this.customers = customers;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set getStaffScores() {
		return this.staffScores;
	}

	public void setStaffScores(Set staffScores) {
		this.staffScores = staffScores;
	}
	public Set getCustomers() {
		return customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}
	
	public Set getUsers() {
		return users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}