package com.pidevteam.repository;

import com.pidevteam.entity.Charity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CharityRepository extends CrudRepository<Charity, Integer> {
}
