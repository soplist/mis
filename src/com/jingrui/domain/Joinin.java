package com.jingrui.domain;

public class Joinin {
    private Integer jid;
    private Integer type;
    private User userByUid;
    private Options optionsBySid;
    
    public Joinin(){
    	
    }
    public Joinin(Integer jid,Integer type,User userByUid,Options optionsBySid){
    	this.jid=jid;
    	this.type=type;
    	this.userByUid=userByUid;
    	this.optionsBySid=optionsBySid;
    }
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public User getUserByUid() {
		return userByUid;
	}
	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}
	public Options getOptionsBySid() {
		return optionsBySid;
	}
	public void setOptionsBySid(Options optionsBySid) {
		this.optionsBySid = optionsBySid;
	}
	
}
