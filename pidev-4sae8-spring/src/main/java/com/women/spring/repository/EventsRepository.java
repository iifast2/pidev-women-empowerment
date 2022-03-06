package com.women.spring.repository;

import com.women.spring.model.Events;
import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Events,Integer> {
}
