package com.myapp.spring_myapp_service.impl;

import com.myapp.spring_myapp_service.exceptions.UserValidationException;
import com.myapp.spring_myapp_service.model.Role;
import com.myapp.spring_myapp_service.model.User;
import com.myapp.spring_myapp_service.model.dto.UserRegistrationDto;
import com.myapp.spring_myapp_service.repository.UserRepository;
import com.myapp.spring_myapp_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]*$");

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    @Override
    public void save(UserRegistrationDto registrationDto)  {
        validateInputData(registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                registrationDto.getPassword());

        // Encode password
        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());

        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                encodedPassword, Collections.singletonList(new Role("ROLE_USER")));

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    private void validateInputData(String firstName, String lastName, String email, String password) {
        List<String> errors = new ArrayList<>();

        // Check if first name is valid
        if (isNotValidName(firstName)) {
            errors.add("Invalid first name");
        }

        // Check if last name is valid
        if (isNotValidName(lastName)) {
            errors.add("Invalid last name");
        }

        if (!isValidEmail(email)) {
            errors.add("Invalid email format");
        }

        // Check if email is already used by another user
        if (emailAlreadyExists(email)) {
            errors.add("Email already exists");
        }

        // Check password format
        if (!isValidPassword(password)) {
            errors.add("Invalid password format");
        }
        if (!errors.isEmpty()) {
            LOGGER.info("Errors occurred while validating input data: {}", errors);
            throw new UserValidationException();
        }

    }

    // Helper method to validate name format
    private boolean isNotValidName(String name) {
        return name == null || !NAME_PATTERN.matcher(name).matches();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    // Helper method to check if email already exists in repository
    private boolean emailAlreadyExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    // Helper method to validate password format
    private boolean isValidPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }

}
