package Troubleshooting;

import javax.json.JsonString;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TroubleshootingResponses {
    public static ArrayList<String> listOfResponse;
    private int totalResponse;
    TroubleshootingResponses()
    {
        listOfResponse = new ArrayList<>();
        totalResponse = 0;
    }
    TroubleshootingResponses(String fileName)
    {
        Scanner scanner = new Scanner(fileName);
        listOfResponse = new ArrayList<>();
        while(scanner.hasNext())
        {
            listOfResponse.add(scanner.nextLine());
        }
        totalResponse = listOfResponse.size();
    }
    public void reload(String fileName)
    {
        listOfResponse.clear();
        Scanner scanner = new Scanner(fileName);
        while(scanner.hasNext())
        {
            listOfResponse.add(scanner.nextLine());
        }
    }
    public int getTotalResponse() {
        return totalResponse;
    }

    public ArrayList<String> getListOfResponse() {
        return listOfResponse;
    }

    public void setListOfResponse(ArrayList<String> listOfResponse) {
        this.listOfResponse = listOfResponse;
    }

    public String getResponseByResponseNumber(int nodeNumber)
    {
        return this.listOfResponse.get(nodeNumber);
    }
    public void SaveResponseToFile(String fileName)
    {
        try{
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            for(String K:listOfResponse)
            {
                fileWriter.write(K+"\n");
            }
            fileWriter.close();
        }catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}
