package com.vivetlist.main.Services;

import com.sendgrid.*;
import com.vivetlist.main.models.Reminder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailService {

    public SendGrid sendGrid;

    public EmailService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    public void sendMail(Reminder reminder) {
        Email from = new Email("info@vivetlist.com");
        String subject = "VivetList Reminder";
        Email to = new Email(reminder.getUser().getEmail());
        Content content = new Content("text/plain", "Here is your reminder for your appointment with " + reminder.getAppt().getDoctor_name() +
            " located at " + reminder.getAppt().getLocation() + " which will be at " + reminder.getAppt().getDate_time() + "!");
        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = this.sendGrid.api(request);
            sendGrid.api(request);
            System.out.println(response.getBody());
            System.out.println("Sent the email out for " + reminder.getId());
        } catch (IOException ex) {
            System.out.println("Could not send due to " + ex.getMessage());
        }
    }
}
