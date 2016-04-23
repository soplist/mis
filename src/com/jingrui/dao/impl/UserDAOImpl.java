package com.jingrui.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jingrui.dao.UserDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Customer ";
		return null;
	}

}
