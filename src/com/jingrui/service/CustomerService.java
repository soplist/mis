package com.jingrui.service;

import java.util.List;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Page;
import com.jingrui.domain.User;

public interface CustomerService {
	public void insertCustomer(Customer customer);  
    public List<Customer> listCustomer();  
    public List<Customer> listCustomerByCompany(String company);
    public List<Customer> listCustomerByArea(String area);
    public List<Customer> listCustomerByCompanyAndLegalRepr(String company,String repr);
    public void delete(Customer customer);  
	public void deleteById(int id);
    public void update(Customer customer);  
    public Customer findCustomerById(int id);   
    public List<Customer> queryCustomersByPage(Page page);
    public Long getTotalCount();
    public List<Customer> queryCustomerBetweenTwoTimes(String date1,String date2);
}
