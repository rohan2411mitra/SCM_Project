package com.scm.controllers;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model){
        System.out.println("Home Page handler");
        model.addAttribute("name","Substring Technologies");
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage(){
        System.out.println("About Page Loading");
        return "about";
    }

    @GetMapping("/services")
    public String servicesPage(){
        System.out.println("Services Page Loading");
        return "services";
    }


    // Contact Page
    @GetMapping("/contact")
    public String contactPage(){
        System.out.println("Contact Page Loading");
        return "contact";
    }

//    Show Login Page
    @GetMapping("/login")
    public String loginPage(){
        System.out.println("Login Page Loading");
        return "login";
    }

//    Show Registration Page
    @GetMapping("/register")
    public String registerPage(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        System.out.println("Sign Up Page Loading");
        return "register";
    }

    // Processing registration
    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        System.out.println("Processing Registrations");

        // Validate Form Data
        if (rBindingResult.hasErrors()){
            return "register";
        }

        // Build user
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(true);
        user.setProfilePic("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png");

        // Save to database
        User savedUser = userService.saveUser(user);
        System.out.println("User saved:");
        System.out.println(savedUser);

        // Add the message
        Message message=Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message",message);

        return "redirect:/register";
    }
}
