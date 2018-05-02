package com.vivetlist.main.controller;

import com.vivetlist.main.repos.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GroupsPageController {
    PostRepo postDao;

    public GroupsPageController(PostRepo postDao){
        this.postDao = postDao;
    }

    @GetMapping("/groups")
    public String groupsPage() { return "groups"; }

//  **************Show All Posts In A Group********************
    @GetMapping("/group/{id}")
    public String viewPosts(Model model, @PathVariable long id){
        model.addAttribute("posts", postDao.findAllByGroup_Id(id));
        return "single-group";
    }
}