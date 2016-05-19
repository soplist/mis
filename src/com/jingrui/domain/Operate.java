package com.jingrui.domain;

public class Operate implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3081507689346099176L;
	
	private Integer oid;
    private Task taskByTaskId;
	private User userByUserId;
	private Integer opt;
	private String opinion;
	private String date;
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Task getTaskByTaskId() {
		return taskByTaskId;
	}
	public void setTaskByTaskId(Task taskByTaskId) {
		this.taskByTaskId = taskByTaskId;
	}
	public User getUserByUserId() {
		return userByUserId;
	}
	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}
	public Integer getOpt() {
		return opt;
	}
	public void setOpt(Integer opt) {
		this.opt = opt;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
