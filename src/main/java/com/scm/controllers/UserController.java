package com.scm.controllers;

import com.scm.entities.Contact;
import com.scm.entities.User;
import com.scm.helpers.Helper;
import com.scm.services.ContactService;
import com.scm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    // User Dashboard page
    @GetMapping(value = "/dashboard")
    public String userDashboard(Principal principal,Model model,
                                Authentication authentication) {
        // Load all the user contacts
        String email = Helper.getEmailOfLoggedInUser(authentication);

        User user = userService.getUserByEmail(email);

        Page<Contact> pageContact = contactService.getByUser(user, 0, 10, "name", "asc");
        int totalFavorites = (int) pageContact.getContent().stream()
                .filter(Contact::isFavorite)
                .count();
        model.addAttribute("totalFavorites", totalFavorites);
        model.addAttribute("pageContact", pageContact);
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