package com.projet.monuments.service;

import java.util.Collection;
import java.util.List;

import com.projet.monuments.models.Departement;
import com.projet.monuments.models.Lieu;
import com.projet.monuments.models.Monument;

public interface LieuService {

	public abstract String createLieu(Lieu lieu);
	   public abstract String updateLieu(Lieu lieu);
	   public abstract String deleteLieu(String codeInsee);
	   List<Lieu> getLieux();
	   List<Lieu> findByNomCom(String nomCom);
	   List<Lieu> findByDep(String dep);

}
