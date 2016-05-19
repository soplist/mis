package com.jingrui.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7373603539214292445L;
	/**
	 * 
	 */
	private Integer uid;
	private String name;
	private String password;
	private String realName;
	private Set staffScoresForOperatorId = new HashSet(0);
	private Set staffScoresForWhoFillPaperId = new HashSet(0);
	private Set staffScoresForNameId = new HashSet(0);
	private Permission permission;
	private Set noticePeoplesForUserId = new HashSet(0);
	private Set OperatesForUserId = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public User(String name, String password,String realName) {
		this.name = name;
		this.password = password;
		this.realName = realName;
	}
	
	public User(String name, String password, String realName,
			Set staffScoresForOperatorId, Set staffScoresForWhoFillPaperId,
			Set staffScoresForNameId) {
		this.name = name;
		this.password = password;
		this.realName = realName;
		this.staffScoresForOperatorId = staffScoresForOperatorId;
		this.staffScoresForWhoFillPaperId = staffScoresForWhoFillPaperId;
		this.staffScoresForNameId = staffScoresForNameId;
	}

	
	public User(String name, String password, String realName,
			Set staffScoresForOperatorId, Set staffScoresForWhoFillPaperId,
			Set staffScoresForNameId,Permission permission) {
		this.name = name;
		this.password = password;
		this.realName = realName;
		this.staffScoresForOperatorId = staffScoresForOperatorId;
		this.staffScoresForWhoFillPaperId = staffScoresForWhoFillPaperId;
		this.staffScoresForNameId = staffScoresForNameId;
		this.permission = permission;
	}
	
	public User(String name, String password, String realName,
			Set staffScoresForOperatorId, Set staffScoresForWhoFillPaperId,
			Set staffScoresForNameId,Permission permission,Set noticePeoplesForUserId) {
		this.name = name;
		this.password = password;
		this.realName = realName;
		this.staffScoresForOperatorId = staffScoresForOperatorId;
		this.staffScoresForWhoFillPaperId = staffScoresForWhoFillPaperId;
		this.staffScoresForNameId = staffScoresForNameId;
		this.permission = permission;
		this.noticePeoplesForUserId = noticePeoplesForUserId;
	}

	/** full constructor */
	public User(String name, String password, String realName,
			Set staffScoresForOperatorId, Set staffScoresForWhoFillPaperId,
			Set staffScoresForNameId,Permission permission,Set noticePeoplesForUserId,Set OperatesForUserId) {
		this.name = name;
		this.password = password;
		this.realName = realName;
		this.staffScoresForOperatorId = staffScoresForOperatorId;
		this.staffScoresForWhoFillPaperId = staffScoresForWhoFillPaperId;
		this.staffScoresForNameId = staffScoresForNameId;
		this.permission = permission;
		this.noticePeoplesForUserId = noticePeoplesForUserId;
		this.OperatesForUserId = OperatesForUserId;
	}
	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Set getStaffScoresForOperatorId() {
		return this.staffScoresForOperatorId;
	}

	public void setStaffScoresForOperatorId(Set staffScoresForOperatorId) {
		this.staffScoresForOperatorId = staffScoresForOperatorId;
	}

	public Set getStaffScoresForWhoFillPaperId() {
		return this.staffScoresForWhoFillPaperId;
	}

	public void setStaffScoresForWhoFillPaperId(Set staffScoresForWhoFillPaperId) {
		this.staffScoresForWhoFillPaperId = staffScoresForWhoFillPaperId;
	}

	public Set getStaffScoresForNameId() {
		return this.staffScoresForNameId;
	}

	public void setStaffScoresForNameId(Set staffScoresForNameId) {
		this.staffScoresForNameId = staffScoresForNameId;
	}
	
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	public Set getNoticePeoplesForUserId() {
		return noticePeoplesForUserId;
	}

	public void setNoticePeoplesForUserId(Set noticePeoplesForUserId) {
		this.noticePeoplesForUserId = noticePeoplesForUserId;
	}
	
	public Set getOperatesForUserId() {
		return OperatesForUserId;
	}

	public void setOperatesForUserId(Set operatesForUserId) {
		OperatesForUserId = operatesForUserId;
	}

}