package com.projet.monuments.repositories;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projet.monuments.models.Celebrite;

@Repository
public interface CelebriteRepository extends CrudRepository<Celebrite, String> {




	}