package com.jingrui.service.impl;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.PerformanceAppraisalTask;
import com.jingrui.domain.PmTask;
import com.jingrui.service.PerformanceAppraisalTaskService;

/**
 * <p>Title: PerformanceAppraisalTaskServiceImpl.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-17 ÉÏÎç9:41:56
 */

public class PerformanceAppraisalTaskServiceImpl implements PerformanceAppraisalTaskService {
    private BaseDAO<PerformanceAppraisalTask> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	
	public Integer add(PerformanceAppraisalTask performanceAppraisalTask){
		baseDao.add(performanceAppraisalTask);
		return performanceAppraisalTask.getId();
	}
}
