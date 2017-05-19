package com.niit.shoppingcart.testcase;


import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;



public class UserTestCase {

	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");

		userDAO = (UserDAO) context.getBean("userDAO");

	}
	
	/*@Test
	public void validateTestCase()
	{
		boolean flag=userDAO.validate("001", "sourabh");
		Assert.assertEquals("validateTestCase", true, flag);
	}*/

	//@Test
	//public void getuserdetails(){
		//boolean flag = userDAO.getUser("niit") != null;
	   //Assert.assertEquals("getuserdetails", true, flag);		
	//}
	
	@Test
	public void createCategoryTestCase() {
		user.setId("niit");                   // niit and 123 admin
		                                          // akshat akshat user
		user.setPassword("niit");
		user.setName("niit");
		user.setMail("niit@gmail.com");
		user.setContact("12121212");
		user.setRole("ROLE_ADMIN");

		boolean flag = userDAO.save(user);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createCategoryTestCase", true, flag);

	}
	
	
	
}

	


