public class intent {
    public String typeOfIntent(int textType)
    {
        String typeOfIntentString="";
        switch (textType)
        {
            case 1: typeOfIntentString = "Greet";break;
            case 2: typeOfIntentString = "Search";break;
            case 3: typeOfIntentString = "BugReport";break;
            case 4: typeOfIntentString = "ProductDetail";break;
            default: typeOfIntentString = "notInTheList";break;
        }
        return  typeOfIntentString;
    }

}
