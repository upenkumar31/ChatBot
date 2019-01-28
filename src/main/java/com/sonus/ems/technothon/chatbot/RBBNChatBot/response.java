package com.sonus.ems.technothon.chatbot.RBBNChatBot;

public class response {
    public String [] greetResponses()
    {
        String text[]={"How are you? How can i help you","what's up? How can i help you?","Hello ? How can i help you?"};
        return text;
    }
    public String [] descriptionResponses()
    {
        String text[] = null;
        String userMessage = IntentSelection.UserMessage;
        String entity = "hi";
        String descrArray[] = IntentSelection.Description();
        for(String k:descrArray)
        {
            if(userMessage.toLowerCase().contains(k.toLowerCase()))
            {

                entity =userMessage.replace(k.toLowerCase(),"").toLowerCase();
                entity = entity.trim();
            }
        }
        String res = DBConnector.searchGeneralResponse(entity);
        if(res!=null)
        {
            text = new String[1];
            text[0] = res;
        }
        return text;
    }
    public String [] troubleshootResponses()
    {
        String text[] = {"For What product you have Bug?","Which Product you are using?","Can you tell me which product you are using?"};
        return text;
    }
    public String [] solutionResponse()
    {
        String text[] = null;
        String userMessage = IntentSelection.UserMessage;
        String entity = "hi";
        String descrArray[] = IntentSelection.Solution();
        for(String k:descrArray)
        {
            if(userMessage.toLowerCase().contains(k.toLowerCase()))
            {

                entity =userMessage.replace(k.toLowerCase(),"").toLowerCase();
                entity = entity.trim();
            }
        }
        String res = DBConnector.searchGeneralResponse(entity);
        if(res!=null)
        {
            text = new String[1];
            text[0] = res;
        }
        return text;
    }
    public String[] responseTextCase(int responseCode)
    {
        String responseString[] = null;
        switch (responseCode)
        {
            case 1: responseString = greetResponses();break;
            case 2: responseString = descriptionResponses();break;
            case 3: responseString = solutionResponse();break;
            case 4: responseString = troubleshootResponses(); break;
            default: responseString = null;
        }
        return responseString;
    }
}
