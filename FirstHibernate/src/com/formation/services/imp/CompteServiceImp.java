package com.formation.services.imp;

import java.util.List;

import com.formation.dao.CompteDao;
import com.formation.dao.imp.CompteDaoImp;
import com.formation.entities.Compte;
import com.formation.services.CompteService;

public class CompteServiceImp implements CompteService{

	
	private CompteDao cptDao ;
	
	public CompteDao getCptDao() {
		return cptDao;
	}

	public void setCptDao(CompteDao cptDao) {
		this.cptDao = cptDao;
	}

	@Override
	public String save(Compte cpt) throws Exception {
		cptDao.saveOrUpdate(cpt);
		return "Ajout avec succes";
	}

	@Override
	public void delete(Compte cpt) throws Exception {
		cptDao.delete(cpt);
	}

	@Override
	public String update(Compte cpt) throws Exception {
		cptDao.saveOrUpdate(cpt);
		return "Modifier avec succes";
	}

	@Override
	public List<Compte> findAll() throws Exception {
		return cptDao.findAll(Compte.class);
	}

}
