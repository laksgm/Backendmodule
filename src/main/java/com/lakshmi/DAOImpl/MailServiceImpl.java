/*package com.lakshmi.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lakshmi.DAO.MailService;

@Service

public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void sendEmail(SimpleMailMessage email) {
		mailSender.send(email);
	}
}*/