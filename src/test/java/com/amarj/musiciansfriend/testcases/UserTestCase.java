/**
 * 
 */
package com.amarj.musiciansfriend.testcases;






import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.amarj.musiciansfriend.dao.UserDAO;
import com.amarj.musiciansfriend.model.User;

import junit.framework.Assert;

/**
 * @author amarj
 *
 */
@SuppressWarnings("deprecation")
public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext  context;
	
	@Autowired
    private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.amarj.musiciansfriend");
		context.refresh();
		
		user= (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void TestCreateUser()
	{
		user.setId("UR004");
		user.setName("Abhishek Singh");
		user.setPassword("abhishek123");
		user.setMail("abhisheks09@gmail.com");
		user.setMobile("9810768829");
		user.setRole("ROLE_USER");
		
		boolean flag=userDAO.save(user);
		
		Assert.assertEquals ("create User test case",true,flag);
	}
	
	@Test
	public void ValidateCredentials()
	{
		boolean flag =userDAO.validate("VinayKumar","vin123");
		
		Assert.assertEquals("Test User validation",true, flag);
	}
	
	@Test
	public void updateUser()
	{
		user.setId("UR003");
		user.setName("Ankit Chaurasia");
		user.setPassword("ankitch123");
		user.setMail("ankitch009@gmail.com");
		user.setMobile("7862392993");
		user.setRole("ROLE_USER");
		
		boolean flag = userDAO.update(user);
		
		Assert.assertEquals(true, flag);
	}
	@Test
	public void deleteUser()
	{
		boolean flag =userDAO.delete("UR004");
		
		Assert.assertEquals(true, flag);
	}
	
	@Test
	public void getAlluser()
	{
		int recordsFromDAO = userDAO.list().size();
		assertEquals("getAllUser",7,recordsFromDAO);
	}
	
	
	
	
}
