package com.andsav.gk.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	@RequestMapping("/signup")
	public String signUp(){
		return "sign-up";
	}
	
	@RequestMapping("/signin")
	public String signIn(){
		return "sign-in";
	}
	
	
	
}
