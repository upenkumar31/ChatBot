public class IntentSelection {
    String UserMessage="";
    intent intentObj = null;
    IntentSelection(String meassage)
    {
        this.UserMessage=meassage.toLowerCase();
        this.intentObj = new intent();
    }
    public String typeOfIntentSelection()
    {
        String intentType="";
        if(UserMessage.contains("hi")||UserMessage.contains("hello"))
            intentType = intentObj.typeOfIntent(1);
        else if(UserMessage.contains("find")||UserMessage.contains("search"))
            intentType = intentObj.typeOfIntent(2);
        else if(UserMessage.contains("problem")||UserMessage.contains("not working")||UserMessage.contains("bug")||UserMessage.contains("issue"))
            intentType = intentObj.typeOfIntent(3);
        else if(UserMessage.contains("product"))
            intentType = intentObj.typeOfIntent(4);

        else intentType = intentObj.typeOfIntent(5);

        return intentType;
    }
}
