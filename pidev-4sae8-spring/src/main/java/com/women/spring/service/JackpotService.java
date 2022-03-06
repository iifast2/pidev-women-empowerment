package com.women.spring.service;

import com.women.spring.model.Jackpot;
import com.women.spring.repository.JackpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class JackpotService implements JackpotServiceInt{
    @Autowired
    JackpotRepository repository;
    @Override
    public Integer saveJackpot(Jackpot jackpot) {
        return repository.save(jackpot).getIdJ();
    }

    @Override
    public List<Jackpot> getAllJackpots() {
        return (List<Jackpot>) repository.findAll();
    }

    @Override
    public Jackpot getJackpotById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteJackpot(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public Jackpot UpdateJacpot (Jackpot j , Integer idJ){
        // TODO Auto-generated method stub
        j.setIdJ(idJ);
        return repository.save(j);
    }
}
