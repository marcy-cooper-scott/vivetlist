package com.vivetlist.main.Services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vivetlist.main.models.Reminder;
import org.springframework.stereotype.Service;

@Service
public class SMSrunner {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACdd2933cab5f6f226ec794eee5aecc405";
    public static final String AUTH_TOKEN =
            "c2bf051b30c27abe85fa20f4b8324fde";

    public void runner(Reminder reminder) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String body;
        if (reminder.getMed() == null) {
            body = "Hey! This is VivetList reminding you of an appointment with " +
                    reminder.getAppt().getDoctor_name() + " located at " +
                    reminder.getAppt().getLocation() + " at " +
                    reminder.getAppt().getDate_time();
        } else {
            body = "Hey! This is Vivetlist reminding you to get a refill of your " +
                    reminder.getMed().getMedicine_name();
        }
        Message message = Message
                .creator(new PhoneNumber("+1" + reminder.getUser().getPhone_number()), // to
                        new PhoneNumber("+13133670029"), // from
                        body)
                .create();
        System.out.println(message.getSid());
    }
}