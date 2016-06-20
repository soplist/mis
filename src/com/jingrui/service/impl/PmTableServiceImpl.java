package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.PmTable;
import com.jingrui.service.PmTableService;

public class PmTableServiceImpl implements PmTableService {
	private BaseDAO<PmTable> baseDao;

	public BaseDAO<PmTable> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<PmTable> baseDao) {
		this.baseDao = baseDao;
	}
	
	public void add(PmTable pt){
		baseDao.add(pt);
	}
	
	public void update(PmTable pt){
		baseDao.update(pt);
	}
	
	public List<PmTable> getPmTableByPmTaskId(Integer pmTaskId){
		List<PmTable> list = baseDao.qryInfo("from PmTable pt where pt.pmTaskByTid.pid="+pmTaskId);
		return list;
	}
}
