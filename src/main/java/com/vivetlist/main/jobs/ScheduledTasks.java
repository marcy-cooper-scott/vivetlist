package com.vivetlist.main.jobs;

import com.vivetlist.main.Services.EmailService;
import com.vivetlist.main.models.Notification_Type;
import com.vivetlist.main.models.Reminder;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.ReminderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

@Component
public class ScheduledTasks {
    private ReminderRepo reminderRepo;
    private EmailService service;

    ScheduledTasks(ReminderRepo reminderRepo, EmailService service) {
        this.reminderRepo = reminderRepo;
        this.service = service;
    }

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(fixedRate = 30000) // we will check every 30 seconds for updates
    public void fetchTimes() throws Exception {
        Iterable<Reminder> reminderList = reminderRepo.findAll();
        if (reminderList == null) {
            log.info("No reminders yet!");
        } else {
            log.info("Running though the reminders...");
            for (Reminder reminder : reminderList) {
                Long id = reminder.getId(); //
                Long type = reminder.getUnit().getId();
                DateTime reminderTime = new DateTime(reminder.getScheduled_time()); // use JodaTime to get more time items
                log.info("Getting reminder id: " + reminder.getId());
                // let's find out what now is considered, and the parameters for determining when exactly to send things now
                DateTime now = new DateTime();
                int dayOfToday = now.getDayOfYear();
                int hourOfDay = now.getHourOfDay();
                int minuteOfHour = now.getMinuteOfHour();
                // let's take the type of notification, and make it into an int to determine how to notify for the request
                // logic: let's divide everything by the type of notification they want
                if (type.intValue() == 2) {
                    // now, for an email, we will find out if it's the day, then send out the email
                    if (dayOfToday == reminderTime.getDayOfYear()) {
                        String email = reminder.getUser().getEmail();
                        service.sendEmail(email);
                        reminderRepo.delete(reminder.getId());
                        log.info("Deleted reminder " + id.intValue() + " from DB > email sent");
                    }
                } else if (type.intValue() == 1) {
                    // now, this is a text, so we need to be more precise: day of year, hour of day, minute of hour
                    if (dayOfToday == reminderTime.getDayOfYear() && hourOfDay == reminderTime.getHourOfDay() && minuteOfHour == reminderTime.getMinuteOfHour()) {
                        String phone = reminder.getUser().getPhone_number();
                        log.error("Would have sent a text to: " + phone);
                        reminderRepo.delete(reminder.getId());
                        log.info("Deleted reminder " + id.intValue() + " from DB > sms sent");
                    }
                } else if (type.intValue() == 3) {
                    if (dayOfToday == reminderTime.getDayOfYear() && hourOfDay == reminderTime.getHourOfDay() && minuteOfHour == reminderTime.getMinuteOfHour()) {
                        String email = reminder.getUser().getEmail();
                        String phone = reminder.getUser().getPhone_number();
                        service.sendEmail(email);
                        log.error("Would have sent a text to: " + phone);
                        reminderRepo.delete(reminder.getId());
                        log.info("Deleted reminder " + id.intValue() + " from DB > email & sms sent");
                    }
                }
                else {
                    System.out.println("Something is wrong, this reminder has no id!");
                }
            }
        }
    }
}
