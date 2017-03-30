package com.amarj.musiciansfriend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amarj.musiciansfriend.dao.ProductDAO;
import com.amarj.musiciansfriend.model.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Transactional
	public Product get(String id) {
		return sessionFactory.getCurrentSession().get(Product.class,id);
	}

	@Transactional
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getDeleteById(id));
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Product getDeleteById(String id) {
	    return	sessionFactory.getCurrentSession().get(Product.class, id);
	}

}
