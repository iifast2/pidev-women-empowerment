package com.women.spring.service;

import com.women.spring.model.ChatReact;
import com.women.spring.model.React;
import com.women.spring.repository.ChatReactRepository;
import com.women.spring.repository.ChatRepository;
import com.women.spring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class ChatReactService implements IChatReactService{

    @Autowired
    ChatReactRepository crr;
    @Autowired
    ChatRepository cr;
    @Autowired
    UserRepository ur;
    @Override
    public ChatReact ReactToMessage(ChatReact chatr) {
    
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateReact = new Date();
        chatr.setDateOfReact(dateReact);
       return crr.save(chatr);

    }

    @Override
    public void updateReact(Long idReact , React typeReact) {

        ChatReact chatr= crr.findById(idReact).orElse(null);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateReact = new Date();


        chatr.setReact(typeReact);
        chatr.setDateOfReact(dateReact);

        crr.save(chatr);

    }

    @Override
    public void deleteReact(Long idReact) {
        crr.deleteById(idReact);

    }




}
