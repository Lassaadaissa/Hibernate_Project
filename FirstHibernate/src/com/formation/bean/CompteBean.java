package com.formation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.formation.entities.Compte;
import com.formation.entities.Personne;
import com.formation.services.CompteService;
import com.formation.services.imp.CompteServiceImp;

@ManagedBean
@ViewScoped
public class CompteBean implements Serializable {

	@ManagedProperty(value="#{cptServ}")
	private CompteService cptServ;

	private List<Compte> list = new ArrayList<Compte>();
	private Compte cpt = new Compte();
	private Personne persn = new Personne();
	private boolean btnAdd, btnEdit;

	public void ajouter() {
		try {

			System.out.println("*****");
			cpt.setPersonne(persn);
			cptServ.save(cpt);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes", "Ajout Effectuer Avec succes."));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed", "Erreur."));

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void supprimer() {
		try {
			cptServ.delete(cpt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickEdit() {
		btnAdd = false;
		btnEdit = true;
		persn = cpt.getPersonne();
	}

	public void clickAdd() {
		btnAdd = true;
		btnEdit = false;
		persn = new Personne();
		cpt = new Compte();

	}

	public void modifier() {
		try {

			System.out.println("*****");
			cpt.setPersonne(persn);
			cptServ.update(cpt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Compte> getList() {
		try {
			list = cptServ.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Compte getCpt() {
		return cpt;
	}

	public void setCpt(Compte cpt) {
		this.cpt = cpt;
	}

	public CompteService getCptServ() {
		return cptServ;
	}

	public void setCptServ(CompteService cptServ) {
		this.cptServ = cptServ;
	}

	public void setList(List<Compte> list) {
		this.list = list;
	}

	public Personne getPersn() {
		return persn;
	}

	public void setPersn(Personne persn) {
		this.persn = persn;
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

}