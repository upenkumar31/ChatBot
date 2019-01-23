public class IntentSelection {
    String UserMessage="";
    intent intentObj = null;
    IntentSelection(String meassage)
    {
        this.UserMessage=meassage.toLowerCase();
        this.intentObj = new intent();
    }
    public static String [] Description()
    {
        String text[] = {
                "What is *",
                "What does * mean",
                "Tell me something about *",
                "Explain *",
                "Elaborate *",
                "Can you tell me about *",
                "What do you know about *",
                "What can you tell me about *",
                "I want to know about *",
                "Do you have information about *"
           };
        return text;
    }
    public static String[] Troubleshoot()
    {
        String text[] = {
                "* is not Working",
                "i have problem with *",
                "there is an issue with *",
                "how to do *",
                "i want to report a problem"
        };
        return text;
    }

    public static String[] Solution()
    {
        String text[] = {
                "How to solve *",
                "How to resolve *",
                "How to mitigate *",
                "Solution for *",
                "Provide me some Solution for *",
                "mitigation for *",
                "How to *"
        };
        return text;
    }
    public static String[] Greet() {
        String text[] = {
                "Hi",
                "Hello"
        };
        return text;
    }
    public String typeOfIntentSelection()
    {
        String intentType="";
            intentType = intentObj.typeOfIntent(typeOfIntentClass(UserMessage));
        return intentType;
    }
    public static boolean StringMatcher(String text,String arr[])
    {
        for(String k:arr)
        {
            if(k.contains(text)) return true;
        }
        return false;
    }
    public static int typeOfIntentClass(String text)
    {
        if(StringMatcher(text,Greet())) return 1;
        else if(StringMatcher(text,Description())) return 2;
        else if(StringMatcher(text,Solution())) return 3;
        else if(StringMatcher(text,Troubleshoot())) return 4;
        else return 5;
    }
}
