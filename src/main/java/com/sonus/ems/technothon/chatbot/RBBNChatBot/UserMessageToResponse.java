package com.sonus.ems.technothon.chatbot.RBBNChatBot;

public class UserMessageToResponse {
    IntentSelection intentSelection = null;
    ResponseSelection responseSelection = null;
    private String reply = null;
    UserMessageToResponse(String msg)
    {
        intentSelection = new IntentSelection(msg.toLowerCase());
        responseSelection = new ResponseSelection(intentSelection.typeOfIntentSelection());
    }

    public String getReply() {
        return responseSelection.reply();
    }
}
