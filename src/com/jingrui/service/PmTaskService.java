package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.Page;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.User;

public interface PmTaskService {
	public Integer add(PmTask pt);
	public void update(PmTask pt);
	public List<PmTask> getAll();
	public boolean currentMonthPMExist(User u,String month);
	public Long getTotalCount();
	public List<PmTask> queryByPage(Page page);
}
