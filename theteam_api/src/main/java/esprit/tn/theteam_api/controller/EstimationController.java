package esprit.tn.theteam_api.controller;

import esprit.tn.theteam_api.model.Emoji;
import esprit.tn.theteam_api.model.Estimation;
import esprit.tn.theteam_api.model.Rating;
import esprit.tn.theteam_api.service.EstimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/estimation")
public class EstimationController {
    @Autowired
    EstimationService estimationService;
    @PostMapping("/{id}")
    public Estimation save(@RequestBody Estimation estimation , @PathVariable("id") Long id){
        return  estimationService.save(id,estimation) ;
    }
    @GetMapping("/{id}")
    public List<Estimation> findAllByCommentId(@PathVariable("id") Long id){
        return  estimationService.findAllByCommentId(id);
    }
    @GetMapping("/emoji/{id}")
    public List<Estimation> findAllByCommentIdAnd(@PathVariable("id") Long id, @RequestBody Emoji emoji){
        return  estimationService.findAllByCommentIdAndEmoji(id,emoji);
    }

}
