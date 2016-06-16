package com.jingrui.service.impl;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Operate;
import com.jingrui.domain.Options;
import com.jingrui.service.OperateService;

public class OperateServiceImpl implements OperateService {
	
	private BaseDAO<Operate> baseDao;

	public BaseDAO<Operate> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<Operate> baseDao) {
		this.baseDao = baseDao;
	}

	public void insertOperate(Operate operate) {
		// TODO Auto-generated method stub
		this.baseDao.add(operate);
	}
}
