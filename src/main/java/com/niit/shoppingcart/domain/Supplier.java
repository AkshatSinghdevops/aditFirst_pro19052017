package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")  //if the class name and table name is different
@Component
public class Supplier {
	
	@Id
	private String id;
	
	private String name;
	
	private String address;

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@OneToMany(mappedBy="supplier",fetch = FetchType.EAGER)
	private Set<Product> products;

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	

}
