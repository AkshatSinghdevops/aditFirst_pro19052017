package com.niit.shoppingcart.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import junit.framework.Assert;


public class CategoryTestCase {

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		category = (Category) context.getBean("category");

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	// TEST CASES

	@Test
	public void createCategoryTestCase() {
		category.setid("1504");
		category.setName("Childrens Category");
		category.setDescription("All Mans category");

		boolean flag = categoryDAO.save(category);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createCategoryTestCase", true, flag);

	}
}
