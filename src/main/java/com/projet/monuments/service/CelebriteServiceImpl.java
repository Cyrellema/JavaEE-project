package com.projet.monuments.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.monuments.models.Celebrite;
import com.projet.monuments.models.Monument;
import com.projet.monuments.repositories.CelebriteRepository;

@Service
public class CelebriteServiceImpl implements CelebriteService{
	@Autowired
	CelebriteRepository celebRepo;

	@Override
	public String createCelebrite(Celebrite celebrite) {
		celebRepo.save(celebrite);
		return"/celebrites";

	}

	@Override
	public String updateCelebrite(Celebrite celebrite) {
		celebRepo.save(celebrite);	
		return"/celebrites";

	}

	@Override
	public String deleteCelebrite(String nom) {
		celebRepo.deleteById(nom);
		return"/celebrites";
	}

	@Override
	public List<Celebrite> getCelebrites() {
		return (List<Celebrite>) celebRepo.findAll();
	}

	@Override
	public List<Monument> getByEpoque(String epoque) {
		List<Monument> result = new ArrayList<Monument>();
		for(Celebrite celebrite : celebRepo.findAll()) {
			if (celebrite.getEpoque().equals(epoque))
				result.addAll(celebrite.getMonuments());
		}
		return result;
	}

	@Override
	public List<Celebrite> findAll() {
		return (List<Celebrite>) celebRepo.findAll();
	}

	@Override
	public List<Celebrite> findByNationalite(String nationalite) {
		List<Celebrite> res = new ArrayList<Celebrite>();
		for(Celebrite celebrite : celebRepo.findAll()) {
			if(celebrite.getNationalite().equals(nationalite)) {
				res.add(celebrite);
			}
		}
		return res;
	}

	@Override
	public List<Monument> getByCelebrite(String nom) {
		for (Celebrite celebrite : celebRepo.findAll()) {
			if (celebrite.getNom().equals(nom)) {
				return celebrite.getMonuments();
			}
		}
		return null;
	}
	
	

}
