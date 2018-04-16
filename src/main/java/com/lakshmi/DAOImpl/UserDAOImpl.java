package com.lakshmi.DAOImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.lakshmi.DAO.UserDAO;
import com.lakshmi.domain.User;

@Repository(value = "userDao")
public class UserDAOImpl implements UserDAO {
	static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/*@Autowired
	MailService mailService;*/

	@Transactional

	public void registerUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		logger.info("User register successfully, User Details=" + user);

	}

	public boolean isUserExists(String username, String password) {
		return false;
	}

	public void deleteUser(Integer userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(userId));
		if (user != null) {
			session.delete(user);
			logger.info("User deleted successfully, User Details=" + user);
		}

	}

	public User retrievUser(Integer userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = session.load(User.class, new Integer(userId));
		logger.info("User loaded successfully, User details=" + user);
		return user;

	}

	@Transactional
	public List<User> userList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		for (User user : userList) {
			logger.info("User List:" + user);
		}
		return userList;
	}

	public List<User> findByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> emailList = session.createQuery("from User where User.email=?").list();
		return emailList;
	}

	


}
