package com.pidevteam.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pidevteam.entity.Subscription;
import com.pidevteam.entity.User;

@Repository

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    // @Query("SELECT u FROM User u WHERE u.dateDebut BETWEEN ?1 AND ?2")
    //List<User> retrieveClientsBySubscriptionDate(Date dateDebut, Date dateFin);
}


