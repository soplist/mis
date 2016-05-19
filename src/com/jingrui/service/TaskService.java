package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.Task;


public interface TaskService {
	public void insertTask(Task task);
	public void getTask(Task task);
	public Task getLastTask();
	public void updateTaskStatusTo1ByTaskId(int taskId);
	public void update(Task task);
	public Task getTaskById(int id);
	public List<Task> getApproveTask();
	public List<Task> getArchiveTask();
}
