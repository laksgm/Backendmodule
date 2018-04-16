package com.lakshmi.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lakshmi.DAO.ProductDAO;
import com.lakshmi.domain.Category;
import com.lakshmi.domain.Product;
@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void saveProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		
	}

	@Transactional
	public List<Product> productList() {
		return sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
		
		
	}

	@Transactional
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		
	}

	@Transactional
	public void deleteProduct(Integer productID) {
		Session session = this.sessionFactory.getCurrentSession();

		Product product=this.getProduct(productID);
		session.delete(product);
		
	}
	@Transactional
	public Product getProduct(Integer productID) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productID);
		return product;
	}

}
