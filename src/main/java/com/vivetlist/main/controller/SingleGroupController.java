package com.vivetlist.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SingleGroupController {

    @GetMapping("/single-group")
    public String singleGroup() { return "single-group"; }
}
