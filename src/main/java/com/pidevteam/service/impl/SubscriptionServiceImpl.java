package com.pidevteam.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pidevteam.service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import com.pidevteam.entity.Subscription;
import com.pidevteam.repository.SubscriptionRepository;


@Slf4j
@Service
public class SubscriptionServiceImpl implements ISubscriptionService {


    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> retrieveAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        subscriptionRepository.findAll().forEach(s -> subscriptions.add(s));
        for (Subscription s : subscriptions) {
            log.info("subscription " + s);

        }
        return subscriptions;
    }

    @Override
    public Subscription addSubscription(Subscription s) {
        log.info("subscription " + s);
        return subscriptionRepository.save(s);
    }

////////// CHECK THIS ID !!!

    @Override
    public void deleteSubscription(Integer id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public Subscription updateSubscription(Subscription s) {
        log.info("subscription " + s);
        return subscriptionRepository.save(s);
    }

    @Override
    public Subscription retrieveSubscription(Integer id) {
        return subscriptionRepository.findById(id).get();
    }

    @Override
    public List<Subscription> retrieveAllUsersBySubscriptionDate(Date D1, Date D2) {
        // TODO Auto-generated method stub
        return null;
    }





		/*
		@Override
		public List<Client> retrieveAllClientsByDateNaissance(Date dateDebut, Date dateFin) {
			return clientRepository.retrieveClientsByDateNaissance(dateDebut, dateFin);
		}
	*/



}