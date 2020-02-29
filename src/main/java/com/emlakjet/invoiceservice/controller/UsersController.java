package com.emlakjet.invoiceservice.controller;

import com.emlakjet.invoiceservice.model.Student;
import com.emlakjet.invoiceservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;



    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }


    @RequestMapping(value = "/student" , method = RequestMethod.GET)
    private ModelAndView student(){
        return new ModelAndView("student","command", new Student());
    }
}
