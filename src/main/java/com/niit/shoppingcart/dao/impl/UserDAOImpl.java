package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")

public class UserDAOImpl implements UserDAO {

	
private SessionFactory sessionFactory;
	
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	
	
	public List<User> list() {
		return	sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	public User getUser(String id)
	{
		 return  (User)getSession().get(User.class, id);
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return false;
		}
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean validate(String id, String password)
	{
		String hql="from User where id='"+id+"' and password='"+password+"'";
		if(getSession().createQuery(hql).uniqueResult()==null)
		{
			return false;
		}
		return true;
	}
	



		 
				 
	}


