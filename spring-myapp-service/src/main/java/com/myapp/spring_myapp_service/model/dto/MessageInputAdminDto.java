package com.myapp.spring_myapp_service.model.dto;

public class MessageInputAdminDto {
    private String lang;
    private String messageDifLang;


    public MessageInputAdminDto(String lang, String messageDifLang) {
        this.lang = lang;
        this.messageDifLang = messageDifLang;
    }

    public MessageInputAdminDto() {
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getMessageDifLang() {
        return messageDifLang;
    }

    public void setMessageDifLang(String messageDifLang) {
        this.messageDifLang = messageDifLang;
    }

    @Override
    public String toString() {
        return "MessageInputAdminDto{" +
                "lang='" + lang + '\'' +
                ", messageDifLang='" + messageDifLang + '\'' +
                '}';
    }
}
