package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.ManagerEvaluateSetting;

public interface ManagerEvaluateSettingService {
	public List<ManagerEvaluateSetting> getAllManagerEvaluateSetting();
	public void update(ManagerEvaluateSetting mes);
}
