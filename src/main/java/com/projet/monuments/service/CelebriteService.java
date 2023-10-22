package com.projet.monuments.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projet.monuments.models.Celebrite;
import com.projet.monuments.models.Monument;

@Service
public interface CelebriteService {
	   public abstract String createCelebrite(Celebrite celebrite);
	   public abstract String updateCelebrite(Celebrite celebrite);
	   public abstract String deleteCelebrite(String nom);
	   public abstract Collection<Celebrite> getCelebrites();
	   public abstract List<Monument> getByEpoque(String epoque);
	   List<Celebrite> findAll();
	   List<Celebrite> findByNationalite(String nationalite);
	   public abstract List<Monument> getByCelebrite(String nom);




}
