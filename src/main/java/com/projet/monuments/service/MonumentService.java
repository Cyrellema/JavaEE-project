package com.projet.monuments.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projet.monuments.models.Lieu;
import com.projet.monuments.models.Monument;


@Service
public interface MonumentService {
   public abstract String createMonument(Monument monument);
   public abstract String updateMonument(Monument monument);
   public abstract String deleteMonument(String geohash);
   public abstract Collection<Monument> getMonuments();
   public abstract String findByGeohash(String geohash);
   List<Monument> findByTypeM(String typeM);
   List<Monument> findByCodeInsee(Lieu codeInsee);
   List<Monument> findAll();
   List<String> getMonumentProx(Monument mon1);
   List<String> getDistance(String nom1, String nom2);

}