package com.women.spring.service;

import com.women.spring.model.Formation;
import com.women.spring.model.Response;
import com.women.spring.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService implements ICrudRepository<Response> {
@Autowired
ResponseRepository responseRepository;
    @Override
    public Response save(Response response) {
        return responseRepository.save(response) ;}

    @Override
    public Response update(Response response) {
        return responseRepository.save(response) ;
    }

    @Override
    public Response findById(Long id) {
        return responseRepository.findById(id).get() ;
    }

    @Override
    public void delete(Long id) {
         responseRepository.deleteById(id);
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }
}
