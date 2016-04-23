package com.jingrui.domain;

import java.util.Date;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer1 implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5782366108817034314L;
	private Integer cid;
	private Date startDate;
	private String company;
	private Float cost;
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
	private int department;
	private String area;

	// Constructors

	/** default constructor */
	public Customer1() {
	}

	/** minimal constructor */
	public Customer1(Date startDate, String legalRepresentative) {
		this.startDate = startDate;
		this.legalRepresentative = legalRepresentative;
	}

	public Customer1(Date startDate, String company, Float cost,
			String legalRepresentative, String officeStaff,
			String detailedAddress, String officeTelephone, String cellphone,
			String qq, String micromsg, String introduction,
			String cooperationProject, String possibleBusiness,
			String clientEvaluation, String comment) {
		this.startDate = startDate;
		this.company = company;
		this.cost = cost;
		this.legalRepresentative = legalRepresentative;
		this.officeStaff = officeStaff;
		this.detailedAddress = detailedAddress;
		this.officeTelephone = officeTelephone;
		this.cellphone = cellphone;
		this.qq = qq;
		this.micromsg = micromsg;
		this.introduction = introduction;
		this.cooperationProject = cooperationProject;
		this.possibleBusiness = possibleBusiness;
		this.clientEvaluation = clientEvaluation;
		this.comment = comment;
	}
	/** full constructor */
	public Customer1(Date startDate, String company, Float cost,
			String legalRepresentative, String officeStaff,
			String detailedAddress, String officeTelephone, String cellphone,
			String qq, String micromsg, String introduction,
			String cooperationProject, String possibleBusiness,
			String clientEvaluation, String comment,int department,String area) {
		this.startDate = startDate;
		this.company = company;
		this.cost = cost;
		this.legalRepresentative = legalRepresentative;
		this.officeStaff = officeStaff;
		this.detailedAddress = detailedAddress;
		this.officeTelephone = officeTelephone;
		this.cellphone = cellphone;
		this.qq = qq;
		this.micromsg = micromsg;
		this.introduction = introduction;
		this.cooperationProject = cooperationProject;
		this.possibleBusiness = possibleBusiness;
		this.clientEvaluation = clientEvaluation;
		this.comment = comment;
		this.department = department;
		this.area = area;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Float getCost() {
		return this.cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getLegalRepresentative() {
		return this.legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getOfficeStaff() {
		return this.officeStaff;
	}

	public void setOfficeStaff(String officeStaff) {
		this.officeStaff = officeStaff;
	}

	public String getDetailedAddress() {
		return this.detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getOfficeTelephone() {
		return this.officeTelephone;
	}

	public void setOfficeTelephone(String officeTelephone) {
		this.officeTelephone = officeTelephone;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMicromsg() {
		return this.micromsg;
	}

	public void setMicromsg(String micromsg) {
		this.micromsg = micromsg;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCooperationProject() {
		return this.cooperationProject;
	}

	public void setCooperationProject(String cooperationProject) {
		this.cooperationProject = cooperationProject;
	}

	public String getPossibleBusiness() {
		return this.possibleBusiness;
	}

	public void setPossibleBusiness(String possibleBusiness) {
		this.possibleBusiness = possibleBusiness;
	}

	public String getClientEvaluation() {
		return this.clientEvaluation;
	}

	public void setClientEvaluation(String clientEvaluation) {
		this.clientEvaluation = clientEvaluation;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

}
