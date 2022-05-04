package com.pidevteam.service;

import com.pidevteam.entity.Comment;
import com.pidevteam.repository.CommentRepository;
import com.pidevteam.repository.EstimationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService  implements  ICrudService<Comment>{

    @Autowired
    CommentRepository commentRepository ;
    public Comment save (Comment comment){
        return commentRepository.save(comment) ;
    }

    @Override
    public Comment Update(Comment comment) {
       return  commentRepository.save(comment) ;
    }

    @Override
    public List<Comment> findAll() {
        return   commentRepository.findAll() ;
    }

    @Override
    public Comment findById(Long id) {
        return  commentRepository.findById(id).get() ;
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
    public List<Comment> findAllByPublicationId(Long id){
        return commentRepository.findByPublicationId(id);
    }
    @Autowired
    EstimationRepository estimationRepository ;
    public Comment Max(Comment comment,Long idP, List<Comment> lst){

Comment max = comment ;
if(lst != null){
        for (Comment c: lst ) {
        if(estimationRepository.countAllByCommentId(c.getId())>estimationRepository.countAllByCommentId(comment.getId()) && c.getSous_comments().size()> comment.getSous_comments().size() ){
            max = c ;
        }else  if(estimationRepository.countAllByCommentId(c.getId())>estimationRepository.countAllByCommentId(comment.getId()) || c.getSous_comments().size()> comment.getSous_comments().size()){
            max = c ; }

        }}
        return max ;
    }

   public List<Comment> findAllByEstimationsGreaterThanAndSous_commentsGreaterThan(Long pubId){
       List<Comment> lst = new ArrayList<>();
       List<Comment> list =  findAllByPublicationId(pubId) ;
       while (!list.isEmpty()){
           lst.add(Max(list.get(0),pubId,list)) ;
           list.remove(Max(list.get(0),pubId,list));
       }
        return lst ;
   }

}
