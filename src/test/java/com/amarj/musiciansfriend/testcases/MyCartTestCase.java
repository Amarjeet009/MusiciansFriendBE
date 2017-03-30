package com.amarj.musiciansfriend.testcases;





import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amarj.musiciansfriend.dao.MyCartDAO;
import com.amarj.musiciansfriend.model.MyCart;

public class MyCartTestCase {

	@Autowired
	private static MyCart myCart;
	
	@Autowired
	private static MyCartDAO myCartDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.amarj.musiciansfriend");
		context.refresh();
		
		myCart = (MyCart) context.getBean("myCart");
		
		myCartDAO = (MyCartDAO) context.getBean("myCartDAO");
		
	}
	
	// TEST CASES
	
	@Test
	public void createCartTestCase(){
		/*myCart.setDateAdded("15/03/2017");
		myCart.setId("100L");
		myCart.setPrice("20300");
		myCart.setProductName("Guitar");
		myCart.setQuantity("2");
		myCart.setStatus("N");
		myCart.setUserID("UR006");*/
	
		
		
		boolean flag = myCartDAO.save(myCart);
		
		Assert.assertEquals(true, flag);
	}
}
