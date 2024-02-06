package com.reg.registration.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reg.registration.model.User;

@Controller
public class Regcontroller {
    @RequestMapping("/")
    public String homepage() {
        return "index";
    }
    @RequestMapping("/register")
    public String showForm(Model model) {
        System.out.println("Working in form");
        User user = new User();
        List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");
        model.addAttribute("user", user);
        model.addAttribute("professionList", professionList);
        return "regform";
    }
    @PostMapping("/registersubmit")
    public String submitForm(@ModelAttribute("user")User user){
       System.out.println(user);
       if(user.getBirthday()!=null)System.out.println(user.getBirthday());
        return "successpage";
    }
}
