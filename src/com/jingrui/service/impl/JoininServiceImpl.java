package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Joinin;
import com.jingrui.domain.StaffScore;
import com.jingrui.service.JoininService;

public class JoininServiceImpl implements JoininService {
    private BaseDAO<Joinin> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	public void updateSidBySid(int old_sid,int new_sid){
		List<Joinin> jList = baseDao.qryInfo("from Joinin j where sid="+old_sid);
		for (Joinin joinin : jList) {
			joinin.getOptionsBySid().setSid(new_sid);
			baseDao.update(joinin);
		}
	}
	
	public void update(Joinin j){
		baseDao.update(j);
	}
	
	public void insert(Joinin j){
		baseDao.add(j);
	}
	
	public List<Joinin> getJoininsByTypeAndSid(int type,int sid){
		List<Joinin> jList = baseDao.qryInfo("from Joinin j where sid="+sid+" and type="+type);
		return jList;
	}
	
	public void delete(Joinin j){
		baseDao.delete(j);
	}
}
