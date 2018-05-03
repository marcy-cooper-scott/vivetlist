package com.vivetlist.main.controller;

import com.vivetlist.main.models.Group;
import com.vivetlist.main.repos.GroupRepo;
import com.vivetlist.main.repos.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class GroupsPageController {
    PostRepo postDao;
    GroupRepo groupDao;

    public GroupsPageController(PostRepo postDao, GroupRepo groupDao){
        this.postDao = postDao;
        this.groupDao = groupDao;
    }

    @GetMapping("/groups")
    public String groupsPage(Model model) {
        model.addAttribute("groups", groupDao.findAll());
        return "groups"; }

//  **************Show All Posts In A Group********************
    @GetMapping("/group/{id}")
    public String viewPosts(Model model, @PathVariable long id){
        model.addAttribute("group", groupDao.findById(id));
        model.addAttribute("posts", postDao.findAllByGroup_Id(id));
        return "single-group";
    }
}