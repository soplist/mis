package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.UserLoginInformation;
import com.jingrui.service.UserLoginInformationService;

/**
 * <p>Title: UserLoginInformationServiceImpl.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-11 ÏÂÎç4:37:49
 */

public class UserLoginInformationServiceImpl implements UserLoginInformationService {
	
	private static final Integer EMPTY_LIST_SIZE = 0;
	private BaseDAO<UserLoginInformation> baseDao;

	public BaseDAO<UserLoginInformation> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<UserLoginInformation> baseDao) {
		this.baseDao = baseDao;
	}
	
	public UserLoginInformation getById(int id){
		UserLoginInformation userLoginInformation = baseDao.get(UserLoginInformation.class, id);
		return userLoginInformation;
	}
	
	public void update(UserLoginInformation userLoginInformation){
		baseDao.update(userLoginInformation);
	}

	public void add(UserLoginInformation userLoginInformation) {
		// TODO Auto-generated method stub
		baseDao.add(userLoginInformation);
	}
	
	public UserLoginInformation getUserLoginInformationByUserId(Integer userId){
		List<UserLoginInformation> list = baseDao.qryInfo("from UserLoginInformation where userId="+userId);
		if(list.size() > EMPTY_LIST_SIZE)
		    return list.get(0);
		else 
			return null;
	}
}
