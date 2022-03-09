package com.pidevteam.repository;

import com.pidevteam.entity.Events;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventsRepository extends CrudRepository<Events,Integer> {

    @Query("SELECT u FROM Events u WHERE u.nom LIKE %:nom% ")
    List<Events> findByNom(@Param("nom") String nom);
}
