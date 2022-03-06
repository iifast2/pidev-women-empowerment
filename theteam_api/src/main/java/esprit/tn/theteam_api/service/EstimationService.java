package esprit.tn.theteam_api.service;

import esprit.tn.theteam_api.model.Emoji;
import esprit.tn.theteam_api.model.Estimation;
import esprit.tn.theteam_api.model.Rating;
import esprit.tn.theteam_api.repository.EstimationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstimationService {
@Autowired
EstimationRepository estimationRepository;
@Autowired
CommentService commentService;
public Estimation save(Long id, Estimation estimation){
    estimation.setComment(commentService.findById(id));
     return  estimationRepository.save(estimation);
}
    public List<Estimation> findAllByCommentId(Long id){
    return  estimationRepository.findAllByCommentId(id);
    }

    public List<Estimation> findAllByCommentIdAndEmoji(Long id, Emoji e){
        return  estimationRepository.findAllByCommentIdAndEmoji(id, e);
    }
}
