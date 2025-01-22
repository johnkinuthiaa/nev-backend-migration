package com.slippery.nevmigration.service.mails;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AccountConfirmation {
    private final JavaMailSender javaMailSender;

    public AccountConfirmation(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void SendConfirmationEmail(String username,String userEmail){
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setTo(userEmail);
        mailMessage.setSubject(" Confirm Your Email Address");
        mailMessage.setText("Hi "+username+",\n" +
                "\n" +
                "Thank you for registering with Nevani Housing! To complete your registration, please confirm your email address by clicking the link below:\n" +
                "\n" +
                "[Confirmation Link]\n" +
                "\n" +
                "If you did not create an account, please ignore this email.\n" +
                "\n" +
                "Thank you,\n" +
                "The Nevani Housing Team");
        javaMailSender.send(mailMessage);
    }
}
