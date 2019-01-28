package com.sonus.ems.technothon.chatbot.RBBNChatBot;

public class intent {
    public String typeOfIntent(int textType)
    {
        String typeOfIntentString="";
        switch (textType)
        {
            case 1: typeOfIntentString = "Greet";break;
            case 2: typeOfIntentString = "Description";break;
            case 3: typeOfIntentString = "Solution";break;
            case 4: typeOfIntentString = "Troubleshoot";break;
            default: typeOfIntentString = "notInTheList";break;
        }
        return  typeOfIntentString;
    }

}
