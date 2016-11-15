package com.jingrui.domain;

import java.util.Date;

public class PmTable implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2686864906087890077L;
	private Integer pid;
    private User userByUid;
    private PmTask pmTaskByTid;
    private boolean statu;
    private Integer type;
    private Date finishTime;
    
    private Float item1;
    private Float item2;
    private Float item3;
    private Float item4;
    private Float item5;
    private Float item6;
    private Float item7;
    private Float item8;
    private Float item9;
    private Float item10;
    
    private boolean simple;
    private Float item11;
    
    private Float item12;
    private Float item13;
    
    private Integer managerType;
    
	public Integer getManagerType() {
		return managerType;
	}
	public void setManagerType(Integer managerType) {
		this.managerType = managerType;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public User getUserByUid() {
		return userByUid;
	}
	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}
	public PmTask getPmTaskByTid() {
		return pmTaskByTid;
	}
	public void setPmTaskByTid(PmTask pmTaskByTid) {
		this.pmTaskByTid = pmTaskByTid;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
	public Float getItem1() {
		return item1;
	}
	public void setItem1(Float item1) {
		this.item1 = item1;
	}
	public Float getItem2() {
		return item2;
	}
	public void setItem2(Float item2) {
		this.item2 = item2;
	}
	public Float getItem3() {
		return item3;
	}
	public void setItem3(Float item3) {
		this.item3 = item3;
	}
	public Float getItem4() {
		return item4;
	}
	public void setItem4(Float item4) {
		this.item4 = item4;
	}
	public Float getItem5() {
		return item5;
	}
	public void setItem5(Float item5) {
		this.item5 = item5;
	}
	public Float getItem6() {
		return item6;
	}
	public void setItem6(Float item6) {
		this.item6 = item6;
	}
	public Float getItem7() {
		return item7;
	}
	public void setItem7(Float item7) {
		this.item7 = item7;
	}
	public Float getItem8() {
		return item8;
	}
	public void setItem8(Float item8) {
		this.item8 = item8;
	}
	public Float getItem9() {
		return item9;
	}
	public void setItem9(Float item9) {
		this.item9 = item9;
	}
	public Float getItem10() {
		return item10;
	}
	public void setItem10(Float item10) {
		this.item10 = item10;
	}
	public boolean isSimple() {
		return simple;
	}
	public void setSimple(boolean simple) {
		this.simple = simple;
	}
	public Float getItem11() {
		return item11;
	}
	public void setItem11(Float item11) {
		this.item11 = item11;
	}
	public Float getItem12() {
		return item12;
	}
	public void setItem12(Float item12) {
		this.item12 = item12;
	}
	public Float getItem13() {
		return item13;
	}
	public void setItem13(Float item13) {
		this.item13 = item13;
	}
}
