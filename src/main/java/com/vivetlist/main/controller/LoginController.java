package com.vivetlist.main.controller;

import com.vivetlist.main.repos.MedicineRepo;
import com.vivetlist.main.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    UserRepo userDao;
    MedicineRepo medRepo;

    public LoginController(UserRepo userDao, MedicineRepo medRepo){
        this.userDao = userDao;
        this.medRepo = medRepo;
    }

    @GetMapping("/login")
    public String getLogin() { return "login"; }

    @PostMapping("/login")
    public String userLoggedIn(){
        return "redirect:/mylist";
    }


}
