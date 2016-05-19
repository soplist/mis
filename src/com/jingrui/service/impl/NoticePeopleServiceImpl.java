package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.StaffScore;
import com.jingrui.domain.Task;
import com.jingrui.service.NoticePeopleService;

public class NoticePeopleServiceImpl implements NoticePeopleService {
	
    private BaseDAO<NoticePeople> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	
	public void insertNoticePeopleList(List<NoticePeople> list){
		for(int i=0;i<list.size();i++)
			this.baseDao.add(list.get(i));
		
	}
	
	public void updateNoticePeopleStatusTo1ById(int id){
		NoticePeople np = baseDao.get(NoticePeople.class, id);
		np.setStatus(true);
		this.baseDao.update(np);
	}
	
	public boolean existNoticePeopleWhereStatusIsFalseByTaskId(int taskId){
		List<NoticePeople> np = this.baseDao.qryInfo("from NoticePeople np where np.taskByTaskId.tid="+taskId+" and np.status=false");
		if(np.size()==0||np==null){
			return false;
		}
		else{
			return true;
		}
	}

}
