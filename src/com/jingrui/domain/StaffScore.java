package com.jingrui.domain;

import java.util.Date;

/**
 * StaffScore entity. @author MyEclipse Persistence Tools
 */

public class StaffScore implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5820430603660062937L;
	/**
	 * 
	 */
	private Integer sid;
	private User userByOperatorId;
	private Department department;
	private User userByWhoFillPaperId;
	private User userByNameId;
	private Date occurTime;
	private Float score;
	private String category;
	private String event;
	private String comment;

	// Constructors

	/** default constructor */
	public StaffScore() {
	}

	/** minimal constructor */
	public StaffScore(User userByOperatorId, Department department,
			User userByWhoFillPaperId, User userByNameId, Date occurTime,
			String event) {
		this.userByOperatorId = userByOperatorId;
		this.department = department;
		this.userByWhoFillPaperId = userByWhoFillPaperId;
		this.userByNameId = userByNameId;
		this.occurTime = occurTime;
		this.event = event;
	}

	/** full constructor */
	public StaffScore(User userByOperatorId, Department department,
			User userByWhoFillPaperId, User userByNameId, Date occurTime,
			Float score, String category, String event, String comment) {
		this.userByOperatorId = userByOperatorId;
		this.department = department;
		this.userByWhoFillPaperId = userByWhoFillPaperId;
		this.userByNameId = userByNameId;
		this.occurTime = occurTime;
		this.score = score;
		this.category = category;
		this.event = event;
		this.comment = comment;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public User getUserByOperatorId() {
		return this.userByOperatorId;
	}

	public void setUserByOperatorId(User userByOperatorId) {
		this.userByOperatorId = userByOperatorId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUserByWhoFillPaperId() {
		return this.userByWhoFillPaperId;
	}

	public void setUserByWhoFillPaperId(User userByWhoFillPaperId) {
		this.userByWhoFillPaperId = userByWhoFillPaperId;
	}

	public User getUserByNameId() {
		return this.userByNameId;
	}

	public void setUserByNameId(User userByNameId) {
		this.userByNameId = userByNameId;
	}

	public Date getOccurTime() {
		return this.occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}