package esprit.tn.theteam_api.controller;

import esprit.tn.theteam_api.model.Comment;
import esprit.tn.theteam_api.service.CommentService;
import esprit.tn.theteam_api.service.ICrudService;
import esprit.tn.theteam_api.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController  {
    @Autowired
    CommentService commentService ;
    @Autowired
    PublicationService publicationService ;
    @PostMapping("/{id}")
            public Comment save (@PathVariable("id")Long id , @RequestBody Comment commment ){
        commment.setPublication(publicationService.findById(id));
        return commentService.save(commment);
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
@GetMapping("/{idP}")
    public List<Comment> findAllByPublicationId(@PathVariable("idP") Long id){
        return commentService.findAllByPublicationId(id);
    }
    @GetMapping("/pluspersitance/{idP}")
    public List<Comment> findAllByEstimationsGreaterThanAndSous_commentsGreaterThan(@PathVariable("idP") Long id){
        return commentService.findAllByEstimationsGreaterThanAndSous_commentsGreaterThan(id) ;
    }

}
