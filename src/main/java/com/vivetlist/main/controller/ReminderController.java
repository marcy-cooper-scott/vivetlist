package com.vivetlist.main.controller;

import com.vivetlist.main.models.Appointment;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.ReminderRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReminderController {

    ReminderRepo repo;

    ReminderController(ReminderRepo repo){
        this.repo = repo;
    }

    @GetMapping("/reminders.json")
    @ResponseBody
    public List<Appointment> reminderAsJSON() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repo.findByUserID(user.getId());
    }
}
