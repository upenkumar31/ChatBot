public class response {
    public String [] greetResponses()
    {
        String text[]={"How are you? How can i help you","what's up? How can i help you","Hello ? How can i help you?"};
        return text;
    }
    public String [] searchResponses()
    {
        String text[] = {"what are you Searching? Is it our Product","Do you want to know about our Product?"};
        return text;
    }
    public String [] bugReportResponses()
    {
        String text[] = {"For What product you have Bug?","Which Product you are using?","Can you tell me which product you are using?"};
        return text;
    }
    public String [] productDetailResponse()
    {
        String text[] = {"For which Product you want details?","Please Give me product Name","Okay, tell me the name of product"};
        return text;
    }
    public String[] responseTextCase(int responseCode)
    {
        String responseString[] = null;
        switch (responseCode)
        {
            case 1: responseString = greetResponses();break;
            case 2: responseString = searchResponses();break;
            case 3: responseString = bugReportResponses();break;
            case 4: responseString = productDetailResponse(); break;
            default: responseString = null;
        }
        return responseString;
    }
}
