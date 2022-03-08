package com.women.spring.service;

import com.women.spring.model.ChatReact;
import com.women.spring.model.React;

public interface IChatReactService {
    public ChatReact ReactToMessage(ChatReact chatr);

    public void updateReact(Long idReact , React typeReact);
    public void deleteReact(Long idReact);
}
