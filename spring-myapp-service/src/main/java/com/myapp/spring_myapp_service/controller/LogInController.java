package com.myapp.spring_myapp_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//login and home from templates
@Controller
@RequestMapping("/api/v1/myapp")
public class LogInController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogInController.class);

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}