package com.pidevteam.controller;

import com.pidevteam.entity.Quiz;
import com.pidevteam.service.ICrudRepository;
import com.pidevteam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController implements ICrudRepository<Quiz> {
    @Autowired
    QuizService quizService;

    @PostMapping()
    public Quiz save(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @PutMapping("/update/{id}")
    public Quiz update(@RequestBody Quiz quiz) {
        return quizService.update(quiz);
    }

   @GetMapping("/find/{id}")
    public Quiz findById(@PathVariable("id") Long id) {
        return quizService.findById(id);
    }

  @DeleteMapping("/deleteq/{id}")
    public void delete(@PathVariable("id") Long id) {
      quizService.delete(id);
    }

   @GetMapping("/All")
    public List<Quiz> findAll() {
        return quizService.findAll();
    }
}
