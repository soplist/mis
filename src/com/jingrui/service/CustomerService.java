package com.jingrui.service;

import java.util.List;
import com.jingrui.domain.Customer;

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
}
