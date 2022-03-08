package com.women.spring.controller;

import com.women.spring.model.Chat;
import com.women.spring.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatControllerr{
    @Autowired
    ChatService chatService;

	/*
	@MessageMapping("/chat.send/{groups}")
	public Chat senderMessage(Chat chatMessage,@DestinationVariable Long group){
		log.info(chatMessage.toString());
		return chatService.SendMessage(chatMessage, group);
	}

	@MessageMapping("/chat.newUser")
	@SendTo("/topic/public")
	public Chat newUser(@Payload final Chat chatMessage,SimpMessageHeaderAccessor headerAccessor){
		log.info(chatMessage.toString());
		headerAccessor.getSessionAttributes().put("username",chatMessage.getMessageUser());
		return chatMessage;
	}*/


    @PostMapping("/{to}")
    public void SendMessage(@RequestBody Chat chatMessage, @PathVariable("to") Long to) {
        chatService.SendMessage(chatMessage, to);

    }

    @GetMapping("/getAllMessage")
    @ResponseBody
    public List<Chat> getAllMessage() {
        return chatService.getAllMessage();
    }

    @GetMapping("/getMessageByGroup/{idGroup}")
    @ResponseBody
    public List<Chat> getMessageByGroup(@PathVariable("idGroup") Long idGroup){
        return chatService.getMessageByGroup(idGroup);
    }

    @DeleteMapping("message/{idMessage}")
    public void DeleteMessage(@PathVariable("idMessage")Long idMessage) {
        chatService.DeleteMessage(idMessage);

    }

}
