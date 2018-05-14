package com.vivetlist.main.controller;

import com.vivetlist.main.Services.FriendlyTimeService;
import com.vivetlist.main.models.Appointment;
import com.vivetlist.main.models.Medicine;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.MedicineRepo;
import com.vivetlist.main.repos.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MylistController {

    MedicineRepo repo;
    FriendlyTimeService service;

    MylistController(MedicineRepo repo, FriendlyTimeService service){
        this.repo = repo;
        this.service = service;
    }

    @GetMapping("/mylist")
    public String myList(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("meds", repo.findAllByUserId(user.getId()));
        model.addAttribute("service", service);
        return "mylist";
    }


}
