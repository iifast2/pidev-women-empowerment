package com.women.spring.controller;

import com.women.spring.model.ChatReact;
import com.women.spring.model.React;
import com.women.spring.service.ChatReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatReactController{
    @Autowired
    ChatReactService crs;

    @PostMapping("/react")
    public ChatReact ReactToMessage(@RequestBody ChatReact typeReact) {
        return crs.ReactToMessage(typeReact);

    }

    @DeleteMapping("/react/{idReact}")
    public void deleteReact(@PathVariable("idReact") Long idReact) {
        crs.deleteReact(idReact);

    }

    @PutMapping("/react/{idReact}/{typeReact}")
    public void updateReact(@PathVariable("idReact")Long idReact,@PathVariable("typeReact") React typeReact) {
        crs.updateReact(idReact,typeReact);
    }

}
