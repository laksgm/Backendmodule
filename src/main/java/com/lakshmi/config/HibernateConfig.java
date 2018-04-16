package com.lakshmi.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lakshmi.DAO.UserDAO;
import com.lakshmi.DAOImpl.UserDAOImpl;
import com.lakshmi.domain.Product;
import com.lakshmi.domain.User;

@Configuration
@ComponentScan(basePackages = { "com.lakshmi" })
@EnableTransactionManagement
public class HibernateConfig {

	static Logger logger = Logger.getLogger(HibernateConfig.class);

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
/*		System.out.println("Data Source Method");
*/		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mvc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		logger.debug("DataSource created Successfully");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.lakshmi");
		// sessionBuilder.scanPackages("com.niit.GroceryBackendApp");
		return sessionBuilder.buildSessionFactory();
	}

	/*@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return new UserDAO(sessionFactory);
	}*/

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
