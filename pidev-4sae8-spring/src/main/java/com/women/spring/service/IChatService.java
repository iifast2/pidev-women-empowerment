package com.women.spring.service;

import com.women.spring.model.Chat;

import java.util.List;

public interface IChatService {
    public Chat SendMessage(Chat chatMessage , Long to);
    public List<Chat> getMessageByGroup(Long idGroup);
    public List<Chat> getAllMessage();
    public void DeleteMessage(Long idMessage);
}
