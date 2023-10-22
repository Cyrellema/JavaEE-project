package com.projet.monuments.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projet.monuments.models.Departement;
import com.projet.monuments.models.Lieu;

@Service
public interface DepartementService {
	  public abstract String createDepartement(Departement departement);
	   public abstract String updateDepartement(Departement departement);
	   public abstract String deleteDepartement(String dep);
	   List<Departement> getDepartements();
	   List<Departement> findByNomDep(String nomDep);

}


