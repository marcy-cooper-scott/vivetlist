package com.vivetlist.main.Services;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private JavaMailSender sender;

    EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail(String email) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("info@vivetlist.com");
        helper.setTo(email);
        helper.setText("How are you?");
        helper.setSubject("Hi");
        sender.send(message);
    }
}
