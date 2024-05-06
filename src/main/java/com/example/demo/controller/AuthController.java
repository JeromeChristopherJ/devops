package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.Login;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AuthController {
    @Autowired
    private AuthService service;

    @GetMapping("/")
    public String api() {
        return "index";
    }
    
    @PostMapping("/log")
    public String login(@ModelAttribute("user") Login user) {
        //TODO: process POST request
        Login oauthuser = service.login(user.getUsername(), user.getPassword());
        if(Objects.nonNull(oauthuser))
        {
            return "redirect:/disp";
        }
        else{
            return "redirect:/";
        }
    }

    @GetMapping("/disp")
    public String display() {
        return "disp";
    }
    
    
    
}
