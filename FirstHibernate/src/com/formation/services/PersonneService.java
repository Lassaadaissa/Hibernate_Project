package com.formation.services;

import java.util.List;

import com.formation.entities.Personne;

public interface PersonneService {
	public String save(Personne pers) throws Exception;
	public void delete(Personne pers ) throws Exception;
	public String update(Personne pers)throws Exception;
	public List<Personne>findAll()throws Exception;
	
}
