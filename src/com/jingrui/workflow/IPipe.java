package com.jingrui.workflow;

import java.util.List;

import com.jingrui.domain.Task;
import com.jingrui.domain.User;

public interface IPipe {
	public void lunch(Task task);
	public User lunch(Task task,String[] ids,User user);
	public void agree(int id);
	public boolean agree(int noticePeopleId,int taskId);
	public User agre(int noticePeopleId,int taskId,User user);
	public User reject(int taskId,User user);
	public List<Task> approve(int taskId,User user);
	public User delete(int taskId,User user);
}
