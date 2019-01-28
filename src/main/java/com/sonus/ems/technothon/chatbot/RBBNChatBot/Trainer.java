
package com.sonus.ems.technothon.chatbot.RBBNChatBot;

//import DBConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {
    static Scanner sc ;
    public static int addResponse(int parentNode)
    {
        sc = new Scanner(System.in);
        System.out.print("Decision:");
        String dec = sc.nextLine();
        System.out.println("Response");
        String input = sc.nextLine();
        Node node = new Node(parentNode,dec,input);
        DBConnector.insert(node.getNodeNumber(),jsonUtility.NodeToJsonString(node));
        return node.getNodeNumber();
    }
    public static void display(Node node)
    {
        System.out.println("*******************************************************************");
        System.out.println("Node: "+node.getNodeNumber());
        System.out.println("Response: "+node.getResponseString());
        System.out.println("Decision: "+ node.getDecision());
        System.out.println("ParentNode: "+node.getParentNodeNumber());
        System.out.println("Child Responses are :");
        int numberOfChild = node.getChildNodes().size();
        ArrayList<Integer> childNodes = node.getChildNodes();
        for(int i=0;i<numberOfChild;i++)
        {
            Node childNode = jsonUtility.jsonStringToNode(DBConnector.search(childNodes.get(i)));
            System.out.println((childNode.getNodeNumber())+" : " + childNode.getResponseString());
        }
    }
    public static void main(String args[]) {
        try {
            int CurrentNode = 1;
            DBConnector dbConnector = new DBConnector();
            NodeNumber nodeNumber = new NodeNumber();
            System.out.println(NodeNumber.getNodeNumber());
            sc = new Scanner(System.in);
            while (true) {
                String responseJSONString = DBConnector.search(CurrentNode);
                Node runningNode = jsonUtility.jsonStringToNode(responseJSONString);
                //if(CurrentNode!=0)
                display(runningNode);
                System.out.println("1 - Add Child Node \n 2 - Delete Child Node \n 3 - Edit Child Node \n 4 - Go to Child Node \n 5 - Go to Parent node");
                int caseValue = sc.nextInt();
                switch (caseValue) {
                    case 1:
                        runningNode.getChildNodes().add(addResponse(runningNode.getNodeNumber()));
                        DBObject from =new BasicDBObject();
                        DBObject to = new BasicDBObject();
                        ((BasicDBObject) from).append("id",runningNode.getNodeNumber());
                        ((BasicDBObject) to).append("id",runningNode.getNodeNumber());
                        ((BasicDBObject) to).append("text",jsonUtility.NodeToJsonString(runningNode));
                        DBConnector.collection.update(from,to);
                        break;
                    case 3:

                            break;
                    case 4:
                        System.out.println("Please Enter Child Response Number: ");
                        CurrentNode = sc.nextInt();
                        break;
                    case 5:
                        CurrentNode = runningNode.getParentNodeNumber();
                        break;
                }

            }

        }catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }
}
