package com.jingrui.service.impl;

import java.util.List;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Page;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.User;
import com.jingrui.service.CustomerService;
import com.jingrui.util.StringHelper;

public class CustomerServiceImpl implements CustomerService {
    private BaseDAO<Customer> baseDao;
	
    public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
    	System.out.println("CustomerServiceImpl create!");
	}

	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.baseDao.add(customer);
	}

	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list_1 = baseDao.qryInfo("from Customer order by cid desc");
		System.out.println("customer list size:"+list_1.size());
		List<Customer> list_2=StringHelper.cutdownIntroduction(list_1);
		return list_2;
	}
	
	public List<Customer> listCustomerByCompanyAndLegalRepr(String company,String repr){
		List<Customer> list = baseDao.qryInfo("from Customer c where c.company like '%"+company+"%' and c.legalRepresentative like '%"+repr+"%'");
		list = StringHelper.cutdownIntroduction(list);
		return list;
	}
	
	public List<Customer> listCustomerByArea(String area){
		List<Customer> list = baseDao.qryInfo("from Customer c where area='"+area+"'");
		list = StringHelper.cutdownIntroduction(list);
		return list;
	}
	
	public List<Customer> listCustomerByCompany(String company){
		String s[] = new String[]{"'%"+company+"%'"};
		System.out.println("s[0]:"+s[0]);
		List<Customer> list = baseDao.qryInfo("from Customer c where c.company like '%"+company+"%'");
		list = StringHelper.cutdownIntroduction(list);
		return list;
	}
	
	public void delete(Customer customer) {
		
	}
	
	public void deleteById(int id){
		// TODO Auto-generated method stub
				Customer c = findCustomerById(id);
				baseDao.delete(c);
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		baseDao.update(customer);
	}

	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer c = baseDao.get(Customer.class, id);
		return c;
	}
	
	public List<Customer> queryCustomersByPage(Page page){
		List<Customer> list = baseDao.queryByPage("from Customer order by cid desc", page);
		return list;
	}
	
	public Long getTotalCount(){
		return baseDao.getTotalCount("Customer");
	}
	
	public List<Customer> queryCustomerBetweenTwoTimes(String date1,String date2){
		List<Customer> list = baseDao.qryInfo("from Customer c where addDate between '"+date1+"' and '"+date2+"'");
		return list;
	}

}
