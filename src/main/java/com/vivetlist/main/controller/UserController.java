package com.vivetlist.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/sign-up")
    public String signUp() { return "sign-up"; }
}
