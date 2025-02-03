package com.slippery.nevmigration.service.mails;

import com.slippery.nevmigration.dto.MailDto;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ContactUsEmail {
    private final JavaMailSender javaMailSender;

    public ContactUsEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public MailDto sendContactEmail(String firstName, String lastName, String email, String message, String mobileNumber) throws IOException {
        MailDto response =new MailDto();
        try{
            SimpleMailMessage mailMessage =new SimpleMailMessage();
            mailMessage.setTo("johnmuniu477@gmail.com");
            mailMessage.setText("Firstname: "+firstName+
                    "\nLastName: "+lastName+
                    "\nEmail: "+email+
                    "\nMobile number :"+mobileNumber+
                    "\n Message :"+message);
            javaMailSender.send(mailMessage);
            response.setMessage("Email sent");
            response.setStatusCode(200);
        } catch (Exception e) {
            response.setMessage("email not sent");
            response.setStatusCode(500);
            throw new IOException(e);
        }

        return response;
    }
}
