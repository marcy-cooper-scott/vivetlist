package com.vivetlist.main.controller;

import com.vivetlist.main.models.*;
import com.vivetlist.main.repos.ReminderRepo;
import org.joda.time.DateTime;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class ReminderController {

    ReminderRepo repo;

    ReminderController(ReminderRepo repo){
        this.repo = repo;
    }

    @GetMapping("/reminders.json")
    @ResponseBody
    public List<Reminder> reminderAsJSON() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repo.findByUserID(user.getId());
    }

    @GetMapping("/reminders/create")
    public String createReminder(Model model){
        model.addAttribute("reminder", new Reminder());
        return "reminders/create";
    }

    @PostMapping("/reminders/create")
    public String setReminder(@ModelAttribute Reminder reminder, @ModelAttribute Appointment appt, @ModelAttribute Medicine med){
        User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reminder.setUser(loggedInUser);
        reminder.setAppt(appt);
        reminder.setMed(med);
        repo.save(reminder);
        return "redirect:/mylist";
    }
//
//    private Date convertDate(Date date) {
//        DateTime joda = new DateTime(date);
//        return joda.minusHours(5).toDate(); // get timezone offset here, fixes the issue
//    }
}
