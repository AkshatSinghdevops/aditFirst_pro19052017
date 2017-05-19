package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;



@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> list() {
		return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public Product get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
