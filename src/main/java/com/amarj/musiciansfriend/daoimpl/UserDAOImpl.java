package com.amarj.musiciansfriend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amarj.musiciansfriend.dao.UserDAO;
import com.amarj.musiciansfriend.model.User;



@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

    
	@Transactional
	public User getUser(String id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}

    @Transactional
	public boolean save(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
		
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public boolean validate(String userID, String password) {
		String hql = "from User where name ='" + userID + "'  and password='" + password + "'";

		if (sessionFactory.getCurrentSession().createQuery(hql).uniqueResult() == null) {
			
			return false;
			
		}
         
		return true;
	}


     @Transactional
	public boolean delete(String id) {
    	 try {
			sessionFactory.getCurrentSession().delete(deleteUserByID(id));
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		    return false;
		}
	}

    @Transactional
	public User deleteUserByID(String id) {
		
	return sessionFactory.getCurrentSession().get(User.class, id);
	}


	

	
	
	

}
