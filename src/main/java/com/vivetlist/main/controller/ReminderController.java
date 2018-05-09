package com.vivetlist.main.controller;

import com.vivetlist.main.models.*;
import com.vivetlist.main.repos.*;
import org.joda.time.DateTime;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class ReminderController {

    ReminderRepo repo;
    AppointmentRepo apptRepo;
    MedicineRepo medRepo;
    NotificationsRepo nRepo;
    UserRepo uRepo;

    ReminderController(ReminderRepo repo, AppointmentRepo apptRepo, MedicineRepo medRepo, NotificationsRepo nRepo,
                       UserRepo uRepo){
        this.repo = repo;
        this.apptRepo = apptRepo;
        this.medRepo = medRepo;
        this.nRepo = nRepo;
        this.uRepo = uRepo;
    }

    @GetMapping("/reminders.json")
    @ResponseBody
    public List<Reminder> reminderAsJSON() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repo.findByUserID(user.getId());
    }

    @GetMapping("/reminders/create")
    public String createReminder(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("appointments", apptRepo.findByUserID(user.getId()));
        model.addAttribute("medicines", medRepo.findAllByUserId(user.getId()));
        model.addAttribute("reminder", new Reminder());
        model.addAttribute("notifications", nRepo.findAll());
        return "/reminders/create";
    }

    @PostMapping("/reminders/create")
    public String setReminder(@ModelAttribute Reminder reminder){
        User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reminder.setUser(loggedInUser);
        reminder.setScheduled_time(convertDate(reminder));
        repo.save(reminder);
        return "redirect:/mylist";
    }

    private Date convertDate(Reminder reminder) { // grab a user, get their timezone, send that back to the db in order
        DateTime joda = new DateTime(reminder.getScheduled_time());
        Long userId = reminder.getUser().getId();
        int diff = uRepo.findById(userId).getTime_zone().intValue();
        joda = joda.minusHours(diff);
        return joda.toDate();
    }
}
