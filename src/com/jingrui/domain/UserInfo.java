package com.jingrui.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserInfo {
    private Integer id;
    private String name;
    private Integer day1;
    private Map<String,Integer> mapValue = new TreeMap<String,Integer>();
    
	public Map<String, Integer> getMapValue() {
		return mapValue;
	}
	public void setMapValue(Map<String, Integer> mapValue) {
		this.mapValue = mapValue;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDay1() {
		return day1;
	}
	public void setDay1(Integer day1) {
		this.day1 = day1;
	}
	
}
