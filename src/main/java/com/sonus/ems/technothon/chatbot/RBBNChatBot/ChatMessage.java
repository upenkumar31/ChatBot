package com.sonus.ems.technothon.chatbot.RBBNChatBot;

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }   
    
    public ChatMessage() {
    	
    }
    
    public ChatMessage(MessageType type, String content, String sender) {
		super();
		this.type = type;
		this.content = content;
		this.sender = sender;
	}

	public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
