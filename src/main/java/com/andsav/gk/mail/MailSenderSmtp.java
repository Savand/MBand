package com.andsav.gk.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderSmtp {

	private final static Logger LOG = LoggerFactory.getLogger(MailSenderSmtp.class);

	@Autowired
	private JavaMailSender javaMailSender;

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
