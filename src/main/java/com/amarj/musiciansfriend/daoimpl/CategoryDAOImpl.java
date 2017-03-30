package com.amarj.musiciansfriend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amarj.musiciansfriend.dao.CategoryDAO;
import com.amarj.musiciansfriend.model.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	/*
	 * CategoryDAOImpl c=new CategoryDAOImpl(); to use to call the object we
	 * need the constructor
	 */
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Transactional
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			/*
			 * it will print the error in console- similar to SOP package
			 * ,class, method,line for which place you are calling.
			 * 
			 */
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Category getCategoryByID(String id) {
		
		// select * from Category where id='mobile'
	return sessionFactory.getCurrentSession().get(Category.class,id);
	/*
	 * to fetch the all the record from the table in other two ways.
	 * 
	 * return sessionFactory.getCurrentSession().
	 * createQuery("from Category where id = '"+id+"'")list().get(0); return
	 * sessionFactory.getCurrentSession().
	 * createQuery("from Category where id = '"+id+"'").uniqueResult();
	 */
	}

	@Transactional
	public Category getCategoryByName(String name) {
	return	sessionFactory.getCurrentSession().get(Category.class,name);
	}

}
