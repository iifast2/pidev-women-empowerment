package com.women.spring.service;


import com.women.spring.model.Charity;
import com.women.spring.model.Events;

import java.util.List;

public interface EventsServiceInt {
    public Integer saveEvents(Events events);
    public List<Events> getAllEvents();

    public Events getEventsById(Integer id);
    public void deleteEvent(Integer id);
    Events UpdateEvent (Events E , Integer idE);
}
