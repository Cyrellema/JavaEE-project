package com.projet.monuments.models;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@Entity @Table(name="monument")
public class Monument {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "geohash", length=12)
	private String geohash;
	@Column(name="latitude")
	private float latitude;
	@Column(name="longitude")
	private float longitude;
@Column(name="typeM", length=20)
private String typeM;
@Column(name="proprietaire", length=10)
private String proprietaire;
@Column(name="nom", length=80)
private String nom;


	@ManyToOne (targetEntity = Lieu.class, fetch = FetchType.EAGER)
	@JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JoinColumn(name="code_insee")
    private Lieu codeInsee;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JoinTable ( name = "AssocieA", joinColumns = @JoinColumn( name = "geohash" ), inverseJoinColumns = @JoinColumn( name = "num_celebrite")) 
	private List<Celebrite> celebrites;
    
	public List<Celebrite> getCelebrites() {
		return celebrites;
	}

	public void setCelebrites(List<Celebrite> celebrites) {
		this.celebrites = celebrites;
	}
	
	public Monument() {}
	
	public Monument(String nom) {
		this.nom=nom;
	}
	
	public Monument (String geohash, String nom, String proprietaire, String typeM, float longitude, float latitude, Lieu codeInsee) {
		this.geohash=geohash;
		this.nom=nom;
		this.proprietaire=proprietaire;
		this.typeM=typeM;
		this.longitude=longitude;
		this.latitude=latitude;
		this.codeInsee=codeInsee;
	}


	public String getGeohash() {
		return geohash;
	}


	public void setGeohash(String geohash) {
		this.geohash = geohash;
	}
    
    public String getNom() {
        return nom;
    }

	public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getProprietaire() {
        return proprietaire;
    }
    
    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
    
    public String getTypeM() {
		return typeM;
	}


	public void setTypeM(String typeM) {
		this.typeM = typeM;
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

	public Lieu getCodeInsee() {
	return codeInsee;
	}


	public void setCodeInsee(Lieu codeInsee) {
		this.codeInsee = codeInsee;
	}





 
}
