import java.util.Scanner;

public class test {
    static Scanner sc = new Scanner(System.in);
    public static String getInput()
    {
        return sc.nextLine();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        UserMessageToResponse userMessageToResponse;
        String msg;
        System.out.print("User:");
        while((msg = getInput())!=null)
        {
            userMessageToResponse = new UserMessageToResponse(msg);
            System.out.println("BOT: "+userMessageToResponse.getReply());
            System.out.print("User:");
        }
    }
}
