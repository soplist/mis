package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Page;
import com.jingrui.domain.Permission;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.User;
import com.jingrui.service.PmTaskService;
import com.jingrui.util.PageUtil;

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
	
	public List<PmTask> getAll(){
    	List<PmTask> list = baseDao.qryInfo("from PmTask");
    	return list;
    }
	
	public boolean currentMonthPMExist(User u,String month){
		List<PmTask> list = baseDao.qryInfo("from PmTask pt where pt.launchTime like '"+month+"%' and pt.userByUid.uid="+u.getUid());
		if(list.size()>0){
			return true;
		}else{
		    return false;
		}
	}
	
	public Long getTotalCount(){
		return baseDao.getTotalCount("PmTask");
	}
	
	public List<PmTask> queryByPage(Page page){
		List<PmTask> list = baseDao.queryByPage("from PmTask order by pid desc", page);
		return list;
	}
}
