package com.vivetlist.main.controller;

import com.vivetlist.main.models.Group;
import com.vivetlist.main.repos.GroupRepo;
import com.vivetlist.main.repos.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/group/{gid}")
    public String viewPosts(Model model, @PathVariable long gid){
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("posts", postDao.findAllByGroup_Id(gid));
        return "single-group";
    }

    @GetMapping("/groups/search")
    public String searchGroups(@RequestParam String search, Model model){
        model.addAttribute("groups", groupDao.findAllByNameContaining(search));
        return "search";
    }
}