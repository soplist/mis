package com.jingrui.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.jingrui.dao.CustomerDAO;
import com.jingrui.domain.Customer;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO {
	
	public CustomerDAOImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("CustomerDAOImpl create!");
	}
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public List<Customer> listCustomer() {
		String hql = "from Customer";
		List<Customer> list =this.getHibernateTemplate().find(hql);
		return list;
	}

	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
