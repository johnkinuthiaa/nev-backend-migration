package com.slippery.nevmigration.service.mails;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PasswordConfirmation {
    private final JavaMailSender javaMailSender;

    public PasswordConfirmation(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendPasswordResetMessage(String email,String username){
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setSubject("Reset Your Password for Account");
        mailMessage.setTo(email);
        mailMessage.setText("Hi "+username+",\n" +
                "\n" +
                "We received a request to reset your password for your Nevani Housing's account. If you did not request this, please ignore this email.\n" +
                "\n" +
                "To reset your password, click the link below:\n" +
                "\n" +
                "[Reset Password Link]\n" +
                "\n" +
                "This link will expire in 1 hour. If you do not reset your password within this time, you will need to request a new password reset.\n" +
                "\n" +
                "If you have any questions, feel free to reach out to our support team at johnkinuthia122@gmail.com.\n" +
                "\n" +
                "Best regards,\n" +
                "The Nevani Housing Team");
        javaMailSender.send(mailMessage);
    }
}
