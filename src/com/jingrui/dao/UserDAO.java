package com.jingrui.dao;

import com.jingrui.domain.User;




public interface UserDAO {
	public User findUserByName(String name);  
}
