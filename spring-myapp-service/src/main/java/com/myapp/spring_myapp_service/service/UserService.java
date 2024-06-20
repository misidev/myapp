package com.myapp.spring_myapp_service.service;

import com.myapp.spring_myapp_service.model.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	void save(UserRegistrationDto registrationDto);
}
