package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;



public interface SupplierDAO {
	
	
	public List<Supplier> list();

	// create category

	public boolean save(Supplier supplier);

	// update category

	public boolean update(Supplier supplier);

	// delete category by id

	public boolean delete(String id);

	// delete category by category

	public boolean delete(Supplier supplier);

	public Supplier get(String id);

}
