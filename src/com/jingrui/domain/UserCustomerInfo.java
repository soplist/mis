package com.jingrui.domain;

import java.util.Map;
import java.util.TreeMap;

public class UserCustomerInfo {
	private String name;
	private Map<String,Integer> mapValue = new TreeMap<String,Integer>();
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getMapValue() {
		return mapValue;
	}
	public void setMapValue(Map<String, Integer> mapValue) {
		this.mapValue = mapValue;
	}
	
}
