package com.projet.monuments.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projet.monuments.models.Lieu;
import com.projet.monuments.models.Monument;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface MonumentRepository extends CrudRepository<Monument, String> {



	

}