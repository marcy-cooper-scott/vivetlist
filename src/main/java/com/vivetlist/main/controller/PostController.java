package com.vivetlist.main.controller;

import com.vivetlist.main.Services.UserService;
import com.vivetlist.main.models.Post;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.GroupRepo;
import com.vivetlist.main.repos.PostRepo;
import com.vivetlist.main.repos.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    UserRepo userDao;
    PostRepo postDao;
    GroupRepo groupDao;
    UserService userService;

    public PostController(UserRepo userDao, PostRepo postDao, GroupRepo groupDao, UserService userService){
        this.userDao = userDao;
        this.postDao = postDao;
        this.groupDao = groupDao;
        this.userService = userService;
    }



    @GetMapping("/posts/{id}")
    public String showAPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @PostMapping("/posts/{id}/edit")
    public String handleEdit(@PathVariable long id, Model model, @ModelAttribute Post post){
        User user = userService.loggedInUser();
        Post originalPost = postDao.findById(id);
        model.addAttribute("isOwnedBy", userService.isOwnedBy(originalPost.getUser()));
        model.addAttribute("isLoggedIn", userService.isLoggedIn());
        originalPost.setTitle(post.getTitle());
        originalPost.setBody(post.getBody());
        postDao.save(originalPost);
        return "redirect:/groups/posts";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insertPost(@ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(loggedInUser);
        postDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post){
        postDao.delete(post);
        return "redirect:/posts";
    }





}
