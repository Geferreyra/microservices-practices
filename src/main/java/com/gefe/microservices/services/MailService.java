package com.gefe.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEMail(String to,String subject,String text) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("ge.ferreyra@outlook.com");
		
		message.setTo(to);
		
		message.setSubject(subject);
		
		message.setText(text);
		
		mailSender.send(message);
		
	}
}
