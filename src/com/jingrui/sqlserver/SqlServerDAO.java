package com.jingrui.sqlserver;

import java.sql.Connection;
import java.util.List;

import com.jingrui.domain.OriginalUserInfo;

public interface SqlServerDAO {
	public void test();
	public Connection initConnection();
	public List<OriginalUserInfo> query();
	public List<String> queryAllUserName();
}
