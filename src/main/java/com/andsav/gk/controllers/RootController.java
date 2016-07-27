package com.andsav.gk.controllers;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andsav.gk.mail.MailSender;

@RestController
public class RootController {
	
	MailSender sender;
	
	@Autowired
	public RootController(MailSender sender) {
		this.sender = sender;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(path="/")
	public String home() throws MessagingException{
		
		for (int i = 0; i < 2; i++){
			sender.send("savka.and@gmail.com", "Hello", "What's up");
			
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return "Hello, world";
	}

	
}
