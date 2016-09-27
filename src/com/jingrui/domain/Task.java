package com.jingrui.domain;

import java.util.HashSet;
import java.util.Set;

public class Task  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1074103618860745197L;
	
	private Integer tid;
	private String date;
    private String reason;
    private String scoreClass; 
    private Integer value;
    private Set NoticePeoplesForTaskId = new HashSet(0);
    private Integer status;
    //0--notice 1--approve 2--archive 3--reject 
    private Set OperatesForTaskId = new HashSet(0);
    
    

	public Task(){
    	
    }
    
    public Task(Integer tid,String date,String reason,String scoreClass,Integer value,Set NoticePeoplesForTaskId){
    	this.tid = tid;
    	this.date = date;
    	this.reason = reason;
    	this.scoreClass = scoreClass;
    	this.value = value;
    	this.NoticePeoplesForTaskId = NoticePeoplesForTaskId;
    }
    
    public Task(Integer tid,String date,String reason,String scoreClass,Integer value,Set NoticePeoplesForTaskId,Integer status){
    	this.tid = tid;
    	this.date = date;
    	this.reason = reason;
    	this.scoreClass = scoreClass;
    	this.value = value;
    	this.NoticePeoplesForTaskId = NoticePeoplesForTaskId;
    	this.status = status;
    }
    
    public Task(Integer tid,String date,String reason,String scoreClass,Integer value,Set NoticePeoplesForTaskId,Integer status,Set OperatesForTaskId){
    	this.tid = tid;
    	this.date = date;
    	this.reason = reason;
    	this.scoreClass = scoreClass;
    	this.value = value;
    	this.NoticePeoplesForTaskId = NoticePeoplesForTaskId;
    	this.status = status;
    	this.OperatesForTaskId = OperatesForTaskId;
    }
    
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getScoreClass() {
		return scoreClass;
	}
	public void setScoreClass(String scoreClass) {
		this.scoreClass = scoreClass;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Set getNoticePeoplesForTaskId() {
		return NoticePeoplesForTaskId;
	}
	public void setNoticePeoplesForTaskId(Set noticePeoplesForTaskId) {
		NoticePeoplesForTaskId = noticePeoplesForTaskId;
	}
	public Integer getStatus() {
		return status;
	}
    public void setStatus(Integer status) {
		this.status = status;
	}
    public Set getOperatesForTaskId() {
		return OperatesForTaskId;
	}
    public void setOperatesForTaskId(Set operatesForTaskId) {
		OperatesForTaskId = operatesForTaskId;
	}
}
