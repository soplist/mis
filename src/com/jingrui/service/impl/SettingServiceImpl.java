package com.jingrui.service.impl;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Options;
import com.jingrui.service.SettingService;

public class SettingServiceImpl implements SettingService {
	private BaseDAO<Options> baseDao;
    public BaseDAO<Options> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDAO<Options> baseDao) {
		this.baseDao = baseDao;
	}
	public Integer insertSetting(Options opt){
    	baseDao.add(opt);
    	return opt.getSid();
    }
}
