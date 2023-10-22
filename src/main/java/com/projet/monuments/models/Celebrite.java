package com.projet.monuments.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity @Table(name="celebrite")
public class Celebrite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "num_celebrite", length=11)
	private int numCelebrite;
	@Column(name="epoque", length=10)
	private String epoque;
	@Column(name="nationalite",length=35)
	private String nationalite;
	@Column(name="prenom", length=35)
	private String prenom;
	@Column(name="nom", length=35)
	private String nom;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JoinTable ( name = "associea",
			joinColumns = @JoinColumn( name = "num_celebrite" ),
            inverseJoinColumns = @JoinColumn( name = "geohash"))
	private List<Monument> monuments;

	
	public Celebrite() {}
	public Celebrite (int numCelebrite, String nom, String prenom, String nationalite, String epoque) {
		this.numCelebrite=numCelebrite;
		this.nom=nom;
		this.prenom=prenom;
		this.nationalite=nationalite;
		this.epoque=epoque;
	}
	public Celebrite (String nom, String prenom, String nationalite, String epoque) {
		this.nom=nom;
		this.prenom=prenom;
		this.nationalite=nationalite;
		this.epoque=epoque;
	}
	public int getNumCelebrite() {
		return numCelebrite;
	}
	public void setNumCelebrite(int numCelebrite) {
		this.numCelebrite = numCelebrite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getEpoque() {
		return epoque;
	}
	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}
	public List<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

	

}
