package com.vivetlist.main.controller;

import com.vivetlist.main.Services.UserService;
import com.vivetlist.main.models.Group;
import com.vivetlist.main.models.Post;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.GroupRepo;
import com.vivetlist.main.repos.PostRepo;
import com.vivetlist.main.repos.UserRepo;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

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


    @GetMapping("/group/{gid}/posts/{id}")
    public String showAPost(@PathVariable long gid, @PathVariable long id, Model model){
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @GetMapping("/group/{gid}/posts/{id}/edit")
    public String editPost(@PathVariable long gid, @PathVariable long id, Model model){
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/group/{gid}/posts/{id}/edit")
    public String handleEdit(@PathVariable long gid, @PathVariable long id, Model model, @ModelAttribute Post post){
        User user = userService.loggedInUser();
        Post originalPost = postDao.findById(id);
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("isOwnedBy", userService.isOwnedBy(originalPost.getUser()));
        model.addAttribute("isLoggedIn", userService.isLoggedIn());
        originalPost.setTitle(post.getTitle());
        originalPost.setBody(post.getBody());
        originalPost.setGroup(post.getGroup());
        postDao.save(originalPost);
//        RedirectView rv = new RedirectView();
//        rv.setContextRelative(true);
//        rv.setUrl("/group/{id}/single-group");
//        return rv;
        return "redirect:/groups";
    }

    @GetMapping("/group/{id}/posts/create")
    public String createPost(@PathVariable long id, Model model){
        model.addAttribute("group", groupDao.findById(id));
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/group/{id}/posts/create")
    public String insertPost(@PathVariable long id, @ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setGroup(groupDao.findById(id));
        post.setUser(loggedInUser);
        postDao.save(post);
//        RedirectView rv = new RedirectView();
//        rv.setContextRelative(true);
//        rv.setUrl("/group/{id}/single-group");
//        return rv;
        return "redirect:/groups";
    }

    @PostMapping("/group/{id}/posts/delete")
    public String deletePost(@PathVariable long id, @ModelAttribute Post post, Model model){
        model.addAttribute("group", groupDao.findById(id));
        postDao.delete(post);
        // added for the redirect
//        RedirectView rv = new RedirectView();
//        rv.setContextRelative(true);
//        rv.setUrl("/group/{id}/single-group");
//        return rv;
        return "redirect:/groups";
    }




}
