package com.niit.shoppingcart.domain;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="Category")  //if the class name and table name is different
@Component
public class Category {
	
	
	
	//add simple properties - same as Category table
		//generate getter/setter methods
	
	
	
		
		@Id
		private String id;
		
		
		@Column(name="name")  //if the field name and property name is different
		private String Name;
		
		public String getid() {
			return id;
		}

		public void setid(String Id) {
			id = Id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		private String Description;

		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}

	
		  @OneToMany(mappedBy="category",fetch = FetchType.EAGER)	
	    	private Set<Product> products;

	  
		public Set<Product> getProducts() {
			return products;
		}

		public void setProducts(Set<Product> products) {
			this.products = products;
		}
		 
		 
		
		

}
