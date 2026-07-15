package com.interviewprep.solid.dependency_inversion.before;

public class Notification {
    private EmailService emailService = new EmailService();

    public void notify(String message) {
        emailService.sendEmail(message);
    }
}
