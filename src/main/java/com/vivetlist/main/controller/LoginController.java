package com.vivetlist.main.controller;

import com.vivetlist.main.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    UserRepo userDao;

    public LoginController(UserRepo userDao){
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String getLogin() { return "login"; }

    @PostMapping("/login")
    public String userLoggedIn(){

        return "redirect:/mylist";
    }


}
