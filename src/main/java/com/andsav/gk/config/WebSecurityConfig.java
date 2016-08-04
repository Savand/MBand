package com.andsav.gk.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Value("${rememberMe.privateKey}")
	private String rememberMeKey;
	
	@Resource
	private UserDetailsService userDetailsService;
	
	@Bean
	public RememberMeServices rememberMeServices(){
		
		TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices(rememberMeKey, userDetailsService);
		return rememberMeServices;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/",
					"/home",
					"/error",
					"/signup",
					"/forgot-password/*",
					"/public/**").permitAll()
			.anyRequest().authenticated();
					
		http
			.formLogin()
				.loginPage("/signin")
				.permitAll().and()
				.rememberMe().key(rememberMeKey).rememberMeServices(rememberMeServices()).and()
				.logout()
				.permitAll();
			
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
}
