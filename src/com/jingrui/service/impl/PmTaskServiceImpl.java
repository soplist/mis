package com.jingrui.service.impl;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.PmTask;
import com.jingrui.service.PmTaskService;

public class PmTaskServiceImpl implements PmTaskService {
    private BaseDAO<PmTask> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	
	public Integer add(PmTask pt){
		baseDao.add(pt);
		return pt.getPid();
	}
	
	public void update(PmTask pt){
		baseDao.update(pt);
	}
}
