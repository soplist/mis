package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Permission;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.User;
import com.jingrui.service.PermissionService;

public class PermissionServiceImpl implements PermissionService {
private BaseDAO<Permission> baseDao;
	
    public BaseDAO getBaseDao() {
	    return baseDao;
    }
    public void setBaseDao(BaseDAO baseDao) {
	    this.baseDao = baseDao;
    }
    public List<Permission> getAll(){
    	List<Permission> list = baseDao.qryInfo("from Permission");
    	return list;
    }
    
    public void update(Permission permission){
    	baseDao.update(permission);
    }
    
    public Integer getNormalPermissionId(){
    	List<Permission> list = baseDao.qryInfo("from Permission p where p.pmnName='normal'");
    	return list.get(0).getPid();
    }
    
}
