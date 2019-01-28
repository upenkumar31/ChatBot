package com.sonus.ems.technothon.chatbot.RBBNChatBot;

import java.util.Random;

public class ResponseSelection {
    String responseText = "I'm Still learning, I don't have answer of your Question";
    response responseObj = null;
    private String intentType = null;
    ResponseSelection(String intentType)
    {
        this.intentType = intentType;
        responseObj = new response();
    }
    public String getResponse(int responseCode) {
        String responseArray[] = responseObj.responseTextCase(responseCode);
        Random random = new Random();
        if(responseArray!=null)
        {
            if(responseArray.length==1)
                responseText = responseArray[0];
            else
            responseText = responseArray[random.nextInt(responseArray.length-1)+1];
        }
        if(responseText == "")
            responseText = "I'm Still learning, I don't have answer of your Question";
        return responseText;
    }
    public int getResponseCode(String intent)
    {
        int code = 5;
        if(intent.equalsIgnoreCase("greet"))
            code = 1;
        else if(intent.equalsIgnoreCase("Description"))
            code = 2;
        else if(intent.equalsIgnoreCase("Solution"))
            code = 3;
        else if(intent.equalsIgnoreCase("Troubleshoot"))
            code = 4;
        return code;
    }
    public String reply()
    {
        return getResponse(getResponseCode(intentType));
    }
}
