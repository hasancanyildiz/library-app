package com.library.library_app;

public class NotificationSender {
    private String provider ;
    public NotificationSender(String provider){
        this.provider= provider;
    }
    public void send (String massage){
        System.out.println("Provider :"+provider+"Massage : "+massage);

    }
}
