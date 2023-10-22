package com.projet.monuments.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name="lieu")
public class Lieu {
	
	public Lieu() {}
	public Lieu (String codeInsee, String nomCom, float longitude, float latitude, Departement dep) {
		this.codeInsee=codeInsee;
		this.nomCom=nomCom;
		this.longitude=longitude;
		this.latitude=latitude;
		this.dep=dep;
	}
	public Lieu(String codeInsee) {
		this.codeInsee=codeInsee;
	}
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "code_insee", length=5)
    private String codeInsee;
	@Column(name="latitude")

    private float latitude; 
	@Column(name="longitude")

	private float longitude;
	@Column(name="nomCom", length=46)
    private String nomCom;

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name="dep")   
    private Departement dep;
    
	public String getCodeInsee() {
		return codeInsee;
	}

	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	public String getNomCom() {
		return nomCom;
	}

	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public Departement getDep() {
		return dep;
	}

	public void setDep(Departement dep) {
		this.dep = dep;
	}
	




}
