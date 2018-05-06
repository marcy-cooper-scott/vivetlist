package com.vivetlist.main.controller;

import com.vivetlist.main.Services.UserService;
import com.vivetlist.main.models.Comment;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    UserRepo userDao;
    PostRepo postDao;
    UserService userService;
    CommentRepo commentRepo;
    GroupRepo groupRepo;

    public CommentController(UserRepo userDao, PostRepo postDao, UserService userService, CommentRepo commentRepo, GroupRepo groupRepo){
        this.userDao = userDao;
        this.postDao = postDao;
        this.userService = userService;
        this.commentRepo = commentRepo;
        this.groupRepo = groupRepo;
    }


    @GetMapping("/group/{gid}/posts/{pid}/comments/{cid}")
    public String showComment(@PathVariable long gid, @PathVariable long pid, @PathVariable long cid, Model model){
        model.addAttribute("group", groupRepo.findById(gid));
        model.addAttribute("post", postDao.findById(pid));
        model.addAttribute("comment", commentRepo.findOne(cid));
        return "comments/show";
    }

    @GetMapping("/group/{gid}/posts/{pid}/comments/{cid}/edit")
    public String editComment(@PathVariable long gid, @PathVariable long pid, @PathVariable long cid, Model model){
        model.addAttribute("group", groupRepo.findById(gid));
        model.addAttribute("post", postDao.findById(pid));
        model.addAttribute("comment", commentRepo.findOne(cid));
        return "comments/edit";
    }

    @PostMapping("/group/{gid}/posts/{pid}/comments/{cid}/edit")
    public String handleEdit(@PathVariable long gid, @PathVariable long pid, @PathVariable long cid, Model model, @ModelAttribute Comment comment){
        User user = userService.loggedInUser();
        Comment origComment = commentRepo.findOne(cid);
        origComment.setId(cid);
        origComment.setBody(comment.getBody());
        origComment.setUser(user);
        origComment.setPost(postDao.findById(pid));
        origComment.getPost().setGroup(groupRepo.findById(gid));
        commentRepo.save(origComment);
        model.addAttribute("group", groupRepo.findById(gid));
        model.addAttribute("post", postDao.findById(pid));
        model.addAttribute("isOwnedBy", userService.isOwnedBy(origComment.getUser()));
        model.addAttribute("isLoggedIn", userService.isLoggedIn());
    return "redirect:/group/{gid}/posts/{pid}";
    }

    @GetMapping("/group/{gid}/posts/{pid}/comments/create")
    public String createPost(@PathVariable long gid, @PathVariable long pid, Model model){
        model.addAttribute("group", groupRepo.findById(gid));
        model.addAttribute("post", postDao.findById(pid));
        model.addAttribute("comment", new Comment());
        return "comments/create";
    }

    @PostMapping("/group/{gid}/posts/{pid}/comments/create")
    public String insertPost(@PathVariable long gid, @PathVariable long pid, @ModelAttribute Comment comment){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setPost(postDao.findById(pid));
        comment.getPost().setGroup(groupRepo.findById(gid));
        comment.setUser(loggedInUser);
        commentRepo.save(comment);
        return "redirect:/group/{gid}/posts/{pid}";
    }

    @PostMapping("/group/{gid}/posts/{pid}/comments/delete")
    public String deletePost(@PathVariable long gid, @PathVariable long pid, @ModelAttribute Comment comment, Model model){
        commentRepo.delete(comment);
        model.addAttribute("group", groupRepo.findById(gid));
        model.addAttribute("post", postDao.findById(pid));
        return "redirect:/group/{gid}/posts/{pid}";
    }
}
