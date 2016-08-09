package com.jingrui.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.jingrui.domain.Page;

public interface BaseDAO<T> {
	@SuppressWarnings("unchecked")
    public List<T> qryInfo(String hql);
    @SuppressWarnings("unchecked")
    public List<T> qryInfo(String hql, Object[] param);
    public void delete(T cls);
    public void update(T cls);
    public void add(T cls);
    public void setQueryParams(Query qry, Object[] params);
    public T get(Class<T> c, Serializable id);
    public Long getTotalCount(String table);
    public List<T> queryByPage(String hql,Page page);
}
