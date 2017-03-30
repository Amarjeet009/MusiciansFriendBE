package com.amarj.musiciansfriend.testcases;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amarj.musiciansfriend.dao.ProductDAO;
import com.amarj.musiciansfriend.model.Product;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ProductTestCase {
	
	@Autowired
	private static Product product;
	

	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amarj.musiciansfriend");
		context.refresh();
		
		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void saveTestCase()
	{
		product.setId("PR003");
		product.setName("HeadPhone");
		product.setPrice(500);
		product.setDescription("Get the guaranteed lowest prices, largest selection and free shipping of all music accessories");
		product.setCategoryID("CG001");
		product.setSupplierID("SP003");
		
		boolean flag = productDAO.save(product);
		Assert.assertEquals("SaveTestCase",true, flag);
	}

	
	//@Test
	public void deleteTestCase()
	{
		
		boolean flag = productDAO.delete("PR003");
		Assert.assertEquals("SaveTestCase",true, flag);
	}

}
