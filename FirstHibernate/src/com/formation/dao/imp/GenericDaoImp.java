package com.formation.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.formation.dao.GenericDao;
import com.formation.util.HibernateUtil;

public class GenericDaoImp implements GenericDao{
	protected Session hibernateSession;
	private Transaction tx;
	
	protected void startOperation()
	{
		hibernateSession=HibernateUtil.getInstance().getSession();
		tx=hibernateSession.beginTransaction();
	}
	protected void endOperation()
	{
		tx.commit();
		hibernateSession.close();
	}
	
	
	@Override
	public void saveOrUpdate(Object entity) 
	{
		startOperation();
		hibernateSession.saveOrUpdate(entity);
		endOperation();
	}

	@Override
	public void delete(Object entity) 
	{
		startOperation();
		hibernateSession.delete(entity);
		endOperation();
	}

	@Override
	public List findAll(Class cls) 
	{
		startOperation();
		List list=hibernateSession.createCriteria(cls).list();	
		endOperation();
		return list;
	}

	@Override
	public List findByCriteria(Class cls, Criterion crit) 
	{
		startOperation();
		List list=hibernateSession.createCriteria(cls).add(crit).list();		//recherche par criteria 
		endOperation();
		return list;
	}

	@Override
	public List findByCriteria(Class cls, Criterion crit1, Criterion crit2) { //recherche par plusieurs criterier
		startOperation();
		List list=hibernateSession.createCriteria(cls).add(crit1).add(crit2).list();
		endOperation();
		return list;
	}

}
