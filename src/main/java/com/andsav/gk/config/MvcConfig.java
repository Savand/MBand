package com.andsav.gk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("greetings");
		registry.addViewController("/signin").setViewName("sign-in");
	}

}
