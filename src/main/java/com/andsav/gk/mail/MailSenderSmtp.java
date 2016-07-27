package com.andsav.gk.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSenderSmtp implements MailSender {

	private final static Logger LOG = LoggerFactory.getLogger(MailSenderSmtp.class);

	
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body);
		
		
		javaMailSender.send(message);
		
		LOG.info("Message sent to " + to);
	}

}
