package com.sonus.ems.technothon.chatbot.RBBNChatBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.sonus.ems.technothon.chatbot.RBBNChatBot.ChatMessage.MessageType;

@Controller
public class BotController {
	
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    	@MessageMapping("/chat.greeting")
    	@SendTo("/topic/response")
	   public ChatMessage greeting(ChatMessage message) throws Exception {
    		System.out.println("receive.........");
	      Thread.sleep(2000); // simulated delay
	      return new ChatMessage(MessageType.CHAT,"some response..... ,"+message.getSender(),"Ribbon");
	   }
}

