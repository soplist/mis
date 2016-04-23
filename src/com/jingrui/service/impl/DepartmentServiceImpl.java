package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Department;
import com.jingrui.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
    private BaseDAO<Department> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}

	public List<Department> listDptm() {
		// TODO Auto-generated method stub
		List<Department> list = baseDao.qryInfo("from Department");
		return list;
	}

}
