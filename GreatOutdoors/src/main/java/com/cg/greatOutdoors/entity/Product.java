package com.cg.greatOutdoors.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ProductData")
public class Product implements Serializable{
 
	@Id
	@GeneratedValue
	private int productid;
	@Column(name="product_name", length=50)
	private String productName;
	
	@Column(name="product_man", length=25)
	private String productManufacturer;
	
	@Column(name="product_cat", length=25)
	private String productCategory;
	

	private int productQuantity;
	
	@Column(name="product_des", length=300)
	private String productDescription;
	
	public String getProductCategory() {
		return productCategory;
	}
	
	@Column(name="product_cost", length=10)
	private Double productcost;
	
	public Product() {
		super();
	}

	
	public Product(String productName, String productManufacturer, String productCategory, int productQuantity,
			String productDescription, Double productcost) {
		super();
		this.productName = productName;
		this.productManufacturer = productManufacturer;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
		this.productDescription = productDescription;
		this.productcost = productcost;
	}
	public int getId() {
		return productid;
	}
	
	public void setId(int id) {
		this.productid = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getProductcost() {
		return productcost;
	}
	public void setProductcost(Double productcost) {
		this.productcost = productcost;
	}
	
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}

