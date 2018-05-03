package com.vivetlist.main.controller;

import com.vivetlist.main.models.Appointment;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.AppointmentRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppointmentController {

    AppointmentRepo apptRepo;

    AppointmentController(AppointmentRepo apptRepo) {
        this.apptRepo = apptRepo;
    }

    @GetMapping("/appointments.json")
    @ResponseBody
    public List<Appointment> appointmentListAsJSON() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return apptRepo.findByUserID(user.getId());
    }
}
