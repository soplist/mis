package com.jingrui.util;

import java.util.HashSet;
import java.util.Set;

import com.jingrui.domain.User;

public class UserSet {
	private Set<User> userSet = new HashSet<User>();
	private int capacity = 0;//
	private int size=0;
	private boolean full = false;
	private User currentUser = null;
	public UserSet(User u,int capacity){
		currentUser = u;
		this.capacity = capacity;
	}
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> testSet) {
		this.userSet = testSet;
	}
	public boolean add(User u){
		boolean exist = false;
		for (User user : userSet) {
			if(user.getUid().equals(u.getUid())){
				exist = true;
			}
		}
		if(!exist&&u.getIsmanager().equals(false)&&u.getIsboss().equals(false)&&!u.getUid().equals(currentUser.getUid())&&size<capacity){
			userSet.add(u);
			size++;
		}
		if(size==capacity){
			full = true;
			return full;
		}else{
			return full;
		}
		
		
	}
	public Integer size(){
		return userSet.size();
	}

}
