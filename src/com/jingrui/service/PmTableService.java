package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.Page;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.User;

public interface PmTableService {
	public void add(PmTable pt);
	public void update(PmTable pt);
	public List<PmTable> getPmTableByPmTaskId(Integer pmTaskId);
	public Long getFinishedTotalCountByUser(User user);
	public List<PmTable> queryFinishedByPageAndUser(Page page,User user);
	public List<PmTable> queryNotFinishedByUser(User user);
	public PmTable getPmTableById(int id);
}
