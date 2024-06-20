package com.myapp.spring_myapp_service.service;


import com.myapp.spring_myapp_service.model.MessageDifferentLanguage;
import com.myapp.spring_myapp_service.model.dto.MessageInputAdminDto;

import java.util.List;

public interface AdminInputMessageService {

    MessageDifferentLanguage save(MessageInputAdminDto messageInputAdminDto);

    MessageDifferentLanguage getMessageByLang(String lang);

    boolean saveToDB(MessageDifferentLanguage messageDifferentLanguage);

    List<MessageDifferentLanguage> getMessageDifferentLanguageFromDB();

}
