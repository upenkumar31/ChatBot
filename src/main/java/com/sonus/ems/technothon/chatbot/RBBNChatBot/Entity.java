package com.sonus.ems.technothon.chatbot.RBBNChatBot;

public class Entity {
    public static String userMessage;
    public static EntityUtility entityUtility;
    Entity(String userMessage)
    {
        this.userMessage = userMessage;
        entityUtility =  new EntityUtility();
    }
    public static String findEntity()
    {

        EntityUtility.TrieNode res = entityUtility.search("ems");
        if(res!= null)
            System.out.println("Entity --- " +res.entity );
        return "";
    }
}
