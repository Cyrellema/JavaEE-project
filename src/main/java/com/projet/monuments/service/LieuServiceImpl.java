package com.projet.monuments.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.monuments.models.Departement;
import com.projet.monuments.models.Lieu;
import com.projet.monuments.models.Monument;
import com.projet.monuments.repositories.LieuRepository;
import com.projet.monuments.repositories.MonumentRepository;

@Service
public class LieuServiceImpl implements LieuService{
	
@Autowired
LieuRepository lieuRepo;

@Autowired
MonumentRepository monuRepo;

	@Override
	public String createLieu(Lieu lieu) {
		lieuRepo.save(lieu);
		return "/lieux";
	}

	@Override
	public String updateLieu(Lieu lieu) {
		lieuRepo.save(lieu);	
		return "/lieux";

	}

	@Override
	public String deleteLieu(String codeInsee) {
		lieuRepo.deleteById(codeInsee);
		return "/lieux";

	}

	@Override
	public List<Lieu> getLieux() {
		return (List<Lieu>) lieuRepo.findAll();
	}

	@Override
	public List<Lieu> findByNomCom(String nomCom) {
		List<Lieu> res = new ArrayList<>();
		for(Lieu lieu : lieuRepo.findAll()) {
			if (lieu.getNomCom().equals(nomCom)) {
				res.add(lieu);
			}
		}
		return res;

	}

	@Override
	public List<Lieu> findByDep(String dep) {
		List<Lieu> res = new ArrayList<>();
		for (Lieu lieu : lieuRepo.findAll()) {
			if (lieu.getDep().getDep().equals(dep)) {
				res.add(lieu);
			}
		}
		return res;
	}



}
