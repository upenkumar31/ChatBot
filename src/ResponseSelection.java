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
            responseText = responseArray[random.nextInt(responseArray.length-1)+1];
        }
        return responseText;
    }
    public int getResponseCode(String intent)
    {
        int code = 0;
        if(intent.equalsIgnoreCase("greet"))
            code = 1;
        else if(intent.equalsIgnoreCase("search"))
            code = 2;
        else if(intent.equalsIgnoreCase("bugReport"))
            code = 3;
        else if(intent.equalsIgnoreCase("productDetail"))
            code = 4;
        return code;
    }
    public String reply()
    {
        return getResponse(getResponseCode(intentType));
    }
}
