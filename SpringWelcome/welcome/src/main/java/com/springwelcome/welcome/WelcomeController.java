package com.springwelcome.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class WelcomeController {
    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return "Welcome to this page Rith";
    }
}
