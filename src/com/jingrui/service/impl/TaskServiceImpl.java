package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.Task;
import com.jingrui.service.TaskService;


public class TaskServiceImpl implements TaskService {
	private BaseDAO<Task> baseDao;

	public BaseDAO<Task> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO<Task> baseDao) {
		this.baseDao = baseDao;
	}

	public void insertTask(Task task) {
		// TODO Auto-generated method stub
		this.baseDao.add(task);
	}
	
	public void getTask(Task task) {
		// TODO Auto-generated method stub
		
	}
	
	public Task getLastTask(){
		List<Task> list = this.baseDao.qryInfo("from Task where tid=(SELECT MAX(tsk.tid) FROM Task AS tsk)");
		return list.get(0);
	}
	
	public void updateTaskStatusTo1ByTaskId(int taskId){
		Task tsk = baseDao.get(Task.class, taskId);
		tsk.setStatus(1);
		this.baseDao.update(tsk);
	}
	
	public void update(Task task){
		this.baseDao.update(task);
	}
	
	public Task getTaskById(int id){
		return this.baseDao.get(Task.class, id);
	}

	public List<Task> getApproveTask(){
		return this.baseDao.qryInfo("from Task where status=1");
	}
	
	public List<Task> getArchiveTask(){
		return this.baseDao.qryInfo("from Task where status=2");
	}
	
}
