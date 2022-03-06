package com.women.spring.service;

import com.women.spring.model.Charity;
import com.women.spring.repository.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CharityService implements CharityServiceInt{
    @Autowired
    private CharityRepository repository;
    @Override
    public Integer saveCharity(Charity charity) {
        return repository.save(charity).getIdC();
    }

    @Override
    public List<Charity> getAllCharity() {
        return (List<Charity>) repository.findAll();
    }

    @Override
    public Charity getCharityById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteCharity(Integer id) {
        repository.deleteById(id);

    }
   // @Override
    //public void updateCharity(Integer id) {
       // repository.findById(id).get();

    //}

    @Override
    public Charity UpdateCharity (Charity c ,  Integer idC){
        // TODO Auto-generated method stub
        c.setIdC(idC);
        return repository.save(c);
    }
}
