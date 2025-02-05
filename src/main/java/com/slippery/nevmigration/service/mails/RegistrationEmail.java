package com.slippery.nevmigration.service.mails;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegistrationEmail {
    private final JavaMailSender javaMailSender;

    public RegistrationEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendLoginEmail(String userEmail,String username){
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setTo(userEmail);
        mailMessage.setSubject("Welcome to Nevani Housing");
        mailMessage.setText("Hi "+username+",\n" +
                "\n" +
                "Welcome to Nevani Housing! We're excited to have you on board.\n" +
                "\n" +
                "With your new account, you can:\n" +
                "- Browse and save your favorite properties\n" +
                "- Receive alerts for new listings that match your criteria\n" +
                "- Connect with real estate agents for personalized assistance\n" +
                "\n" +
                "To get started, simply log in to your account using the link below:\n" +
                "\n" +
                "[Login Link]\n" +
                "\n" +
                "If you have any questions or need assistance, feel free to reach out to our support team at johnkinuthia@gmail.com \n" +
                "\n" +
                "Happy house hunting!\n" +
                "\n" +
                "Best regards,\n" +
                "The Nevani Housing Team");
        javaMailSender.send(mailMessage);

    }
}
