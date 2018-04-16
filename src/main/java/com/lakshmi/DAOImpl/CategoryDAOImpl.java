package com.lakshmi.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lakshmi.DAO.CategoryDAO;
import com.lakshmi.domain.Category;

@Repository(value = "categoryDao")

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addCategory(Category category) {

		sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Category> categoryList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category").list();
		for (Category cat : categoryList) {
			System.out.println("Category List:" + cat);
		}
		return categoryList;
	}

	@Transactional
	public void updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);

	}

	@Transactional
	public void deleteCategory(Integer categoryId) {
		Session session = this.sessionFactory.getCurrentSession();

		Category category=this.getCategory(categoryId);
		/*Category category = session.get(Category.class, categoryId);*/
		session.delete(category);

	}

	@Transactional

	public Category getCategory(Integer categoryId) {
		Session session = this.sessionFactory.getCurrentSession();

		Category category = session.get(Category.class, categoryId);
		return category;
	}

}
