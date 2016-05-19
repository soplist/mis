package com.jingrui.domain;

public class NoticePeople  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3336619497104635559L;
	
	private Integer nid;
	private Task taskByTaskId;
	private User userByUserId;
	private Boolean status;
	
	public NoticePeople(){
		
	}
	
    public NoticePeople(Integer nid,Task taskByTaskId,User userByUserId,Boolean status){
		this.nid = nid;
		this.taskByTaskId = taskByTaskId;
		this.userByUserId = userByUserId;
		this.status = status;
	}
    
	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
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
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
