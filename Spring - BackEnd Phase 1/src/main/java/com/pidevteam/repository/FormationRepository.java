package com.pidevteam.repository;

import com.pidevteam.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "formation", path = "formation")

public interface FormationRepository extends JpaRepository<Formation,Long> {
    List<Formation> findByNom(@Param("nom") String nom);
}
