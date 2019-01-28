package com.sonus.ems.technothon.chatbot.RBBNChatBot;

public class UserHistory {

    public static int nodenumber;
    public static String intent;
    public static String lastMessage;
    public UserHistory()
    {
        nodenumber =1;
        intent = "";
        lastMessage = "";
    }

    public static int getNodenumber() {
        return nodenumber;
    }

    public static void setNodenumber(int nodenumber) {
        UserHistory.nodenumber = nodenumber;
    }

    public static void setIntent(String intent) {
        UserHistory.intent = intent;
    }

    public static String getIntent() {
        return intent;
    }
    
    public static void setLastMessage(String intent) {
        UserHistory.lastMessage = intent;
    }
    
    public static String getLastMessage()
    {
    	return UserHistory.lastMessage;
    }
    
}
