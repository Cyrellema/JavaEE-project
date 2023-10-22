package com.projet.monuments.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.monuments.models.Departement;
import com.projet.monuments.repositories.DepartementRepository;
import com.projet.monuments.repositories.LieuRepository;

@Service
public class DepartementServiceImpl implements DepartementService{
	@Autowired
	DepartementRepository depRepo;
	
	@Autowired
	LieuRepository lieuRepo;

	@Override
	public String createDepartement(Departement departement) {
		depRepo.save(departement);
		return "/departements";
	}

	@Override
	public String updateDepartement(Departement departement) {
		depRepo.save(departement);
		return "/departements";

	}

	public String deleteDepartement(String dep) {
		depRepo.deleteById(dep);
		return "/departements";

	}

	@Override
	public List<Departement> getDepartements() {
		return (List<Departement>) depRepo.findAll();
	}

	@Override
	public List<Departement> findByNomDep(String nomDep) {
		List<Departement> res = new ArrayList<>();
		for(Departement departement : depRepo.findAll()) {
			if(departement.getNomDep().equals(nomDep)) {
				res.add(departement);
			}
		}
		return res;
	}

}
