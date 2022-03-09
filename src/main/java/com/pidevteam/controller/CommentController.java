package com.pidevteam.controller;

import com.pidevteam.entity.Comment;
import com.pidevteam.service.CommentService;
import com.pidevteam.service.NotificationService;
import com.pidevteam.service.PublicationService;
import com.pidevteam.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController  {
    @Autowired
    CommentService commentService ;
    @Autowired
    PublicationService publicationService ;
    @Autowired
    UserServiceImpl userService ;
    @Autowired
    NotificationService notificationService ;
    @PostMapping("/{id}")
            public Comment save (@PathVariable("id")Long id , @RequestBody Comment commment ){

        commment.setPublication(publicationService.findById(id));
        Comment comment = commentService.save(commment);
        notificationService.notIdUserIdentification(comment.getIdUserIden(),"http://localhost:8080/publication/"+comment.getId(),"you are identifie in comment " , "add comment ");

        return comment ;
    }

    @PutMapping()
    public Comment Update(@RequestBody Comment comment) {
        return commentService.Update(comment);
    }

    @GetMapping()
    public List<Comment> findAll() {
        return commentService.findAll() ;
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable("id") Long id) {
       return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
    commentService.deleteById(id);
    }
@PutMapping("/sous_comment/{id}")
    public Comment  addSousComemnts(@PathVariable("id") Long id ,@RequestParam ("sous_comment") String s){
    Comment comment = findById(id) ;
    System.out.println(s);
        if(comment.getSous_comments() == null)
    {
        ArrayList<String> comments  = new ArrayList<String>();
        comments.add(s);
       comment.setSous_comments(comments);
    }
    else {
            comment.getSous_comments().add(s);
    }


        return  Update(comment);
}
@GetMapping("/pub/{idP}")
    public List<Comment> findAllByPublicationId(@PathVariable("idP") Long id){
        return commentService.findAllByPublicationId(id);
    }
    @GetMapping("/pluspersitance/{idP}")
    public List<Comment> findAllByEstimationsGreaterThanAndSous_commentsGreaterThan(@PathVariable("idP") Long id){
        return commentService.findAllByEstimationsGreaterThanAndSous_commentsGreaterThan(id) ;
    }

}
