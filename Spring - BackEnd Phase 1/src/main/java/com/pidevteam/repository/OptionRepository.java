package com.pidevteam.repository;


import com.pidevteam.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long > {

    List<Option> findAllBySurveyId(Long idS);
}
