package BugReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EMSTemplete {
    static String [] listOfQuestions()
    {
        String question [] ={
                "Can you please Give Tittle of your Problem with EMS?",
                "Can you please give description of your Problem?",
                "Can you share any logs with us?",
                "Do you have any Screenshoot of this bug? \n Can you please share with us?",
                "Which EMS Version you are using?",
                "Which device you have connected with EMS?",
                "Any Other Details you want to share?"
        };
        return question;
    }
    public static void reporter()
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> reportFile = new ArrayList<>();
        String questions[] = listOfQuestions();
        {
            for(String question:questions)
            {
                System.out.println(question);
                reportFile.add(sc.nextLine());
            }
        }
        try {
            File reportedFile = new File("EMS:"+reportFile.get(0));
            FileWriter fileWriter = new FileWriter(reportedFile);
            for(int i=0;i<reportedFile.length();i++)
            {
                fileWriter.write(Integer.toString(i)+". "+ questions[i]+"\n");
                fileWriter.write(reportFile.get(i));
            }
            fileWriter.close();
        }catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }
}
