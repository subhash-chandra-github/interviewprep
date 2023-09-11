package com.interviewprep.LLD.NotificationSystem;

public class NotificationSender {

    private SendNotification sendNotification;
    NotificationSender(SendNotification sendNotification){
        this.sendNotification = sendNotification;
    }

    public void send(String userId, String message){
        sendNotification.sendNotification(userId,message);
    }


    public static void main(String[] args) {

        NotificationSender smsSender = new NotificationSender(new SmsNotification());
        smsSender.send("5","Hello");
    }
}
