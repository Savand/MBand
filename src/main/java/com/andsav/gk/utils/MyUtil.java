package com.andsav.gk.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class MyUtil {

	@Autowired
	public MyUtil(MessageSource messageSource) {
		MyUtil.messageSource = messageSource;
	}
	
	private static MessageSource messageSource;
	
	public static void flash(RedirectAttributes redirect, String flashKind, String messageKey) {
		
		redirect.addFlashAttribute("flashKind", flashKind);
		redirect.addFlashAttribute("flashMessage", getMessage(messageKey));
		
	}

	private static String getMessage(String messageKey, Object...arg) {
		
		return messageSource.getMessage(messageKey, arg, Locale.getDefault());
	}

}
