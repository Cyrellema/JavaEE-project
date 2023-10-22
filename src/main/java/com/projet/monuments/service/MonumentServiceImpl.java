package com.projet.monuments.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.monuments.models.Lieu;
import com.projet.monuments.models.Monument;
import com.projet.monuments.repositories.LieuRepository;
import com.projet.monuments.repositories.MonumentRepository;

@Service
public class MonumentServiceImpl implements MonumentService{
@Autowired
MonumentRepository monumentRepo;

@Autowired 
LieuRepository lieuRepo;

	@Override
	public String createMonument(Monument monument) {
		monumentRepo.save(monument);
		return"/monuments";
	}

	@Override
	public String updateMonument(Monument monument) {
		monumentRepo.save(monument);
		return"/monuments";

	}

	@Override
	public String deleteMonument(String geohash) {
		monumentRepo.deleteById(geohash);
		return "/monuments";
	}

	@Override
	public Collection<Monument> getMonuments() {
		return (Collection<Monument>) monumentRepo.findAll();
	}

	@Override
	public String findByGeohash(String geohash) {
		monumentRepo.findById(geohash);
		return"/monuments";
	}

	@Override
	public List<Monument> findAll() {
		return (List<Monument>) monumentRepo.findAll();
	}

	@Override
	public List<Monument> findByTypeM(String typeM) {
		List<Monument> result = new ArrayList<Monument>();
		for(Monument monument : monumentRepo.findAll()) {
			if (monument.getTypeM().equals(typeM))
				result.add(monument);
		}
		return result;
	}



	@Override
	public List<Monument> findByCodeInsee(Lieu codeInsee) {
		List<Monument> result = new ArrayList<Monument>();
		for(Monument monument : monumentRepo.findAll()) {
			if (monument.getCodeInsee().equals(codeInsee))
				result.add(monument);
		}
		return result;
	}

	@Override
	public List<String> getMonumentProx(Monument mon1) {
			List<String>prox = new ArrayList<String>();
			double longitude1 = mon1.getLongitude();
			double latitude1 = mon1.getLatitude();
			for(Monument monument : monumentRepo.findAll()) {
				double longitude2 = monument.getLongitude();
				double latitude2 = monument.getLatitude();
				/*double theta = (longitude2 - longitude1);
					double distance = 60 * 1.852 * (180/Math.PI) * Math.acos(
			        Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) + 
			        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180)));
			   distance = Math.round(Math.sqrt(distance * 1.609344));*/
				
			   double Rad = 6372.8; 
	            double dLat = Math.toRadians(latitude2 - latitude1);
	            double dLon = Math.toRadians(longitude2 - longitude1);
	            latitude1 = Math.toRadians(latitude1);
	            latitude2 = Math.toRadians(latitude2);
	            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(latitude1) * Math.cos(latitude2);
	            double c = 2 * Math.asin(Math.sqrt(a));
	            double distance = Rad * c;

			    prox.add(mon1.getNom()+" est à "+distance + "m de " + monument.getNom());
			}
			return prox;
		}

	@Override
	public List<String> getDistance(String nom1, String nom2) {
		List<String> res = new ArrayList<>();
		Map<String, Monument> temp = new HashMap<>();
		for (Monument monument : monumentRepo.findAll()) {
			  if(monument.getNom().equals(nom1)) {
				  temp.put("mon1", monument);
			  }
				  if(monument.getNom().equals(nom2)) {
				  temp.put("mon2", monument);
				  }
		}
		Monument mon1 = temp.get("mon1");
		Monument mon2 = temp.get("mon2");
						double longitude1 = mon1.getLongitude();
						double latitude1 = mon1.getLatitude();
							double longitude2 = mon2.getLongitude();
							double latitude2 =  mon2.getLatitude();
					   double Rad = 6372.8; 
			            double dLat = Math.toRadians(latitude2 - latitude1);
			            double dLon = Math.toRadians(longitude2 - longitude1);
			            latitude1 = Math.toRadians(latitude1);
			            latitude2 = Math.toRadians(latitude2);
			            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(latitude1) * Math.cos(latitude2);
			            double c = 2 * Math.asin(Math.sqrt(a));
			            double distance = Rad * c;
					    res.add( mon1.getNom()+" est à "+distance + "m de " +  mon2.getNom());
			
		    return res;
	}



	

}
