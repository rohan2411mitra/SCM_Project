package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    // User Dashboard page
    @GetMapping(value = "/dashboard")
    public String userDashboard(Principal principal) {
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    // User Profile Page
    @GetMapping(value = "/profile")
    public String userProfile(Model model, Authentication authentication) {
        System.out.println("User profile");
        return "user/profile";
    }


}