package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.Joinin;

public interface JoininService {
	public void updateSidBySid(int old_sid,int new_sid);
	public void update(Joinin j);
	public void insert(Joinin j);
	public List<Joinin> getJoininsByTypeAndSid(int type,int sid);
	public void delete(Joinin j);
}
