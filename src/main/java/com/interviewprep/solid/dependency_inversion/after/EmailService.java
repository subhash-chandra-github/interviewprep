package com.interviewprep.solid.dependency_inversion.after;

public class EmailService implements MessageSender {

    @Override
    public void sendMessage(String message) {
        // send email
    }
}
