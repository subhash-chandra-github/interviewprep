package com.interviewprep.LLD.NotificationSystem;

public class SmsNotification implements SendNotification{
    @Override
    public void sendNotification(String userId, String message) {
        System.out.println("Sending sms to userId "+userId+" sms content "+message);
    }
}
