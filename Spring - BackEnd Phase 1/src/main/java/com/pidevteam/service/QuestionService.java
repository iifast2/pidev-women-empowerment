package com.pidevteam.service;

import com.pidevteam.entity.Question;
import com.pidevteam.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements ICrudRepository<Question> {
@Autowired
QuestionRepository questionRepository;
    @Override
    public Question save(Question question) {
        return questionRepository.save(question) ;}

    @Override
    public Question update(Question question) {
        return questionRepository.save(question) ;
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).get() ;
    }

    @Override
    public void delete(Long id) {
         questionRepository.deleteById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
