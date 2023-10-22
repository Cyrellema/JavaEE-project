package com.projet.monuments.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity @Table(name="departement")
public class Departement {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dep", length=4)
	public String dep;
	@Column(name="nom_dep", length=30)
	private String nomDep;
	@Column(name="num_reg", length=4)
	private String numReg;

	@ManyToOne (fetch = FetchType.EAGER)
	@JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JoinColumn(name="code_insee")
	private Lieu codeInsee;
	
	public Departement () {}
	
	public Departement(String dep) {
		this.dep=dep;
	}
	
	public Departement (String dep, String nomDep, String numReg, Lieu codeInsee) {
		this.dep=dep;
		this.nomDep=nomDep;
		this.numReg=numReg;
		this.codeInsee=codeInsee;
	}
	
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getNomDep() {
		return nomDep;
	}
	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}
	public String getNumReg() {
		return numReg;
	}
	public void setNumReg(String numReg) {
		this.numReg = numReg;
	}

	public Lieu getCodeInsee() {
		return codeInsee;
	}

	public void setCodeInsee(Lieu codeInsee) {
		this.codeInsee = codeInsee;
	}

	/*public String toString() {
		return "departement [dep=" + dep + ", nomDep=" + nomDep + ", numReg=" + numReg + ", chefLieu=" + codeInsee
				 + "]";
	}*/
	

}
