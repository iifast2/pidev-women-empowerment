package com.pidevteam.repository;

import com.pidevteam.entity.Jackpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JackpotRepository extends CrudRepository<Jackpot, Integer> {
}
