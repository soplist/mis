package com.jingrui.domain;

public class Area {
    private String key;
    private String value;
    public String getKey() {
		return key;
	}
    
    public Area(String key,String value){
    	this.key = key;
    	this.value = value;
    }
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
