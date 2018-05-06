package com.vivetlist.main.controller;

import com.vivetlist.main.models.Appointment;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.AppointmentRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/appointments/create")
    public String createAppt(Model model){
        model.addAttribute("appointment", new Appointment());
        return "appointments/create";

    }

    @PostMapping("/appointments/create")
    public String insertAppt(@ModelAttribute Appointment appt){
        User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        appt.setUser(loggedInUser);
        apptRepo.save(appt);
        return "redirect:/mylist";
    }

    @GetMapping("/appointments/{id}/edit")
    public String editAppt(@PathVariable long id, Model model){
        model.addAttribute("appointment", apptRepo.findOne(id));
        return "appointments/edit";
    }

    @PostMapping("/appointents/{id}/edit")
    public String handleEdit(@PathVariable long id, @ModelAttribute Appointment appt){
        Appointment origAppt = apptRepo.findOne(id);
        origAppt.setDate_time(appt.getDate_time());
        origAppt.setDoctor_name(appt.getDoctor_name());
        origAppt.setLocation(appt.getLocation());
        apptRepo.save(origAppt);
        return "redirect:/mylist";
    }

    @PostMapping("/appointments/delete")
    public String deleteAppt(@ModelAttribute Appointment appt){
        apptRepo.delete(appt);
        return "redirect:/mylist";
    }
}
