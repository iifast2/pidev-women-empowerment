package com.pidevteam.service;

import com.pidevteam.entity.Charity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CharityServiceInt {
    public Integer saveCharity(Charity charity);
    public List<Charity> getAllCharity();

    public Charity getCharityById(Integer id);

    Charity UpdateCharity (Charity c , Integer idC);

    //public void updateCharity(Integer id) ;

    public void deleteCharity(Integer id);
    public ResponseEntity<String> statistiqueGoals();


}
