package com.jingrui.dao;

import java.util.List;
import com.jingrui.domain.Customer;

public interface CustomerDAO {

	/**
	 * @param args
	 */
	public void insertCustomer(Customer customer);  
	public List<Customer> listCustomer();  
	public void deleteCustomer(Customer customer);  
	public void updateCustomer(Customer customer);  
	public Customer findCustomerById(int id);  
}
