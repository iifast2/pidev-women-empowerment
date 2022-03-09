package com.pidevteam.service;


import com.pidevteam.entity.Events;

import java.util.List;

public interface EventsServiceInt {
    public Integer saveEvents(Events events);
    public List<Events> getAllEvents();


    public Events getEventsById(Integer id);
    public void deleteEvent(Integer id);
    Events UpdateEvent (Events E , Integer idE);
    public List<Events> findByNom(String nom);
}
