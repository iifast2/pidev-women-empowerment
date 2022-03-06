package com.women.spring.repository;

import com.women.spring.model.Jackpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JackpotRepository extends CrudRepository<Jackpot, Integer> {
}
