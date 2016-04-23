package com.jingrui.service;

import com.jingrui.domain.User;

public interface UserService {
	public User findUserByName(String name); 
	public void modifyUserPass(User u);
}
