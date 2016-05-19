package com.jingrui.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Department;
import com.jingrui.domain.StaffScore;
import com.jingrui.domain.User;
import com.jingrui.service.ScoreService;

public class ScoreServiceImpl implements ScoreService {
    private BaseDAO<StaffScore> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	public List<StaffScore> listStaffScoreByRealName(String realName){
		List<StaffScore> slist = new ArrayList<StaffScore>();
		StaffScore ss = new StaffScore();
		User u = new User();
		u.setUid(1);
		u.setName("wang");
		u.setPassword("123456");
		u.setRealName("王康1");
		
		Department d = new Department();
		d.setDid(1);
		d.setDepartmentName("新传媒事业部");
		
		
		ss.setSid(1);
		ss.setDepartment(d);
		ss.setUserByNameId(u);
		ss.setOccurTime(new Date());
		ss.setScore(50f);
		ss.setCategory("类别");
		ss.setEvent("打扫卫生");
		ss.setUserByWhoFillPaperId(u);
		ss.setComment("无");
		ss.setUserByOperatorId(u);
		
		slist.add(ss);
		return slist;
	}

	public List<StaffScore> listStaffScore() {
		// TODO Auto-generated method stub
		List<StaffScore> StaffScore = baseDao.qryInfo("from StaffScore");
		return StaffScore;
	}
	
}
