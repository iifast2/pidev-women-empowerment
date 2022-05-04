package com.pidevteam.controller;


import java.util.List;

import com.pidevteam.entity.Subscription;
import com.pidevteam.service.impl.SubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;



@RestController
//@Api(tags = "Gestion des Subscription ")

public class SubscriptionController {

    @Autowired
    SubscriptionServiceImpl subscriptionService;

    //  @ApiOperation(value = "Récupérer la liste des subscriptions")
    @GetMapping("/sub/allsubscriptions")
    private List<Subscription> getAllSubscriptions() {
        return subscriptionService.retrieveAllSubscriptions();
    }
    //@ApiOperation(value = "Récupérer subscription par son ID")
    @GetMapping("/sub/subscriptions/{id}")
    private Subscription getSubscription(@PathVariable("id") Integer id) {
        return subscriptionService.retrieveSubscription(id);
    }

    //@ApiOperation(value = "Ajouter une subscription")
    @PostMapping("/sub/addsubscriptions")
    private Subscription saveSubscription(@RequestBody Subscription subscription) {
        Subscription savedSubscription = subscriptionService.addSubscription(subscription);
        return savedSubscription;
    }


    //@ApiOperation(value = "Modifier une subscription")
    @PutMapping("/sub/modifysubscriptions")
    private Subscription updateSubscription(@RequestBody Subscription subscription) {
        Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);
        return updatedSubscription;
    }


    //@ApiOperation(value = "Supprimer une subscription")
    @DeleteMapping("/sub/deletesubscriptions/{id}")
    private void deleteSubscription(@PathVariable("id") Integer id) {
        subscriptionService.deleteSubscription(id);
    }
}
