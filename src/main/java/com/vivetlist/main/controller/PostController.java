package com.vivetlist.main.controller;

import com.vivetlist.main.Services.UserService;
import com.vivetlist.main.models.Group;
import com.vivetlist.main.models.Post;
import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.CommentRepo;
import com.vivetlist.main.repos.GroupRepo;
import com.vivetlist.main.repos.PostRepo;
import com.vivetlist.main.repos.UserRepo;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class PostController {
    UserRepo userDao;
    PostRepo postDao;
    GroupRepo groupDao;
    UserService userService;
    CommentRepo commentRepo;

    public PostController(UserRepo userDao, PostRepo postDao, GroupRepo groupDao, UserService userService, CommentRepo commentRepo){
        this.userDao = userDao;
        this.postDao = postDao;
        this.groupDao = groupDao;
        this.userService = userService;
        this.commentRepo = commentRepo;
    }


    @GetMapping("/group/{gid}/posts/{pid}")
    public String showAPost(@PathVariable long gid, @PathVariable long pid, Model model){
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("post", postDao.findById(pid));
        model.addAttribute("comments", commentRepo.findAllByPostId(pid));
        return "posts/show";
    }

    @GetMapping("/group/{gid}/posts/{pid}/edit")
    public String editPost(@PathVariable long gid, @PathVariable long pid, Model model){
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("post", postDao.findById(pid));
        return "posts/edit";
    }

    @PostMapping("/group/{gid}/posts/{pid}/edit")
    public String handleEdit(@PathVariable long gid, @PathVariable long pid, Model model, @ModelAttribute Post post){
        User user = userService.loggedInUser();
        Post originalPost = postDao.findById(pid);
        originalPost.setId(pid);
        originalPost.setTitle(post.getTitle());
        originalPost.setBody(post.getBody());
        originalPost.setUser(user);
        originalPost.setGroup(groupDao.findById(gid));
        postDao.save(originalPost);
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("isOwnedBy", userService.isOwnedBy(originalPost.getUser()));
        model.addAttribute("isLoggedIn", userService.isLoggedIn());
        return "redirect:/group/{gid}";
    }

    @GetMapping("/group/{gid}/posts/create")
    public String createPost(@PathVariable long gid, Model model){
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/group/{gid}/posts/create")
    public String insertPost(@PathVariable long gid, @ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setGroup(groupDao.findById(gid));
        post.setUser(loggedInUser);
        postDao.save(post);
        return "redirect:/group/{gid}";
    }

    @PostMapping("/group/{gid}/posts/delete")
    public String deletePost(@PathVariable long gid, @ModelAttribute Post post, Model model){
        postDao.delete(post);
        model.addAttribute("group", groupDao.findById(gid));
        return "redirect:/group/{gid}";
    }

    @GetMapping("/group/{gid}/posts/search")
    public String searchGroups(@PathVariable long gid, @RequestParam String search, Model model){
        model.addAttribute("group", groupDao.findById(gid));
        model.addAttribute("posts", postDao.findAllByTitleContaining(search));
        return "posts/search";
    }


}
