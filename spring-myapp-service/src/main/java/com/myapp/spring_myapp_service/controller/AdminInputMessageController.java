package com.myapp.spring_myapp_service.controller;

import com.myapp.spring_myapp_service.model.dto.MessageInputAdminDto;
import com.myapp.spring_myapp_service.service.AdminInputMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/myapp/adminMessageInput")
public class AdminInputMessageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminInputMessageController.class);

	private final AdminInputMessageService adminInputMessageService;

	public AdminInputMessageController(AdminInputMessageService adminInputMessageService) {
		super();
		this.adminInputMessageService = adminInputMessageService;
	}

	@ModelAttribute("messageDifferentLanguage")
	public MessageInputAdminDto messageInputAdminDto() {
		return new MessageInputAdminDto();
	}

	@GetMapping
	public String showMessageForm() {
		return "adminInput";
	}

	@PostMapping
	public String inputMessage(@ModelAttribute("MessageDifferentLanguage") MessageInputAdminDto messageInputAdminDto) {
		adminInputMessageService.save(messageInputAdminDto);
		return "redirect:/api/v1/myapp/adminInput?success";
	}
}
