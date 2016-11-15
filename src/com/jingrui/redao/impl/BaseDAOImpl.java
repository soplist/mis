package com.jingrui.redao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.jingrui.redao.BaseDAO;
import com.jingrui.domain.Page;
import com.jingrui.domain.User;

public class BaseDAOImpl<T> implements BaseDAO<T>{
	  
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Session qryCurrentSesion() {
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    public List<T> qryInfo(String hql) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("qryInfo start:"+df.format(new Date()));
		Session session = this.qryCurrentSesion();
		List<T> list = session.createQuery(hql).list();
		session.close();
		System.out.println("qryInfo end:"+df.format(new Date()));
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<T> qryInfo(String hql, Object[] param) {
    	Query qry = null;
    	List<T> list = null;
    	try {
    		qry = this.qryCurrentSesion().createQuery(hql);
            setQueryParams(qry, param);
            list = qry.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return list;
    }

    public void delete(T cls) {

        // illegally attempted to associate a proxy with
        // two open Sessions
        Object obj = this.getCurrentSession().merge(cls);
        this.getCurrentSession().delete(obj);
    }

    public void update(T cls) {
        this.getCurrentSession().update(cls);
    }

    public void add(T cls) {
    	Session session = null;
    	try{
    	    System.out.println("BaseDAOImpl add");
    	    session = this.qryCurrentSesion();
    	    session.beginTransaction();  
    	    session.save(cls);
    	    session.getTransaction().commit();
    	}catch(Exception e){
    		e.printStackTrace();
    		session.getTransaction().rollback();
    	}finally{
    		if(session != null){
    			if(session.isOpen()){
    				session.close();
    			}
    		}
    	}
    }

    public void setQueryParams(Query qry, Object[] params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                qry.setParameter(i, params[i]);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public T get(Class<T> c, Serializable id) {  
        return (T) this.getCurrentSession().get(c, id);  
    }  
    
    public Long getTotalCount(String table){
    	return (Long) this.getCurrentSession().createQuery("select count(*) from "+table).uniqueResult();
	}
    
    public Long getPmTableFinishedTotalCountByUser(User user){
    	return (Long) this.getCurrentSession().createQuery("select count(*) from PmTable pt where pt.userByUid.uid="+user.getUid()+" and pt.statu=true").uniqueResult();
	}
    
    public String catchPmTaskLastMonth(){
    	return (String) this.getCurrentSession().createQuery("select launchTime from PmTask order by pid desc").uniqueResult();
    }
    
    public List<T> queryByPage(String hql,Page page){
    	Query qry = null;
    	List<T> list = null;
    	try {
    		Session session = this.qryCurrentSesion();
    		qry = session.createQuery(hql);
    		qry.setMaxResults(page.getEveryPage());  
            qry.setFirstResult(page.getBeginIndex());  
            list = qry.list();
            session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return list;
    }
}
