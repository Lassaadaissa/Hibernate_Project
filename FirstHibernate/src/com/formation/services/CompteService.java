package com.formation.services;

import java.util.List;

import com.formation.entities.Compte;

public interface CompteService {
	public String save(Compte pers) throws Exception;
	public void delete(Compte pers ) throws Exception;
	public String update(Compte pers)throws Exception;
	public List<Compte>findAll()throws Exception;
}
