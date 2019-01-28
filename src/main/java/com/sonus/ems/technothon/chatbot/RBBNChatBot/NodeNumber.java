package com.sonus.ems.technothon.chatbot.RBBNChatBot;


//import DB.DBConnector;

public  class NodeNumber {
    static int nodeNumber=0;

    public NodeNumber()
    {
        nodeNumber = (int)DBConnector.collection.count();
    }
    public static void setNodeNumber(int nodeNumber) {
        NodeNumber.nodeNumber = (int)DBConnector.collection.count();
    }

    public static int getNodeNumber() {
        return nodeNumber;
    }

    public static int getNextNodeNumber()
    {
        nodeNumber++;
        return nodeNumber;
    }
}
