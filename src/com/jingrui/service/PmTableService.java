package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.PmTable;

public interface PmTableService {
	public void add(PmTable pt);
	public void update(PmTable pt);
	public List<PmTable> getPmTableByPmTaskId(Integer pmTaskId);
}
