package com.women.spring.repository;

import com.women.spring.model.Charity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CharityRepository extends CrudRepository<Charity, Integer> {
}
