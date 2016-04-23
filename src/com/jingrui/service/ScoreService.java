package com.jingrui.service;

import java.util.List;
import com.jingrui.domain.StaffScore;

public interface ScoreService {
	public List<StaffScore> listStaffScoreByRealName(String realName);
	public List<StaffScore> listStaffScore();
}
