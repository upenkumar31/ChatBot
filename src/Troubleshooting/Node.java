package Troubleshooting;

import java.util.ArrayList;

public class Node {
    private int nodeNumber;
    private int ParentNodeNumber;
    private String responseString;
    private ArrayList<Integer> childNodes;
    Node()
    {
        nodeNumber = getParentNodeNumber();
        ParentNodeNumber = nodeNumber;
        childNodes = new ArrayList<>();
        responseString = "";
    }
    Node(int parentNodeNumber,String responseString)
    {
        this.nodeNumber = NodeNumber.getNextNodeNumber();
        this.ParentNodeNumber = parentNodeNumber;
        this.childNodes = new ArrayList<>();
        this.responseString = responseString;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }
    public int getParentNodeNumber() {
        return ParentNodeNumber;
    }
    public void setParentNodeNumber(int parentNodeNumber) {
        ParentNodeNumber = parentNodeNumber;
    }

    public ArrayList<Integer> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(ArrayList<Integer> childNodes) {
        this.childNodes = childNodes;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }

    public String getResponseString() {
        return responseString;
    }
}
