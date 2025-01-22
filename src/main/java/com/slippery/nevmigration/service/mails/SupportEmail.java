package com.slippery.nevmigration.service.mails;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SupportEmail {
    private final JavaMailSender javaMailSender;

    public SupportEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void supportEmail(String username,String email){
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setSubject("Need Help? We're Here for You!");
        mailMessage.setTo(email);
        mailMessage.setText("Hi "+username+",\n" +
                "\n" +
                "We wanted to remind you that our support team is here to assist you with any questions or concerns you may have about your account or our platform.\n" +
                "\n" +
                "Here are some helpful resources:\n" +
                "- [Link to Help Center]\n" +
                "- [Link to Contact Support]\n" +
                "- [Link to Community Forum]\n" +
                "\n" +
                "Feel free to reach out anytime!\n" +
                "\n" +
                "Best,\n" +
                "The Nevani Housing Team");
        javaMailSender.send(mailMessage);
    }
}
