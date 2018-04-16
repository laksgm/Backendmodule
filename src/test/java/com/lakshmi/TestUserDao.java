package com.lakshmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lakshmi.DAO.CategoryDAO;
import com.lakshmi.DAO.UserDAO;
import com.lakshmi.config.HibernateConfig;
import com.lakshmi.domain.Category;
import com.lakshmi.domain.User;

public class TestUserDao {
	
	public static void main(String[] args) {
		ApplicationContext c=new AnnotationConfigApplicationContext(HibernateConfig.class);
		CategoryDAO udao=(CategoryDAO)c.getBean("categoryDao");
		
		User u=new User();
		u.setUsername("lakshmi");
		u.setEmail("email2");
		u.setFirstName("lakshmi");
		u.setLastName("gm");
		u.setPassword("password");
		u.setConfirmPassword("onfirmfukingpassword");
		/*udao.registerUser(u);*/
		
		Category category=new Category();
		category.setCategoryName("dcfvgbhj");
		category.setCategoryDescription("dfrgthjk");
		category.setCategoryAddedBy("wert");
		udao.addCategory(category);
		
		
	
		
		
	}

}
