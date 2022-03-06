package com.women.spring.service;



import com.women.spring.model.Jackpot;

import java.util.List;

public interface JackpotServiceInt {
    public Integer saveJackpot(Jackpot jackpot);
    public List<Jackpot> getAllJackpots();

    public Jackpot getJackpotById(Integer id);
    public void deleteJackpot(Integer id);
    public Jackpot UpdateJacpot (Jackpot j , Integer idJ);
}
