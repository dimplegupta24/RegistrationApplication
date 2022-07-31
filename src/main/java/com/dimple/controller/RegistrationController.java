package com.dimple.controller;

import com.dimple.dao.UserRepository;
import com.dimple.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String signUpPage(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/process_registration")
    public String processRegistration(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "registration-success";
    }

    @GetMapping("/list_users")
    public String viewUserList(Model model){
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "users";
    }
}
