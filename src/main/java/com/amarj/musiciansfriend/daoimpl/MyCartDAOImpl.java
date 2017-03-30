package com.amarj.musiciansfriend.daoimpl;



import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.amarj.musiciansfriend.dao.MyCartDAO;
import com.amarj.musiciansfriend.model.MyCart;



@Repository("myCartDAO")
@Transactional
@EnableTransactionManagement
public class MyCartDAOImpl implements MyCartDAO {

	private static Logger log = LoggerFactory.getLogger(MyCartDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public MyCartDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


  
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	@Transactional
	public List<MyCart> list(String userID) {
    	log.debug("Starting of the method list");
		String hql = "from MyCart where userID=" + "'" + userID + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method list");
		return query.list();
	}


     @Transactional
	public MyCart getCart(long id) {
		return (MyCart) sessionFactory.getCurrentSession().get(MyCart.class, id);
	}


    @Transactional
	public boolean save(MyCart myCart) {
        log.debug("Starting of method save");
		
		myCart.setId(getMaxId());
		try {
			sessionFactory.getCurrentSession().save(myCart);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}


    @Transactional
	public boolean delete(MyCart myCart) {
        myCart.setStatus('X');
		
		return update(myCart);
	}


     @SuppressWarnings("deprecation")
	@Transactional
	private long getMaxId() {
		log.debug("->->Starting of the method getMaxId");

		Long maxID = 100L;
		try {
			String hql = "select max(id) from MyCart";
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			maxID = (Long) query.uniqueResult();
		} catch (Exception e) {
			log.debug("It seems this is first record. setting initial id is 100 :");
			maxID = 100L;
			e.printStackTrace();
		}
		log.debug("Max id :" + maxID);
		return maxID+1;
	}
	


    @Transactional
	public boolean update(MyCart myCart) {
		try {
			sessionFactory.getCurrentSession().update(myCart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}


	@SuppressWarnings("deprecation")
	@Transactional
	public Long getTotalAmount(String userID) {
		log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price*quantity) from MyCart where userID=" + "'" + userID + "' " + "  and status = " + "'N'";
		log.debug("hql" + hql);

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (Long) query.uniqueResult();

	}


	

	
	
}
