package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;



public interface ProductDAO {
	
	public List<Product> list();

	// create category

	public boolean save(Product product);

	// update category

	public boolean update(Product product);

	// delete category by id

	public boolean delete(String id);

	// delete category by category

	public boolean delete(Product product);

	public Product get(String id);

	public boolean saveOrUpdate(Product product);
	

}
