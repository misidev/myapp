package com.myapp.spring_myapp_service.controller;


import com.myapp.spring_myapp_service.exceptions.HelloNotFoundException;
import com.myapp.spring_myapp_service.model.MessageDifferentLanguage;
import com.myapp.spring_myapp_service.service.AdminInputMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/myapp")
public class MessageDifferentLangController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDifferentLangController.class);

    @Autowired
    AdminInputMessageService adminInputMessageService;

    @GetMapping("/hello")
    public ResponseEntity<List<MessageDifferentLanguage>> getMessageDifferentLanguage(@RequestParam(required = false) String lang) {
        if (lang == null) {
            return ResponseEntity.ok(adminInputMessageService.getMessageDifferentLanguageFromDB());
        }
        List<MessageDifferentLanguage> foundHellos = new ArrayList<>();
        MessageDifferentLanguage messageDifferentLanguage = adminInputMessageService.getMessageByLang(lang);
        if (messageDifferentLanguage != null) {
            foundHellos.add(messageDifferentLanguage);
        }
        if (foundHellos.isEmpty()) {
            throw new HelloNotFoundException();
        }
        return ResponseEntity.ok(foundHellos);
    }


    @PostMapping("/hello")
    public ResponseEntity<String> addMessageDifferentLanguage(@Validated @RequestBody MessageDifferentLanguage messageDifferentLanguage) {
        boolean hasAdded = adminInputMessageService.saveToDB(messageDifferentLanguage);
        if (hasAdded) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

}
