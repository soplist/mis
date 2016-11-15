package com.jingrui.service.impl;

import com.jingrui.dao.BaseDAO;
import com.jingrui.dao.TestDAO;
import com.jingrui.domain.PmTask;
import com.jingrui.service.Test1Service;
import com.jingrui.service.TestService;

public class TestServiceImpl implements TestService {
    private BaseDAO<PmTask> baseDao;
    private Test1Service test1Service;
    private TestDAO testDAO;
	
    public TestDAO getTestDAO() {
		return testDAO;
	}

	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}

	public Test1Service getTest1Service() {
		return test1Service;
	}

	public void setTest1Service(Test1Service test1Service) {
		this.test1Service = test1Service;
	}

	public BaseDAO<PmTask> getBaseDao() {
		return baseDao;
	}
    
    public void setBaseDao(BaseDAO<PmTask> baseDao) {
		this.baseDao = baseDao;
	}
    public void test(){
    	
    }
}
