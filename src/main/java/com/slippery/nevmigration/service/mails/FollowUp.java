package com.slippery.nevmigration.service.mails;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class FollowUp {
    private final JavaMailSender javaMailSender;

    public FollowUp(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendFollowUpEmail(String email,String username){
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("How's Your Experience with Nevani Housing?");
        mailMessage.setText("Hi "+email+",\n" +
                "\n" +
                "We hope you're enjoying your experience with Nevani Housing so far! \n" +
                "\n" +
                "Have you had a chance to explore our listings? If you need any help or have questions, our support team is here for you.\n" +
                "\n" +
                "Also, don’t forget to check out our latest listings and market insights!\n" +
                "\n" +
                "Thank you for being a part of our community!\n" +
                "\n" +
                "Best wishes,\n" +
                "The Nevani Housing Team");
        javaMailSender.send(mailMessage);
    }
}
