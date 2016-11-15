package com.jingrui.dao;

import java.sql.Connection;
import java.util.List;

import com.jingrui.domain.OriginalUserInfo;

public interface SqlServerDB {
	public Connection getConnection();
	public List<OriginalUserInfo> query();
	public List<String> queryAllUserName();
}
