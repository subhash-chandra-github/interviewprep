package com.interviewprep.LLD.NotificationSystem;

public class EmailNotification implements SendNotification{


    @Override
    public void sendNotification(String userId, String message) {
            System.out.println("Sending email to userId "+userId+" email body "+message);
    }
}
