package com.sonus.ems.technothon.chatbot.RBBNChatBot;



public class ReportTemplete {
    private String device = null;
    ReportTemplete(String device)
    {
        this.device = device.toLowerCase();
    }
    public void StartReporting()
    {
        switch (device)
        {
            case "ems" : EMSTemplete.reporter();break;
            case "sbc" : break;
            default: break;
        }
    }
}
