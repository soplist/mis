package com.jingrui.service.impl;

import java.util.List;
import java.util.Set;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.User;
import com.jingrui.service.UserService;

public class UserServiceImpl implements UserService {

    private BaseDAO<User> baseDao;
	
    public UserServiceImpl() {
		// TODO Auto-generated constructor stub
    	System.out.println("UserServiceImpl create!");
	}
    
    public BaseDAO getBaseDao() {
		return baseDao;
	}
    public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}

    public List<User> findAllUser(){
    	List<User> list = baseDao.qryInfo("from User");
    	return list;
    }
    
	
	
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		List<User> list = baseDao.qryInfo("from User where name='"+name+"'");
		User u = null;
		if(list.size()>0){
		    u = list.get(0);
		    //Set s = u.getStaffScoresForNameId();
		    //System.out.println("Set StaffScoresForNameId size:"+s.size());
		    
		}
		return u;
	}
	
	public void modifyUserPass(User u){
		System.out.println("User.uid:"+u.getUid());
		baseDao.update(u);
	}
	
	public void update(User u){
		baseDao.update(u);
	}
	
    public List<User> getAllManagers(){
    	List<User> list = baseDao.qryInfo("from User where ismanager=true");
    	return list;
    }
    
    public List<User> getAllManagersAndOnTheJob(){
    	List<User> list = baseDao.qryInfo("from User where ismanager=true and validity=true");
    	return list;
    }
    
    public List<User> getAllUserValidity(){
    	List<User> list = baseDao.qryInfo("from User where validity=true");
    	return list;
    }
}
