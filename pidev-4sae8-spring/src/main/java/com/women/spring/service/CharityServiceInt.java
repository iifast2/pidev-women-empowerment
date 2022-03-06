package com.women.spring.service;

import com.women.spring.model.Charity;
import com.women.spring.model.Events;

import java.util.List;

public interface CharityServiceInt {
    public Integer saveCharity(Charity charity);
    public List<Charity> getAllCharity();

    public Charity getCharityById(Integer id);

    Charity UpdateCharity (Charity c , Integer idC);

    //public void updateCharity(Integer id) ;

    public void deleteCharity(Integer id);


}
