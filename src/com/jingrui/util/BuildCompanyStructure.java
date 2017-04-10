package com.jingrui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.jingrui.domain.UserInformation;
import com.jingrui.exception.DepartmentNotFoundException;

/**
 * <p>Title: BuildCompanyStructure.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-11 ÏÂÎç12:45:24
 */

public class BuildCompanyStructure {
    
	private LoadAllUserInformationXml loadAllUserInformationXml;
	private HashMap<String,ArrayList<UserInformation>> departmentStructureHashMap;
	private ArrayList<UserInformation> managerList;
	private UserInformation boss;
	private ArrayList<UserInformation> validUserList;
	
	public ArrayList<UserInformation> getValidUserList() {
		return validUserList;
	}

	public void setValidUserList(ArrayList<UserInformation> validUserList) {
		this.validUserList = validUserList;
	}

	public UserInformation getBoss() {
		return boss;
	}

	public void setBoss(UserInformation boss) {
		this.boss = boss;
	}

	public ArrayList<UserInformation> getManagerList() {
		return managerList;
	}

	public void setManagerList(ArrayList<UserInformation> managerList) {
		this.managerList = managerList;
	}

	public HashMap<String, ArrayList<UserInformation>> getDepartmentStructureHashMap() {
		return departmentStructureHashMap;
	}

	public void setDepartmentStructureHashMap(
			HashMap<String, ArrayList<UserInformation>> departmentStructureHashMap) {
		this.departmentStructureHashMap = departmentStructureHashMap;
	}

	public BuildCompanyStructure(LoadAllUserInformationXml loadAllUserInformationXml){
		this.departmentStructureHashMap = new HashMap<String,ArrayList<UserInformation>>();
		this.loadAllUserInformationXml = loadAllUserInformationXml;
		this.managerList = new ArrayList<UserInformation>();
		this.validUserList = new ArrayList<UserInformation>();
		
		buildDepartmentStructure();
		initManagerTeam();
		initBoss();
		initValidUserGroup();
	}
	
	public HashMap<String,ArrayList<UserInformation>> otherDepartmentStructureHashMap(String department) throws DepartmentNotFoundException{
		HashMap<String,ArrayList<UserInformation>> otherDepartmentStructureHashMap = new HashMap<String,ArrayList<UserInformation>>();
		if(departmentStructureHashMap.containsKey(department)){
			for (String key : departmentStructureHashMap.keySet()) {
				if(!key.equals(department)){
					otherDepartmentStructureHashMap.put(key, departmentStructureHashMap.get(key));
				}
			}
			return otherDepartmentStructureHashMap;
		}else{
			throw new DepartmentNotFoundException("department not found.");
		}
		
	}
	
	public ArrayList<UserInformation> otherDepartmentArrayList(String department) throws DepartmentNotFoundException{
		ArrayList<UserInformation> otherDepartmentArrayList = new ArrayList<UserInformation>();
		if(departmentStructureHashMap.containsKey(department)){
			for (String key : departmentStructureHashMap.keySet()) {
				if(!key.equals(department)){
					otherDepartmentArrayList.addAll(departmentStructureHashMap.get(key));
				}
			}
			return otherDepartmentArrayList;
		}else{
			throw new DepartmentNotFoundException("department not found.");
		}
		
	}

	public LoadAllUserInformationXml getLoadAllUserInformationXml() {
		return loadAllUserInformationXml;
	}

	public void setLoadAllUserInformationXml(
			LoadAllUserInformationXml loadAllUserInformationXml) {
		this.loadAllUserInformationXml = loadAllUserInformationXml;
	}
	
	public void buildDepartmentStructure(){
		ArrayList<UserInformation> userInformationList = loadAllUserInformationXml.getUserInformationList();
		for (UserInformation userInformation : userInformationList) {
			String department = userInformation.getUserResumeInformation().getDepartment();
			boolean workStatus = userInformation.isWorkStatus();
			
			if(workStatus){
			    if(departmentStructureHashMap.containsKey(department)){
				    ArrayList<UserInformation> departmentUserInformationList = departmentStructureHashMap.get(department);
				    departmentUserInformationList.add(userInformation);
			    }
			    else{
				    ArrayList<UserInformation> departmentUserInformationList = new ArrayList<UserInformation>();
				    departmentUserInformationList.add(userInformation);
				    departmentStructureHashMap.put(department, departmentUserInformationList);
			    }
			}
		}
	}
	
	public void initManagerTeam(){
		ArrayList<UserInformation> userInformationList = loadAllUserInformationXml.getUserInformationList();
		for (UserInformation userInformation : userInformationList) {
			boolean managerStatus = userInformation.getUserResumeInformation().isManagerStatus();
			boolean workStatus = userInformation.isWorkStatus();
			if(workStatus){
				if(managerStatus){
					managerList.add(userInformation);
				}
			}
		}
	}
	
	public void initBoss(){
		ArrayList<UserInformation> userInformationList = loadAllUserInformationXml.getUserInformationList();
		for (UserInformation userInformation : userInformationList) {
			boolean bossStatus = userInformation.getUserResumeInformation().isBossStatus();
			boolean workStatus = userInformation.isWorkStatus();
			if(workStatus){
				if(bossStatus){
					boss = userInformation;
				}
			}
		}
	}
	
	public UserInformation getUserInformationByUsername(String username){
		ArrayList<UserInformation> userInformationList = loadAllUserInformationXml.getUserInformationList();
		for (UserInformation userInformation : userInformationList) {
			if(userInformation.getUsername().equals(username)){
				return userInformation;
			}
		}
		return null;
	}
	
	public UserInformation getUserInformationByName(String name){
		ArrayList<UserInformation> userInformationList = loadAllUserInformationXml.getUserInformationList();
		for (UserInformation userInformation : userInformationList) {
			if(userInformation.getUserResumeInformation().getName().equals(name)){
				return userInformation;
			}
		}
		return null;
	}
	
	public void initValidUserGroup(){
		ArrayList<UserInformation> userInformationList = loadAllUserInformationXml.getUserInformationList();
		for (UserInformation userInformation : userInformationList) {
			boolean workStatus = userInformation.isWorkStatus();
			if(workStatus){
				validUserList.add(userInformation);
			}
		}
	}
	
	public UserInformation getUserInformationById(int id){
		ArrayList<UserInformation> userInformationList = loadAllUserInformationXml.getUserInformationList();
		for (UserInformation userInformation : userInformationList) {
			if(userInformation.getId()==id){
				return userInformation;
			}
		}
		return null;
	}
	
	
	
	public static void printManagerTeam(ArrayList<UserInformation> managerList){
		System.out.println("managers:");
		for (UserInformation userInformation : managerList) {
			System.out.print(userInformation.getUserResumeInformation().getName()+",");
		}
	}
	
	public static void printBoss(UserInformation boss){
		System.out.println("boss:"+boss.getUserResumeInformation().getName());
	}
	
	public static void printValidUserList(ArrayList<UserInformation> validUserList){
		System.out.println("valid user:");
		for (UserInformation userInformation : validUserList) {
			System.out.print(userInformation.getUserResumeInformation().getName()+",");
		}
	}
	
	public static void printDepartmentStructure(HashMap<String,ArrayList<UserInformation>> departmentStructureHashMap){
		Iterator<Entry<String, ArrayList<UserInformation>>> iter = departmentStructureHashMap.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry<String, ArrayList<UserInformation>> entry =  iter.next();
		    String department =  entry.getKey();
		    ArrayList<UserInformation> departmentUserInformationList = entry.getValue();
		    
		    System.out.println("department:"+department);
		    for (UserInformation userInformation : departmentUserInformationList) {
		    	System.out.print("name:"+userInformation.getUserResumeInformation().getName()+",");
			}
		    System.out.println("");
		}
	}
	public static void main(String[] args) {
		LoadAllUserInformationXml loadAllUserInformationXml = new LoadAllUserInformationXml();
		BuildCompanyStructure buildCompanyStructure = new BuildCompanyStructure(loadAllUserInformationXml);
		buildCompanyStructure.setLoadAllUserInformationXml(loadAllUserInformationXml);
		
		//printDepartmentStructure(buildCompanyStructure.getDepartmentStructureHashMap());
		//printManagerTeam(buildCompanyStructure.getManagerList());
		//printBoss(buildCompanyStructure.getBoss());
		//printValidUserList(buildCompanyStructure.getValidUserList());
		//UserInformation userInformation = buildCompanyStructure.getUserInformationById(15);
		//System.out.println(userInformation.getUserResumeInformation().getName());
		
		UserInformation userInformation = buildCompanyStructure.getUserInformationByUsername("wangkang");
		System.out.println(userInformation.getUserResumeInformation().getName());
	}
}
