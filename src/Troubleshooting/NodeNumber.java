package Troubleshooting;

public  class NodeNumber {
    static int nodeNumber=0;

    public static void setNodeNumber(int nodeNumber) {
        NodeNumber.nodeNumber = nodeNumber;
    }

    public static int getNextNodeNumber()
    {
        nodeNumber++;
        return nodeNumber;
    }
}
