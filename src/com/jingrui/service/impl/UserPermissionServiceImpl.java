package com.jingrui.service.impl;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.UserPermission;
import com.jingrui.service.UserPermissionService;

/**
 * <p>Title: UserPermissionServiceImpl.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-22 ÉÏÎç9:57:55
 */

public class UserPermissionServiceImpl implements UserPermissionService {
	
	private BaseDAO<UserPermission> baseDao;

	public BaseDAO<UserPermission> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<UserPermission> baseDao) {
		this.baseDao = baseDao;
	}
	
    public UserPermission getUserPermissionById(int id){
    	return baseDao.get(UserPermission.class, id);
    }
}
