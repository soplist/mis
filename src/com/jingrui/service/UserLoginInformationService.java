package com.jingrui.service;

import com.jingrui.dao.BaseDAO;
import com.jingrui.domain.PmTable;
import com.jingrui.domain.UserLoginInformation;
import com.jingrui.service.impl.UserLoginInformationServiceImpl;

/**
 * <p>Title: UserLoginInformationService.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-11 ÏÂÎç4:37:24
 */

public interface UserLoginInformationService {
	
	
	public UserLoginInformation getById(int id);
	
	public void update(UserLoginInformation userLoginInformation);
	
	public void add(UserLoginInformation userLoginInformation);
	
	public UserLoginInformation getUserLoginInformationByUserId(Integer userId);
}
