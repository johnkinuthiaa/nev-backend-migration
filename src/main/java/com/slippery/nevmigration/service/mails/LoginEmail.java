package com.slippery.nevmigration.service.mails;

import com.slippery.nevmigration.dto.MailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.InetSocketAddress;

@Service
public class LoginEmail {
    private final JavaMailSender javaMailSender;

    public LoginEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public MailDto loginEmail(String email){
        SimpleMailMessage message =new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("New Login Alert");
        return new MailDto();
    }
}
