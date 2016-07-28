package com.andsav.gk.controllers;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andsav.gk.mail.MailSenderSmtp;

@RestController
public class RootController {
	
	@Autowired
	MailSenderSmtp sender;
	
	@RequestMapping(path="/sendMail")
	public void home() throws MessagingException{
		sender.send("savka.and@gmail.com", "hello", "how are you?");
		
	}

	
}
