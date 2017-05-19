package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;


@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Supplier> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean save(Supplier supplier) {
		
		try { 
			
			sessionFactory.getCurrentSession().save(supplier);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
