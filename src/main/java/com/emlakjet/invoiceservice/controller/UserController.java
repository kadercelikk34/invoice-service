package com.emlakjet.invoiceservice.controller;

import com.emlakjet.invoiceservice.entity.User;
import com.emlakjet.invoiceservice.service.InvoiceService;
import com.emlakjet.invoiceservice.service.SecurityService;
import com.emlakjet.invoiceservice.service.UserService;
import com.emlakjet.invoiceservice.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Kullanıcı adınız ve şifreniz geçersiz.");

        if (logout != null)
            model.addAttribute("message", "Başarıyla çıkış yaptınız..");

        return "login";
    }

    @GetMapping(value = {"/", "/dashboard"})
    public ModelAndView welcome(Model model) {
        ModelAndView map = new ModelAndView("dashboard");
        map.addObject("lists", invoiceService.getInvoiceList());
        return map;
    }
}
