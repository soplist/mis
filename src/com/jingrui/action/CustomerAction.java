package com.jingrui.action;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jingrui.domain.Area;
import com.jingrui.domain.Customer;
import com.jingrui.domain.Department;
import com.jingrui.domain.Page;
import com.jingrui.domain.PmTask;
import com.jingrui.domain.User;
import com.jingrui.service.CustomerService;
import com.jingrui.service.DepartmentService;
import com.jingrui.service.UserService;
import com.jingrui.util.PageUtil;
import com.jingrui.util.StringHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	
	private static Logger logger = Logger.getLogger(CustomerAction.class);
	
	private CustomerService customerService;
	//private UserService userService;
	private DepartmentService departmentService;
	private String startDate;
	private String company;
	private String cost;
	private String legalRepresentative;
	private String officeStaff;
	private String detailedAddress;
	private String officeTelephone;
	private String cellphone;
	private String qq;
	private String micromsg;
	private String introduction;
	private String cooperationProject;
	private String possibleBusiness;
	private String clientEvaluation;
	private String comment;
	private int did;
	private String area;
	private int cid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
    public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	public String getOfficeStaff() {
		return officeStaff;
	}
	public void setOfficeStaff(String officeStaff) {
		this.officeStaff = officeStaff;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getOfficeTelephone() {
		return officeTelephone;
	}
	public void setOfficeTelephone(String officeTelephone) {
		this.officeTelephone = officeTelephone;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMicromsg() {
		return micromsg;
	}
	public void setMicromsg(String micromsg) {
		this.micromsg = micromsg;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCooperationProject() {
		return cooperationProject;
	}
	public void setCooperationProject(String cooperationProject) {
		this.cooperationProject = cooperationProject;
	}
	public String getPossibleBusiness() {
		return possibleBusiness;
	}
	public void setPossibleBusiness(String possibleBusiness) {
		this.possibleBusiness = possibleBusiness;
	}
	public String getClientEvaluation() {
		return clientEvaluation;
	}
	public void setClientEvaluation(String clientEvaluation) {
		this.clientEvaluation = clientEvaluation;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//public UserService getUserService() {
		//return userService;
	//}
	//public void setUserService(UserService userService) {
		//this.userService = userService;
	//}
	public CustomerAction() {
		// TODO Auto-generated constructor stub
		System.out.println("CustomerAction create!");
	}
    public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String add(){
		logger.info("add customer.");
		HttpServletRequest request = ServletActionContext.getRequest();
		this.startDate = request.getParameter("startDate");
		this.company = request.getParameter("company");
		this.cost = request.getParameter("cost");
		this.legalRepresentative = request.getParameter("legalRepresentative");
		this.officeStaff = request.getParameter("officeStaff");
		this.detailedAddress = request.getParameter("detailedAddress");
		this.officeTelephone = request.getParameter("officeTelephone");
		this.cellphone = request.getParameter("cellphone");
		this.qq = request.getParameter("qq");
		this.micromsg = request.getParameter("micromsg");
		this.introduction = request.getParameter("introduction");
		this.cooperationProject = request.getParameter("cooperationProject");
		this.possibleBusiness = request.getParameter("possibleBusiness");
		this.clientEvaluation = request.getParameter("clientEvaluation");
		this.comment = request.getParameter("comment");
		System.out.println("add customer.department:"+request.getParameter("department"));
		this.did = new Integer(request.getParameter("department"));
		this.area = request.getParameter("area");
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		//DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
		
		System.out.println("customer action,add customer.");
		Customer c = new Customer();
		try {
			System.out.println("start date:"+this.startDate);
		    c.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(this.startDate));
		    c.setCompany(this.company);
		    c.setCost(new Float(this.cost));
		    c.setLegalRepresentative(this.legalRepresentative);
		    c.setOfficeStaff(this.officeStaff);
		    c.setDetailedAddress(this.detailedAddress);
		    c.setOfficeTelephone(this.officeTelephone);
		    c.setCellphone(this.cellphone);
		    c.setQq(this.qq);
		    c.setMicromsg(this.micromsg);
		    c.setIntroduction(this.introduction);
		    c.setCooperationProject(this.cooperationProject);
		    c.setPossibleBusiness(this.possibleBusiness);
		    c.setClientEvaluation(this.clientEvaluation);
		    c.setComment(this.comment);
		    Department d = new Department();
		    d.setDid(this.did);
		    c.setDepartment(d);
		    c.setArea(this.area);
		    c.setAddUser(u);
		    c.setAddDate(date);
		    
		    if(customerService == null)
			    System.out.println("customerService is null in add!");
		    customerService.insertCustomer(c);
		} catch (Exception e) {
			    e.printStackTrace();
		}
    	return "addCustomer";
    }
	
	public String update(){
		logger.info("update customer.");
		HttpServletRequest request = ServletActionContext.getRequest();
		this.startDate = request.getParameter("startDate");
		this.company = request.getParameter("company");
		this.cost = request.getParameter("cost");
		this.legalRepresentative = request.getParameter("legalRepresentative");
		this.officeStaff = request.getParameter("officeStaff");
		this.detailedAddress = request.getParameter("detailedAddress");
		this.officeTelephone = request.getParameter("officeTelephone");
		this.cellphone = request.getParameter("cellphone");
		this.qq = request.getParameter("qq");
		this.micromsg = request.getParameter("micromsg");
		this.introduction = request.getParameter("introduction");
		this.cooperationProject = request.getParameter("cooperationProject");
		this.possibleBusiness = request.getParameter("possibleBusiness");
		this.clientEvaluation = request.getParameter("clientEvaluation");
		this.comment = request.getParameter("comment");
		System.out.println("add customer.department:"+request.getParameter("department"));
		this.did = new Integer(request.getParameter("department"));
		this.area = request.getParameter("area");
		this.cid = new Integer(request.getParameter("cid"));
		
		
		System.out.println("customer action,add customer.");
		Customer c = new Customer();
		try {
			System.out.println("start date:"+this.startDate);
		    c.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(this.startDate));
		    c.setCompany(this.company);
		    c.setCost(new Float(this.cost));
		    c.setLegalRepresentative(this.legalRepresentative);
		    c.setOfficeStaff(this.officeStaff);
		    c.setDetailedAddress(this.detailedAddress);
		    c.setOfficeTelephone(this.officeTelephone);
		    c.setCellphone(this.cellphone);
		    c.setQq(this.qq);
		    c.setMicromsg(this.micromsg);
		    c.setIntroduction(this.introduction);
		    c.setCooperationProject(this.cooperationProject);
		    c.setPossibleBusiness(this.possibleBusiness);
		    c.setClientEvaluation(this.clientEvaluation);
		    c.setComment(this.comment);
		    Department d = new Department();
		    d.setDid(this.did);
		    c.setDepartment(d);
		    c.setArea(this.area);
		    c.setCid(this.cid);
		
		
		    if(customerService == null)
			    System.out.println("customerService is null in update!");
		    customerService.update(c);
		 } catch (Exception e) {
			    e.printStackTrace();
		 }
		return "updateCustomer";
	}
	
	public String previousAdd(){
		logger.info("previous add customer.");
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Department> list = departmentService.listDptm();
		System.out.println("previousAdd list.size():"+list.size());
	    request.setAttribute("departlist",list);
	    
	    String []s= {"汉滨区","旬阳县","石泉县","汉阴县","平利县","白河县","紫阳县","岚皋县","宁陕县","镇坪县"};
	    HttpSession session=ServletActionContext.getRequest().getSession();
	    List<Area> areaList = new ArrayList<Area>();
	    for(int i=0;i<s.length;i++){
	    	Area a = new Area(s[i],s[i]);
	    	areaList.add(a);
	    }
	    session.removeAttribute("areaList");
	    session.setAttribute("areaList", areaList);
		return "addCustomer";
	}
	
	public String previousUpdate(){
		logger.info("previous update customer.");
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Department> list = departmentService.listDptm();
		System.out.println("previousAdd list.size():"+list.size());
	    request.setAttribute("departlist",list);
	    
	    String []s= {"汉滨区","旬阳县","石泉县","汉阴县","平利县","白河县","紫阳县","岚皋县","宁陕县","镇坪县"};
	    HttpSession session=ServletActionContext.getRequest().getSession();
	    List<Area> areaList = new ArrayList<Area>();
	    for(int i=0;i<s.length;i++){
	    	Area a = new Area(s[i],s[i]);
	    	areaList.add(a);
	    }
	    session.removeAttribute("areaList");
	    session.setAttribute("areaList", areaList);
		
		int id = new Integer(ServletActionContext.getRequest().getParameter("id").trim()) ;
		System.out.println("CustomerAction.previousUpdate.id:"+id);
		Customer c = customerService.findCustomerById(id);
	    request.removeAttribute("customer");
	    request.setAttribute("customer",c);
		return "updateCustomer";
	}
    
    public String list(){
    	/*logger.info("list customer.");
    	HttpServletRequest req = ServletActionContext.getRequest();
		String sflag = req.getParameter("sflag");
		if(sflag!=null && "1".equals(sflag)){
			return "listCustomer";
		}else{
		    if(customerService == null)
			    System.out.println("customerService is null in list!");
    	    Map request = (Map)ActionContext.getContext().get("request");
    	    request.remove("list");
    	    request.put("list",customerService.listCustomer());
    	    return "listCustomer";
		}*/
    	HttpServletRequest request = ServletActionContext.getRequest();
	    request.removeAttribute("list");
	    request.setAttribute("list",customerService.listCustomer());
	    return "listCustomer";
    	
    }
    
    public String listByCompany(){
    	//HttpServletRequest req = ServletActionContext.getRequest();
		//String company = req.getParameter("company");
		//System.out.println("method listByCompany in CustomerAction,company="+company);
    	logger.info("list customer by company.");
    	
    	HttpServletRequest request = ServletActionContext.getRequest();
    	List<Customer> list = null;
    	try {
    		list = customerService.listCustomerByCompany(this.company);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("method listByCompany in CustomerAction,list.size="+list.size());
    	request.removeAttribute("list");
    	request.setAttribute("list",list);
    	return "listCustomer";
    }
    
    public String listByCompanyAndLegalRepr(){
    	logger.info("list customer by company and representative.");
    	HttpServletRequest request = ServletActionContext.getRequest();
    	List<Customer> list = null;
    	try {
    		list = customerService.listCustomerByCompanyAndLegalRepr(this.company,this.legalRepresentative);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("method listByCompanyAndLegalRepr in CustomerAction,list.size="+list.size());
    	request.removeAttribute("list");
    	request.setAttribute("list",list);
    	return "listCustomer";
    }
    
    public String listByDepartment(){
    	logger.info("list customer by department.");
    	HttpSession session=ServletActionContext.getRequest().getSession();
    	HttpServletRequest request = ServletActionContext.getRequest();
		
		int id = new Integer(request.getParameter("dept").trim()) ;
		//System.out.println("listByDepartment.dept:"+dept);
		List<Department> list = (List<Department>) session.getAttribute("dptmlist");
		
		System.out.println("listByDepartment.list.size:"+list.size());
		for (Department department : list) {
			if(department.getDid() == id){
				Set<Customer> cstms = department.getCustomers();
				Set<Customer> set=StringHelper.cutdownIntroduction(cstms);
				request.removeAttribute("list");
				request.setAttribute("list",set);
			}
		}
    	
    	return "listCustomer";
    }
    
    public String listByArea(){
    	logger.info("list customer by area");
    	HttpSession session=ServletActionContext.getRequest().getSession();
    	HttpServletRequest request = ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("UTF-8");
			String area = request.getParameter("area").trim().toString();
			String s = StringHelper.decode(area);
			System.out.println(s);
			List<Customer> list = customerService.listCustomerByArea(s);
			request.removeAttribute("list");
	    	request.setAttribute("list",list);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listCustomer";
    }
    
    public String delete(){
    	int id = new Integer(ServletActionContext.getRequest().getParameter("id").trim()) ;
    	System.out.println("delete customer id:"+id);
    	customerService.deleteById(id);
    	
    	HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		logger.info("delete customer by id:"+u.getRealName());
    	
    	HttpServletRequest request = ServletActionContext.getRequest();
    	List<Customer> list = customerService.listCustomer();
    	System.out.println("list size:"+list.size());
    	request.removeAttribute("list");
    	request.setAttribute("list",list);
    	return "listCustomer";
    }
    
    public String parseDate(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
    
    public String listCustomersByPage(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String pageIndex = request.getParameter("pageIndex");
		Integer int_pageIndex = Integer.parseInt(pageIndex);
		Page customer_page = (Page) session.getAttribute("customer_page");
		customer_page = PageUtil.createPage(customer_page.getEveryPage(), customer_page.getTotalCount(), int_pageIndex);
		customer_page.setCurrentPage(int_pageIndex);
		
		List<Customer> customerList = customerService.queryCustomersByPage(customer_page);
		
		session.setAttribute("customer_page", customer_page);
		request.setAttribute("list", customerList);
		
		return "listCustomer";
	}
}
