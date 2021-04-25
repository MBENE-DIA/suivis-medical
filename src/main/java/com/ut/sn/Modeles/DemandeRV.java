package com.ut.sn.Modeles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class DemandeRV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date_demande;

	@OneToOne
	private Patient patient ;
	
	@OneToOne
	private Medecin medecin ;

	public DemandeRV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeRV( Date date_demande, Patient patient, Medecin medecin) {
		super();
		this.date_demande = date_demande;
		this.patient = patient;
		this.medecin = medecin;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(Date date_demande) {
		this.date_demande = date_demande;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	

}
