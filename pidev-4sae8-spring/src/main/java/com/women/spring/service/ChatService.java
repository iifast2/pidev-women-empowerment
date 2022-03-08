package com.women.spring.service;

import com.women.spring.model.Chat;
import com.women.spring.model.Groups;
import com.women.spring.model.User;
import com.women.spring.repository.ChatRepository;
import com.women.spring.repository.GroupsRepository;
import com.women.spring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
public class ChatService implements IChatService{

    private static Long idSession =(long) 2;
    @Autowired
    ChatRepository chatRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    GroupsRepository groupRepo;
    @Autowired
    GroupsService groupService;


    public boolean testMessage(String message){
        String ch="";
        boolean test=false;
        File file = new File("dictionnaire.txt");
        try {
            Scanner scan = new Scanner(file);
            ch=scan.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] ListDictionnaire = ch.split(",");
        String[] TestmessageList=message.split(" ");
        int i=0;
        while( i < TestmessageList.length && test == false ){
            int j=0;
            while(j < ListDictionnaire.length && test == false )
            {
                test=TestmessageList[i].contains(ListDictionnaire[i]);
            }

        }
        return test;
    }
    @Override
    public Chat SendMessage(Chat chatMessage ,Long to) {
        Groups group=groupRepo.findById(to).get();

        long currentTimestamp = System.currentTimeMillis();
        Date dateMessage  = new Date((currentTimestamp));
        //currentTimestamp=currentTimestamp/1000;
        //Date expirationdate  = new Date((currentTimestamp+60)*1000);

        chatMessage.setDateMsg(dateMessage);
        chatMessage.setChatGroup(group);
        return chatRepo.save(chatMessage);
    }

    @Scheduled(fixedRate=5000)
    public void DeleteSecureMessage(){
        //List<Chat> messages= chatRepo.DeleteSecureMessage();
    }
    @Override
    public void DeleteMessage(Long idMessage) {
        chatRepo.deleteById(idMessage);

    }
    public List<Chat> getAllMessage(){
        Iterable<Chat> chat =  chatRepo.findAll();
        return (List<Chat>) chat;
    }

    @Override
    public List<Chat> getMessageByGroup(Long idGroup) {
        Groups group = groupRepo.findById(idGroup).orElse(null);
        User user = userRepo.findById(idSession).get();
        List<Chat> ListChat = chatRepo.getChatByGroup(group);
        Chat chat =ListChat.get(0);
        etatMessage(chat,user);


        return ListChat;
    }
    public void etatMessage(Chat chat , User user){
        if(chat.getEtat().size()==0){
            chat.getEtat().add(user);
            log.info(chat.getIdMessage().toString()+" "+chat.getMessageUser().getNom());
            chatRepo.save(chat);
        }
        for(User u : chat.getEtat()){
            if(u.equals(user)==false){
                chat.getEtat().add(user);
                log.info(chat.getIdMessage().toString()+" "+chat.getMessageUser().getNom());

            }
        }
        chatRepo.save(chat);

    }

    @Scheduled(fixedRate=5000)
    public void ChatScheduler(){
		/*List<Chat> chatEexpirationDate = chatRepo.chatEexpirationDate();
		for(Chat chat : chatEexpirationDate ){
			chatRepo.delete(chat);
			log.info("");
		}*/

    }




}
