package com.jingrui.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.jingrui.dao.PointDAO;
import com.jingrui.dao.SqlServerDB;
import com.jingrui.dao.impl.PointDAOImpl;
import com.jingrui.dao.impl.SqlServerDBImpl;
import com.jingrui.domain.OriginalUserInfo;
import com.jingrui.domain.UserInfo;
import com.jingrui.service.SqlServerService;
import com.jingrui.sqlserver.SqlServerDAO;

public class SqlServerServiceImpl implements SqlServerService {
	/*private PointDAO pointDAO;
	public PointDAO getPointDAO() {
		return pointDAO;
	}

	public void setPointDAO(PointDAO pointDAO) {
		this.pointDAO = pointDAO;
	}*/
	private SqlServerDAO sqlServerDAO;
	public SqlServerDAO getSqlServerDAO() {
		return sqlServerDAO;
	}

	public void setSqlServerDAO(SqlServerDAO sqlServerDAO) {
		this.sqlServerDAO = sqlServerDAO;
	}

	private SqlServerDB sqlServerDB;
	public SqlServerDB getSqlServerDB() {
		return sqlServerDB;
	}
	public void setSqlServerDB(SqlServerDB sqlServerDB) {
		this.sqlServerDB = sqlServerDB;
	}
	//method name avoid use 'get' or 'set' start
	public List<UserInfo> catchUser(){
    	List<UserInfo> list = new ArrayList<UserInfo>();
    	//UserInfo u1 = new UserInfo();
    	//u1.setId(1);
    	//u1.setName("wangkang");
    	//u1.setDay1(20);
    	//Map<String,Integer> value1 = u1.getMapValue();
    	//value1.put("2016-10-27", 20);
    	//list.add(u1);
    	
    	
    	//UserInfo u2 = new UserInfo();
    	//u2.setId(2);
    	//u2.setName("laanyi");
    	//u2.setDay1(30);
    	//Map<String,Integer> value2 = u2.getMapValue();
    	//value2.put("2016-10-27", 30);
    	//list.add(u2);
    	//sqlServerDB = new SqlServerDBImpl();
    	//if(sqlServerDB==null)
    		//System.out.println("sqlServerDB null");
    	//List<OriginalUserInfo> originalUserInfoList = sqlServerDB.query();
    	
    	//sqlServerDB.getConnection();
    	//list = initUserInfoList(list);
    	List<OriginalUserInfo> originalUserInfoList = sqlServerDAO.query();
    	list = initUserInfoList(list);
    	loadUserInfoFromOriginalUserInfo(originalUserInfoList,list);
    	System.out.println("problem is where?");
    	return list;
    }
	
	private List<UserInfo> initUserInfoList(List<UserInfo> list){
		List<String> nameList = sqlServerDAO.queryAllUserName();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (String name : nameList) {
			Calendar calendar = Calendar.getInstance();
			UserInfo ui = new UserInfo();
			ui.setName(name);
			Map<String,Integer> mapValue = ui.getMapValue();
			for(int i=1;i<=30;i++){
				calendar.add(Calendar.DATE, -1);
				String date = sdf.format(calendar.getTime());
				mapValue.put(date, 0);
			}
			list.add(ui);
		}
		
		return list;
	}
	
	private void loadUserInfoFromOriginalUserInfo(List<OriginalUserInfo> originalUserInfoList,List<UserInfo> userInfoList){
		for (OriginalUserInfo originalUserInfo : originalUserInfoList) {
			String name = originalUserInfo.getName();
			String date = originalUserInfo.getDate();
			Integer value = originalUserInfo.getValue();
			System.out.println(name+","+date+","+value);
			
			UserInfo userInfo = null;
			for (UserInfo ui : userInfoList) {
				if(ui.getName().equals(name)){
					userInfo = ui;
				}
			}
			
			Map<String,Integer> mapValue = userInfo.getMapValue();
			Integer valueForDay = mapValue.get(date);
			mapValue.put(date, valueForDay+value);
			
			/*for (UserInfo ui : userInfoList) {
				String printName = ui.getName();
				System.out.print(printName+":");
				Map<String,Integer> printMapValue = ui.getMapValue();
				for (String key : printMapValue.keySet()) {
				    System.out.println("key="+ key + ",value=" + printMapValue.get(key)+";");
				}
			}
			
			System.out.println(" ");*/
		}
	}
}
