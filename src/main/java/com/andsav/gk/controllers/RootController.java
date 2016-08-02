package com.andsav.gk.controllers;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andsav.gk.dto.SignupForm;

@Controller
public class RootController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);
	
	
	
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signUp(Model model){
				
		model.addAttribute(new SignupForm());
		
		return "sign-up";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.POST)	
	public String signUp(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result){
		
		if(result.hasErrors()){
			LOGGER.info(result.getAllErrors().toString());
			return "sign-up";
		}
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/signin")
	public String signIn(){
		
		return "sign-in";
		
	}
	
	
	
}
