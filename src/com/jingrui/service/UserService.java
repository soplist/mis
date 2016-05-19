package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.User;

public interface UserService {
	public User findUserByName(String name); 
	public void modifyUserPass(User u);
	public List<User> findAllUser();
}
