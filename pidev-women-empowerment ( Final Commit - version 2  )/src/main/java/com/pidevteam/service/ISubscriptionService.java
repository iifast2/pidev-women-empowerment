package com.pidevteam.service;


import java.util.Date;
import java.util.List;

import com.pidevteam.entity.Subscription;

public interface ISubscriptionService {





    List<Subscription> retrieveAllSubscriptions();

    Subscription addSubscription(Subscription s);

    void deleteSubscription(Integer id);

    Subscription updateSubscription(Subscription s);

    Subscription retrieveSubscription(Integer id);

    // not sure
    List<Subscription> retrieveAllUsersBySubscriptionDate(Date D1, Date D2);
}