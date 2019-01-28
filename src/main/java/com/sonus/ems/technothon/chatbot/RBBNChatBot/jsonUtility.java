package com.sonus.ems.technothon.chatbot.RBBNChatBot;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class jsonUtility {
    public static Node jsonStringToNode(String jsonString)
    {
        Node node = new Node();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            node.setNodeNumber((jsonObject.getInt("NodeNumber")));
            node.setResponseString(jsonObject.getString("Response"));
            node.setParentNodeNumber((jsonObject.getInt("ParentNode")));
            node.setDecision(jsonObject.getString("Dec"));
            int totalNumberOfChildNode = Integer.parseInt(jsonObject.getString("NumberOfChild"));
            JSONObject childJsonObject = new JSONObject(jsonObject.getString("Child"));
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i=0;i<totalNumberOfChildNode;i++)
            {
                arrayList.add(childJsonObject.getInt(String.valueOf(i)));
            }
            node.setChildNodes(arrayList);
        }catch (JSONException exp)
        {
            exp.getCause();
        }
        return node;
    }
    public static String NodeToJsonString(Node node)
    {
        String result = "";
        try {
            JSONObject jsonObject = new JSONObject();
            JSONObject childJsonObject = new JSONObject();
            jsonObject.put("NodeNumber", node.getNodeNumber());
            jsonObject.put("ParentNode",node.getParentNodeNumber());
            jsonObject.put("Response",node.getResponseString());
            jsonObject.put("NumberOfChild",node.getChildNodes().size());
            jsonObject.put("Dec",node.getDecision());
            ArrayList<Integer> childNode = node.getChildNodes();
            for(int i=0;i<childNode.size();i++)
            {
                childJsonObject.put(String.valueOf(i),childNode.get(i));
            }
            jsonObject.put("Child",childJsonObject.toString());
            result = jsonObject.toString();
        }catch (JSONException exp)
        {
            exp.getCause();
        }
        return result;
    }
}
