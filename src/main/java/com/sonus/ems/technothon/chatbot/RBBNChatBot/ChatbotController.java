package com.sonus.ems.technothon.chatbot.RBBNChatBot;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.sonus.ems.technothon.chatbot.RBBNChatBot.ChatMessage.MessageType;

@Controller
public class ChatbotController {
	
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    
      
    UserMessageToResponse userMessageToResponse;
    DBConnector dbConnector = new DBConnector();
    UserHistory userHistory = new UserHistory();
	Queue<String> queryQ = new LinkedList<String>();
	
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
    	
    	queryQ.add(message.getContent());
    	System.out.println(queryQ.toString());
    	//////////TO DO processing
    	return message;
    	//return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
    	
        // Add username in web socket session
    	new Thread(new QConsumer(),"QConsumer").start();
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return new ChatMessage(MessageType.CHAT,"Hello "+chatMessage.getSender()+", How can i help you?","Ribbon");
        //return chatMessage;
    }
    
    class QConsumer implements Runnable{

		@Override
		public void run() {
			System.out.println("Am running........----------------.");
			// TODO Auto-generated method stub
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // simulated delay
				//System.out.println("checking........----------------.");
				if (!queryQ.isEmpty()) {

					System.out.println("yes.......----------------."+queryQ);
					String msg = queryQ.remove();
					
					  String resp = new UserMessageToResponse(msg).getReply();
					
					
					
		            ChatMessage chatMessage = new ChatMessage();
		            chatMessage.setType(ChatMessage.MessageType.CHAT);
		            chatMessage.setSender("Ribbon");
		            chatMessage.setContent(resp);
		        	System.out.println("answered.........");
		            messagingTemplate.convertAndSend("/topic/response", chatMessage);
				}
			}
			
			
		}
    	
    }
    

}
