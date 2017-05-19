package com.niit.shoppingcart.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product = (Product) context.getBean("product");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	@Test
	public void createProductTestCase() {
		
		product.setId("PD01");
		product.setDescription("asa");
		product.setName("mobile");
		product.setPrice("1212");
		product.setSupplier_id("SP01");
		product.setCategory_id("CG19052017");
		
		boolean f = productDAO.save(product);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createProductTestCase", true, f);
		
	}
}
