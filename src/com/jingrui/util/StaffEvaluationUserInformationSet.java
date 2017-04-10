package com.jingrui.util;

import java.util.HashSet;
import java.util.Set;

import com.jingrui.domain.User;
import com.jingrui.domain.UserInformation;

/**
 * <p>Title: StaffEvaluationUserInformationSet.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-17 ÏÂÎç2:29:18
 */

public class StaffEvaluationUserInformationSet {
	
	private Set<UserInformation> userInformationSet = new HashSet<UserInformation>();
	private int capacity = 0;//
	private static final boolean NOT_FULL_STATUS = false;
	private static final boolean FULL_STATUS = true;
	
	private UserInformation currentUserInformation = null;
	
	public Set<UserInformation> getUserInformationSet() {
		return userInformationSet;
	}

	public void setUserInformationSet(Set<UserInformation> userInformationSet) {
		this.userInformationSet = userInformationSet;
	}
	
	
	public StaffEvaluationUserInformationSet(UserInformation currentUserInformation,int capacity){
		this.currentUserInformation = currentUserInformation;
		this.capacity = capacity;
	}
	
	public boolean add(UserInformation userInformation){
		for (UserInformation ui : userInformationSet) {
			if(ui.getId() == userInformation.getId()){
				return NOT_FULL_STATUS;
			}
		}
		
		if(!userInformation.getUserResumeInformation().isManagerStatus()
				&&!userInformation.getUserResumeInformation().isBossStatus()
				&&userInformation.getId() != currentUserInformation.getId()){
			userInformationSet.add(userInformation);
		}
		
		if(size()>=capacity){
			return FULL_STATUS;
		}else{
			return NOT_FULL_STATUS;
		}
		
		
	}
	public Integer size(){
		return userInformationSet.size();
	}
}
