package com.niit.shoppingcart.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;

public class SupplierTaseCase {

	

	
	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDAO supplierDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplier = (Supplier) context.getBean("supplier");

		supplierDAO =  (SupplierDAO) context.getBean("supplierDAO");

	}

	// TEST CASES

	@Test
	public void createsupplierTestCase() {
		supplier.setid("SP03");
		supplier.setname("Kumar Sa");
		supplier.setaddress("Rewa ,India");

		boolean f = supplierDAO.save(supplier);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createsupplierTestCase", true, f);
	}
}
