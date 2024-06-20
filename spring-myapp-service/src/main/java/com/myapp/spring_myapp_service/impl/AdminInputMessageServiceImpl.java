package com.myapp.spring_myapp_service.impl;


import com.myapp.spring_myapp_service.exceptions.UserValidationException;
import com.myapp.spring_myapp_service.model.MessageDifferentLanguage;
import com.myapp.spring_myapp_service.model.dto.MessageInputAdminDto;
import com.myapp.spring_myapp_service.repository.AdminRepository;
import com.myapp.spring_myapp_service.repository.HelloRepository;
import com.myapp.spring_myapp_service.service.AdminInputMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminInputMessageServiceImpl implements AdminInputMessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminInputMessageServiceImpl.class);

    private final AdminRepository adminRepository;

    public AdminInputMessageServiceImpl(AdminRepository adminRepository) {
        super();
        this.adminRepository = adminRepository;
    }

    static List<MessageDifferentLanguage> hellos = new ArrayList<>();

    public List<MessageDifferentLanguage> getHellos() {
        return hellos;
    }

    @Autowired
    HelloRepository helloRepository;

    public MessageDifferentLanguage getMessageByLang(String lang) {
        return helloRepository.findByLangIgnoreCase(lang);
    }

    public boolean saveToDB(MessageDifferentLanguage messageDifferentLanguage) {
        helloRepository.save(messageDifferentLanguage);
        return true;
    }

    public List<MessageDifferentLanguage> getMessageDifferentLanguageFromDB() {
        return helloRepository.findAll();
    }


    @Override
    public MessageDifferentLanguage save(MessageInputAdminDto messageInputAdminDto) {
        MessageDifferentLanguage messageDifferentLanguage = new MessageDifferentLanguage(null, messageInputAdminDto.getMessageDifLang(), messageInputAdminDto.getLang());

        validateInputData(messageDifferentLanguage);

        return adminRepository.save(messageDifferentLanguage);
    }

    private void validateInputData(MessageDifferentLanguage messageDifferentLanguage) {
        List<String> errors = new ArrayList<>();

        // Check helloDifLang is null
        if (!isValidNotNullMessageDifLang(messageDifferentLanguage.getMessageDifLang())) {
            errors.add("Invalid message - message is required");
        }
        // Check lang is null
        if (!isValidNotNullLang(messageDifferentLanguage.getLang())) {
            errors.add("Invalid language - lang is required");
        }

        if (!isValidNotNumbersOnlyMessageDifLang(messageDifferentLanguage.getMessageDifLang())) {
            errors.add("Invalid message - string message can not contain only numbers");
        }
        // Check lang is null
        if (!isValidNotNumbersOnlyLang(messageDifferentLanguage.getLang())) {
            errors.add("Invalid language - string lang can not contain only numbers");
        }

        if (!errors.isEmpty()) {
            LOGGER.info("Errors occurred while validating input data: {}", errors);
            throw new UserValidationException();
        }

    }

    private boolean isValidNotNullMessageDifLang(String messageDifLang) {
        return messageDifLang != null ;
    }

    private boolean isValidNotNullLang(String lang) {
        return lang != null;
    }

    private boolean isValidNotNumbersOnlyMessageDifLang(String messageDifLang) {
        return !messageDifLang.matches("\\d") ;
    }

    private boolean isValidNotNumbersOnlyLang(String lang) {
        return !lang.matches("\\d");
    }

}
