package com.formation.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.dao.PersonneDao;
import com.formation.dao.imp.PersonneDaoImp;
import com.formation.entities.Personne;
import com.formation.services.CompteService;
import com.formation.services.PersonneService;

public class TestSpring {
	public static void main(String[] args) {
		
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	PersonneService persServ = (PersonneService) context.getBean("persServ");
	CompteService cptServ= (CompteService) context.getBean("cptServ");
	try {
		persServ.findAll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		cptServ.findAll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
