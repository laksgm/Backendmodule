package com.lakshmi.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lakshmi.DAO.CartDAO;
import com.lakshmi.domain.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveCartItem(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		sessionFactory.getCurrentSession().saveOrUpdate(cart);

	}

	public void delete(Integer cartId) {
		Session session = this.sessionFactory.getCurrentSession();
		Cart cart = this.retrievCartItem(cartId);

	}

	public void update(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cart);

	}

	public List<Cart> findByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cart>cartList=session.createQuery("from Cart where email=:email").list();
		return cartList;
	}

	public Cart retrievCartItem(Integer cartId) {
		Session session = this.sessionFactory.getCurrentSession();
		Cart cart = session.load(Cart.class, new Integer(cartId));
		return cart;
	}

}
