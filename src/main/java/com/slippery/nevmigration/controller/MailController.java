package com.slippery.nevmigration.controller;

import com.slippery.nevmigration.dto.MailDto;
import com.slippery.nevmigration.service.mails.ContactUsEmail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class MailController {
    private final ContactUsEmail contactUsEmail;

    public MailController(ContactUsEmail contactUsEmail) {
        this.contactUsEmail = contactUsEmail;
    }
    @PostMapping("/send")
    public ResponseEntity<MailDto> sendContactEmail(@RequestParam String firstName,
                                                    @RequestParam String lastName,
                                                    @RequestParam String email,
                                                    @RequestParam String message,
                                                    @RequestParam String mobileNumber) throws IOException {
        return ResponseEntity.ok(contactUsEmail.sendContactEmail(firstName, lastName, email, message, mobileNumber));

    }
}
