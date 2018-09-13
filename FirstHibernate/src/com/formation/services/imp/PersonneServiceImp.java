package com.formation.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.formation.dao.PersonneDao;
import com.formation.dao.imp.PersonneDaoImp;
import com.formation.entities.Personne;
import com.formation.services.PersonneService;

public class PersonneServiceImp implements PersonneService{

	private PersonneDao persDao;
	
	public PersonneDao getPersDao() {
		return persDao;
	}

	public void setPersDao(PersonneDao persDao) {
		this.persDao = persDao;
	}

	public String save(Personne pers) throws Exception 
	{
		Criterion crit=Restrictions.idEq(pers.getCin());
		List<Personne> list=persDao.findByCriteria(Personne.class, crit);
		if(!list.isEmpty())
		{
			return "Cin Existant";			
		}
		crit=Restrictions.eq("EMail", pers.getEMail());
		list=persDao.findByCriteria(Personne.class, crit);
		if(!list.isEmpty())
		{
			return "Email Existant";
			
		}
		persDao.saveOrUpdate(pers);
		return "Ajout Avec succes" ;
	}

	@Override
	public String update(Personne pers) throws Exception{
		Criterion crit1= Restrictions.idEq(pers.getCin());
		Criterion crit2= Restrictions.eq("EMail",pers.getEMail());
		
		List<Personne> list =persDao.findByCriteria(Personne.class, crit1,crit2);
		
		if(list.isEmpty())
		{
			list=persDao.findByCriteria(Personne.class,  crit2);
		}
		if(!list.isEmpty())
		{
			return "Email Existant";
		}
		persDao.saveOrUpdate(pers);
		return "Modification Avec succes";
	}

	@Override
	public List<Personne> findAll() throws Exception {
		
		return persDao.findAll(Personne.class);
	}

	@Override
	public void delete(Personne pers) throws Exception {
		persDao.delete(pers);
	}

}

