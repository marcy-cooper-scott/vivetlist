package com.vivetlist.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MylistController {

    @GetMapping("/mylist")
    public String myList() { return "mylist"; }
}
