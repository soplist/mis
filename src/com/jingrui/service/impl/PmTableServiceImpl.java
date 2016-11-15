package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Page;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.User;
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
	
	public Long getFinishedTotalCountByUser(User user){
		return baseDao.getPmTableFinishedTotalCountByUser(user);
	}
	
	public List<PmTable> queryFinishedByPageAndUser(Page page,User user){
		List<PmTable> list = baseDao.queryByPage("from PmTable pt where pt.userByUid.uid="+user.getUid()+" and pt.statu=true order by pid desc", page);
		return list;
	}
	
	public List<PmTable> queryNotFinishedByUser(User user){
		List<PmTable> list = baseDao.qryInfo("from PmTable pt where pt.userByUid.uid="+user.getUid()+" and pt.statu=false order by pid desc");
		return list;
	}
	
	public PmTable getPmTableById(int id){
		PmTable pt = baseDao.get(PmTable.class, id);
		return pt;
	}
	
}
