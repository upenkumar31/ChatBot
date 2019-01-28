package com.sonus.ems.technothon.chatbot.RBBNChatBot;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SenderReciever{
    public static Queue<String> userMessage;
    public static Queue<String> response;
    SenderReciever()
    {
        userMessage = new LinkedList<>();
        response = new LinkedList<>();
    }
    public static void insertResponses(String msg)
    {
        response.add(msg);
    }
    public static String getResponse()
    {
        return response.poll();
    }
    public static void insertUserMessage(String msg)
    {
        userMessage.add(msg);
    }
    public static String getUserMessage()
    {
        return userMessage.poll();
    }
}
