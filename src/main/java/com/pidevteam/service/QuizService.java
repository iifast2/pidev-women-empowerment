package com.pidevteam.service;

import com.pidevteam.entity.Quiz;
import com.pidevteam.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService implements ICrudRepository<Quiz> {
@Autowired
QuizRepository quizRepository;

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz) ;}

    @Override
    public Quiz update(Quiz quiz) {
        return quizRepository.save(quiz) ;
    }

    @Override
    public Quiz findById(Long id) {
        return quizRepository.findById(id).get() ;
    }

    @Override
    public void delete(Long id) {
         quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

   /* public int calculerScore(Long id,Quiz quiz,){ int note;
       int noteUser=quiz.note ;
        Reponse userChoice ;
<Response> response=new response ;
        for(int i = 0; i < response.length; i++)

            if UserChoice equal(reponse.status=true)
        noteUser++;}*/
}
