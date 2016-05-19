package com.jingrui.workflow.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.Operate;
import com.jingrui.domain.Task;
import com.jingrui.domain.User;
import com.jingrui.service.NoticePeopleService;
import com.jingrui.service.OperateService;
import com.jingrui.service.TaskService;
import com.jingrui.service.UserService;
import com.jingrui.workflow.IPipe;

public class PipeImpl implements IPipe {
	private TaskService taskService;
	private NoticePeopleService noticePeopleService;
	private UserService userService;
	private OperateService operateService;
	
    public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
	public NoticePeopleService getNoticePeopleService() {
		return noticePeopleService;
	}

	public void setNoticePeopleService(NoticePeopleService noticePeopleService) {
		this.noticePeopleService = noticePeopleService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	public OperateService getOperateService() {
		return operateService;
	}

	public void setOperateService(OperateService operateService) {
		this.operateService = operateService;
	}

	public PipeImpl(){
    	
    }
    
    public void lunch(Task task){
    	taskService.insertTask(task);
    }
  
    
    
    public User lunch(Task task,String[] ids,User user){
    	taskService.insertTask(task);
    	
    	List<NoticePeople> npList = new ArrayList<NoticePeople>();
    	Task t = taskService.getLastTask();
    	for(int i=0;i<ids.length;i++){
    		NoticePeople np = new NoticePeople();
    		
    		User u = new User();
    		u.setUid(new Integer(ids[i]));
    		
    		np.setTaskByTaskId(t);
    		np.setUserByUserId(u);
    		np.setStatus(false);
    		
    		npList.add(np);
    	}
    	
    	noticePeopleService.insertNoticePeopleList(npList);
    	
    	//operate
    	Operate opt = new Operate();
    	opt.setTaskByTaskId(task);
    	opt.setUserByUserId(user);
    	opt.setOpt(0);
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
    	opt.setDate(date);
    	
    	operateService.insertOperate(opt);
    	
    	return userService.findUserByName(user.getName());
    }
    
    public void agree(int noticePeopleId){
    	noticePeopleService.updateNoticePeopleStatusTo1ById(noticePeopleId);
    }
    
    //if update task status,return true,else return false
    public boolean agree(int noticePeopleId,int taskId){
    	noticePeopleService.updateNoticePeopleStatusTo1ById(noticePeopleId);
    	boolean exist = noticePeopleService.existNoticePeopleWhereStatusIsFalseByTaskId(taskId);
    	if(!exist){
    		taskService.updateTaskStatusTo1ByTaskId(taskId);
    		return true;
    	}
    	return false;
    }
    
    public User agre(int noticePeopleId,int taskId,User user){
    	noticePeopleService.updateNoticePeopleStatusTo1ById(noticePeopleId);
    	boolean exist = noticePeopleService.existNoticePeopleWhereStatusIsFalseByTaskId(taskId);
    	if(!exist){
    		taskService.updateTaskStatusTo1ByTaskId(taskId);
    	}
    	
    	//operate
    	Operate opt = new Operate();
    	Task task = new Task();
    	task.setTid(taskId);
    	opt.setTaskByTaskId(task);
    	opt.setUserByUserId(user);
    	opt.setOpt(1);
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
    	opt.setDate(date);
    	
    	operateService.insertOperate(opt);
    	
    	return userService.findUserByName(user.getName());
    }
    
    public User reject(int taskId,User user){
    	Task t = taskService.getTaskById(taskId);
    	t.setStatus(3);
    	taskService.update(t);
    	
    	//operate
    	Operate opt = new Operate();
    	Task task = new Task();
    	task.setTid(taskId);
    	opt.setTaskByTaskId(task);
    	opt.setUserByUserId(user);
    	opt.setOpt(3);
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
    	opt.setDate(date);
    	
    	operateService.insertOperate(opt);
    	
    	return userService.findUserByName(user.getName());
    }
    
    public User delete(int taskId,User user){
    	Task t = taskService.getTaskById(taskId);
    	t.setStatus(4);
    	taskService.update(t);
    	
    	//operate
    	Operate opt = new Operate();
    	Task task = new Task();
    	task.setTid(taskId);
    	opt.setTaskByTaskId(task);
    	opt.setUserByUserId(user);
    	opt.setOpt(4);
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
    	opt.setDate(date);
    	
    	operateService.insertOperate(opt);
    	
    	return userService.findUserByName(user.getName());
    }
    
    public List<Task> approve(int taskId,User user){
    	Task t = taskService.getTaskById(taskId);
    	t.setStatus(2);
    	taskService.update(t);
    	
    	//operate
    	Operate opt = new Operate();
    	Task task = new Task();
    	task.setTid(taskId);
    	opt.setTaskByTaskId(task);
    	opt.setUserByUserId(user);
    	opt.setOpt(2);
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
    	opt.setDate(date);
    	
    	operateService.insertOperate(opt);
    	
    	return taskService.getApproveTask();
    }
}
