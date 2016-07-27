package com.andsav.gk.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MailSenderMock implements MailSender {
	
	private final static Logger LOG = LoggerFactory.getLogger(MailSenderMock.class);
	
	@Override
	public void send(String to, String subject, String body){
		LOG.info("Sent mock mail to " + to);
		LOG.info("with subject " + subject);
		LOG.info("Body " + body);
	}
	
}
