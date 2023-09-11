package com.interviewprep.LLD.NotificationSystem;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    private List<String> userIds = new ArrayList<>();
    private String message;

    public void addObserver(String userId) {
        this.userIds.add(userId);
    }

    public void removeObserver(String userId) {
        this.userIds.remove(userId);
    }

    public void sendMessage(String message) {
        this.message = message;
        for (String userId : this.userIds) {
            NotificationSender smsSender = new NotificationSender(new SmsNotification());
            smsSender.send(userId,message);
        }
    }

    public static void main(String[] args) {

    }
}
