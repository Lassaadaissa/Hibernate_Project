package com.formation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.formation.entities.Personne;
import com.formation.services.PersonneService;
import com.formation.services.imp.PersonneServiceImp;

@ManagedBean
@ViewScoped
public class PersonneBean implements Serializable {

	/**
	 * 
	 */
	@ManagedProperty(value="#{persServ}")
	private PersonneService perServ;
	private static final long serialVersionUID = 1L;
	private Personne pers=new Personne();
	
	public PersonneService getPerServ() {
		return perServ;
	}

	public void setPerServ(PersonneService perServ) {
		this.perServ = perServ;
	}

	private List<Personne> list=new ArrayList<Personne>();
	private boolean btnAdd =true , btnEdit=false, read = false;
	
	public void clickEdit() {
		btnAdd=false;
		btnEdit=true;
		read=true;
	}
			
	public boolean isBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(boolean btnAdd) {
		this.btnAdd = btnAdd;
	}

	public boolean isBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(boolean btnEdit) {
		this.btnEdit = btnEdit;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void ajouter() {
		
		try {
			perServ.save(pers);
			pers=new Personne();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void annuler() {
		 
		 pers=new Personne();
	}
	
	public void supprimer() {
		try {
			perServ.delete(pers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifier()
	{
		try {
			perServ.update(pers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pers=new Personne();
	}

	public Personne getPers() {
		return pers;
	}

	public void setPers(Personne pers) {
		this.pers = pers;
	}
	
	public List<Personne> getList() {
		try {
			list=perServ.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public void setList(List<Personne> list) {
		this.list = list;
	}
	
}
