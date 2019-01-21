package Troubleshooting;
import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {
    static Scanner sc ;
    public static int addResponse(int parentNode)
    {
        sc = new Scanner(System.in);
        String input = sc.nextLine();
        Node node = new Node(parentNode,input);
        TroubleshootingResponses.listOfResponse.add(jsonUtility.NodeToJsonString(node));
        return node.getNodeNumber();
    }
    public static void display(Node node)
    {
        System.out.println("*******************************************************************");
        System.out.println("Node: "+node.getNodeNumber());
        System.out.println("Response: "+node.getResponseString());
        System.out.println("ParentNode: "+node.getParentNodeNumber());
        System.out.println("Child Responses are :");
        int numberOfChild = node.getChildNodes().size();
        ArrayList<Integer> childNodes = node.getChildNodes();
        for(int i=0;i<numberOfChild;i++)
        {
            Node childNode = jsonUtility.jsonStringToNode(TroubleshootingResponses.listOfResponse.get(childNodes.get(i)));
            System.out.println((i+1)+" : " + childNode.getResponseString());
        }
    }
    public static void main(String args[])
    {
        TroubleshootingResponses troubleshootingResponses = new TroubleshootingResponses("Response.txt");
        //NodeNumber.setNodeNumber(troubleshootingResponses.getTotalResponse());
        int CurrentNode = 0;
        Node firstNode = new Node(0,"Ribbon");
        NodeNumber.setNodeNumber(0);
        troubleshootingResponses.getListOfResponse().add(jsonUtility.NodeToJsonString(firstNode));
        troubleshootingResponses.SaveResponseToFile("Response.txt");
        troubleshootingResponses.reload("Response.txt");
        sc = new Scanner(System.in);
        while(true)
        {
            Node runningNode = jsonUtility.jsonStringToNode(TroubleshootingResponses.listOfResponse.get(CurrentNode));
            //if(CurrentNode!=0)
            display(runningNode);
            System.out.println("1 - Add Child Node \n 2 - Delete Child Node \n 3 - Edit Child Node \n 4 - Go to Child Node \n 5 - Go to Parent node");
            int caseValue = sc.nextInt();
            switch (caseValue)
            {
                case 1: runningNode.getChildNodes().add(addResponse(runningNode.getNodeNumber()));
                        troubleshootingResponses.SaveResponseToFile("Response.txt");
                        troubleshootingResponses.reload("Response.txt");
                        break;
                case 4: System.out.println("Please Enter Child Response Number: ");
                        CurrentNode = sc.nextInt();
                        break;
                case 5: CurrentNode = runningNode.getParentNodeNumber();
                        break;
            }

        }

    }
}
