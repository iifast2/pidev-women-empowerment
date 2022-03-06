package com.women.spring.repository;

import com.women.spring.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


import java.util.List;

@RepositoryRestResource(collectionResourceRel = "formation", path = "formation")

public interface FormationRepository extends JpaRepository<Formation,Long> {
    List<Formation> findByNom(@Param("nom") String nom);
}
