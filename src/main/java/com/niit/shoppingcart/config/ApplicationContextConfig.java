package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;
@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	
	
	private final static String DATABASE_URL = "jdbc:h2:~/test";


	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		/*dataSource.setUrl(DATABASE_URL);

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");*/
		
		
		 dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		    dataSource.setUsername("akshat");
		    dataSource.setPassword("akshat");
		    
		    
		    Properties connectionProperties=new  Properties();
		    connectionProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle11gDialect");
		  
		    connectionProperties.setProperty("hibernate.hbm2ddl.auto","create-drop");// connectionProperties.setProperty("hibernate.id.new_generator_mappings","false");
		    dataSource.setConnectionProperties(connectionProperties);
		
		return dataSource;
		
	}
	
	
	/*@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
	    DriverManagerDataSource dataSource = new  DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("hr");
	    dataSource.setPassword("oracle");
	    
	    Properties connectionProperties=new  Properties();
	    connectionProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle11gDialect");
	  
	    connectionProperties.setProperty("hibernate.hbm2ddl.auto","create-drop");// connectionProperties.setProperty("hibernate.id.new_generator_mappings","false");
	    dataSource.setConnectionProperties(connectionProperties);
	    
	    return dataSource;*/

	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		/*properties.put("hibernate.dialect","org.hibernate.dialect.Oracle11gDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		*/
		
		
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		return sessionBuilder.buildSessionFactory();
	}

	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	

}

