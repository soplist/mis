package com.jingrui.service;

import java.util.List;

import com.jingrui.domain.NoticePeople;

public interface NoticePeopleService {
	public void insertNoticePeopleList(List<NoticePeople> list);
	public void updateNoticePeopleStatusTo1ById(int id);
	public boolean existNoticePeopleWhereStatusIsFalseByTaskId(int taskId);
}
