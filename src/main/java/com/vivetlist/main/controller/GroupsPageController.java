package com.vivetlist.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupsPageController {

    @GetMapping("/groups")
    public String groupsPage() { return "groups"; }
}