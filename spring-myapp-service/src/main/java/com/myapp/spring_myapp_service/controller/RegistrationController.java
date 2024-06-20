package com.myapp.spring_myapp_service.controller;

import com.myapp.spring_myapp_service.model.dto.UserRegistrationDto;
import com.myapp.spring_myapp_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/myapp/registration")
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    private final UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);

        LOGGER.info("User with First Name: {}, Last Name: {} and Email: {} is saved in DB! ",
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail());
        return "redirect:/api/v1/myapp/registration?success";
    }

}
