package com.myapp.spring_myapp_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "MESSAGE_DIFFERENT_LANGUAGE")
public class MessageDifferentLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "messageDifLang")
	private String messageDifLang;

	@Column(name = "lang")
	private String lang;

	public MessageDifferentLanguage() {

	}

	public MessageDifferentLanguage(Long id, String messageDifLang, String lang) {
		super();
		this.id = id;
		this.messageDifLang = messageDifLang;
		this.lang = lang;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageDifLang() {
		return messageDifLang;
	}

	public void setMessageDifLang(String messageDifLang) {
		this.messageDifLang = messageDifLang;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "MessageDifferentLanguage{" +
				"id=" + id +
				", messageDifLang='" + messageDifLang + '\'' +
				", lang='" + lang + '\'' +
				'}';
	}
}
