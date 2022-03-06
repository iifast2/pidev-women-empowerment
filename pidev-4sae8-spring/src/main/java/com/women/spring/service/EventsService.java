package com.women.spring.service;

import com.women.spring.model.Events;
import com.women.spring.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService implements EventsServiceInt {

    @Autowired
    private EventsRepository repository;

    @Override
    public Integer saveEvents(Events events) {
        return repository.save(events).getIdE();
    }

    @Override
    public List<Events> getAllEvents() {
        return (List<Events>) repository.findAll();
    }

    @Override
    public Events getEventsById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteEvent(Integer id) {
        repository.deleteById(id);


    }
    public Events UpdateEvent (Events E , Integer idE){
        E.setIdE(idE);
        return repository.save(E);
    }
}
