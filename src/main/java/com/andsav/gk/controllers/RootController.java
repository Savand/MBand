package com.andsav.gk.controllers;



import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andsav.gk.dto.SignupForm;
import com.andsav.gk.services.BandService;
import com.andsav.gk.utils.MyUtil;
import com.andsav.gk.validators.SignUpFormValidator;

@Controller
public class RootController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);
	
	private BandService service;
	private MailSender mailSender;
	private SignUpFormValidator signUpFormValidator;
	
	@Autowired
	public RootController(BandService service, MailSender mailSender, SignUpFormValidator signUpFormValidator) {
		this.service = service;
		this.mailSender = mailSender;
		this.signUpFormValidator = signUpFormValidator;
	}
	
	@InitBinder("signupForm")
	protected void initSignupBinder(WebDataBinder binder){
		binder.setValidator(signUpFormValidator);
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signUp(Model model){
				
		model.addAttribute(new SignupForm());
		
		return "sign-up";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.POST)	
	public String signUp(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirect){
		
		if(result.hasErrors()){
			LOGGER.info(result.getAllErrors().toString());
			return "sign-up";
		}
		
//		LOGGER.info(signupForm.toString());
		service.signup(signupForm);
		
		MyUtil.flash(redirect, "success", "messageSuccess");
		
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/signin")
	public String signIn(){
		
		return "sign-in";
		
	}
	
	
	
}
