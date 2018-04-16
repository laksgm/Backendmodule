package com.lakshmi.DAOImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lakshmi.DAO.SupplierDAO;
import com.lakshmi.domain.Supplier;

@Repository(value = "SupplierDao")

public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addSupplier(Supplier supplier) {

		sessionFactory.getCurrentSession().saveOrUpdate(supplier);

	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Supplier> SupplierList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Supplier> SupplierList = session.createQuery("from Supplier").list();
		for (Supplier cat : SupplierList) {
			System.out.println("Supplier List:" + cat);
		}
		return SupplierList;
	}

	@Transactional
	public void updateSupplier(Supplier supplier) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(supplier);

	}

	@Transactional
	public void deleteSupplier(Integer supplierId) {
		Session session = this.sessionFactory.getCurrentSession();

		Supplier Supplier = this.getSupplier(supplierId);
		/* Supplier Supplier = session.get(Supplier.class, SupplierId); */
		session.delete(Supplier);

	}

	@Transactional

	public Supplier getSupplier(Integer supplierId) {
		Session session = this.sessionFactory.getCurrentSession();

		Supplier Supplier = session.get(Supplier.class, supplierId);
		return Supplier;
	}

}
