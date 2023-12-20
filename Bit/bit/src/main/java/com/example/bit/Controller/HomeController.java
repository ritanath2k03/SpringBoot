package com.example.bit.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/message")
    public String get(){
        return "Hi it is working";
    }
}
