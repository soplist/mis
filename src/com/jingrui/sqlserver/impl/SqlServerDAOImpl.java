package com.jingrui.sqlserver.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jingrui.domain.OriginalUserInfo;
import com.jingrui.sqlserver.SqlServerDAO;




public class SqlServerDAOImpl implements SqlServerDAO {
public void test(){
	System.out.println("SqlServerDAOImpl");
}
public Connection initConnection(){
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL="jdbc:sqlserver://61.150.109.162:53433;DatabaseName=points_management_DB";
    String userName="sa";
    String userPwd="akjr3838968";
    try{
        Class.forName(driverName);
        Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
        System.out.println("a.connect success");
        return dbConn;
    }catch(Exception e){
        e.printStackTrace();
        System.out.print("connect failure");
        return null;
    }
}

public List<OriginalUserInfo> query() {
	
	List<OriginalUserInfo> list = new ArrayList<OriginalUserInfo>();
    Connection conn = initConnection();
    String sql = "select CONVERT(CHAR(20),p.event_time,23),u.real_name,SUM(point_value) from points_management_DB_points as p inner join points_management_DB_user as u on p.user_id=u.no where DateDiff(dd,event_time,getdate())<=30 group by CONVERT(CHAR(20),p.event_time,23), u.real_name;";
    PreparedStatement pstmt;
    try {
        pstmt = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        //System.out.println("------------------------------");
        while (rs.next()) {
        	OriginalUserInfo oui = new OriginalUserInfo();
            for (int i = 1; i <= col; i++) {
            	if(i==1){
            		oui.setDate(rs.getString(i).trim());
            	}
            	else if(i==2){
            		oui.setName(rs.getString(i).trim());
            	}
            	else{
            		oui.setValue(rs.getInt(i));
            	}
                //System.out.println(rs.getString(i) + " ");
            }
            list.add(oui);
            //System.out.println("");
        }
        //System.out.println("------------------------------");
        pstmt.close();
        conn.close();
        return list;
    } catch (SQLException e) {
    	e.printStackTrace();
    	return null;
    }
    
}

public List<String> queryAllUserName(){
	List<String> list = new ArrayList<String>();
    Connection conn = initConnection();
    String sql = "select real_name from points_management_DB_user;";
    PreparedStatement pstmt;
    try {
        pstmt = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int col = rs.getMetaData().getColumnCount();
        while (rs.next()) {
        	list.add(rs.getString(1));
        }
        pstmt.close();
        conn.close();
        return list;
    } catch (SQLException e) {
    	e.printStackTrace();
    	return null;
    }
}
}
