package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.ManagerEvaluateSetting;
import com.jingrui.domain.PmTask;
import com.jingrui.service.ManagerEvaluateSettingService;

public class ManagerEvaluateSettingServiceImpl implements ManagerEvaluateSettingService{
    private BaseDAO<ManagerEvaluateSetting> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<ManagerEvaluateSetting> getAllManagerEvaluateSetting(){
		List<ManagerEvaluateSetting> list = baseDao.qryInfo("from ManagerEvaluateSetting");
    	return list;
	}
	
	public void update(ManagerEvaluateSetting mes){
		baseDao.update(mes);
	}
}
