package com.vivetlist.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SandboxController {

    @GetMapping("/sandbox")
    public String standupSandbox() {
        return "single-group";
    }
}