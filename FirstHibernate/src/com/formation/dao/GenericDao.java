package com.formation.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDao {
	public void saveOrUpdate(Object entity) throws Exception;
	public void delete(Object entity) throws Exception;
	public List findAll(Class cls) throws Exception;
	public List findByCriteria(Class cls, Criterion crit) throws Exception;
	public List findByCriteria(Class cls, Criterion crit1, Criterion crit2) throws Exception;
	
}
