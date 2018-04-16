package com.lakshmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lakshmi.DAO.CategoryDAO;
import com.lakshmi.DAO.UserDAO;
import com.lakshmi.config.HibernateConfig;
import com.lakshmi.domain.User;

public class MailTest {
	
	
	public static void main(String[] args) {
		ApplicationContext c=new AnnotationConfigApplicationContext(HibernateConfig.class);
		UserDAO udao=(UserDAO)c.getBean("userDAO");
	
		User user=new User();
		
	}

}
