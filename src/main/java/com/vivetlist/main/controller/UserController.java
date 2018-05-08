package com.vivetlist.main.controller;

import com.vivetlist.main.models.User;
import com.vivetlist.main.repos.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo userDao, PasswordEncoder passwordEncoder){
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String registerUser(@Valid User user, Errors validation, Model model){
        if (validation.hasErrors()){
//            model.addAttribute("user", user);
            return "sign-up";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable long id, Model model){
        model.addAttribute("user", userDao.findById(id));
        return "/edit";
    }

    @PostMapping("edit/{id}")
    public String editUser(@PathVariable long id, @ModelAttribute User user){
            User origUser = userDao.findOne(id);
            origUser.setUsername(user.getUsername());
            origUser.setEmail(user.getEmail());
            origUser.setPhone_number(user.getPhone_number());
            origUser.setTime_zone(user.getTime_zone());
            return "redirect:/mylist";

    }

}
