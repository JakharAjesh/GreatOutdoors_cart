package com.cg.greatOutdoors.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Carts")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long ProductId;
	private  String ProductName;
	private int ProductQuantity;
	private  double Productcost;
	private String ProductCategory;
	private String ProductManufacturer;
	private String ProductDescription;
	
    
    public Cart() {
    	super();
    }
    
    public Cart(String productName, String productManufacturer, String productCategory, int productQuantity,
			String productDescription, Double productcost) {
		super();
		
		this.ProductName = productName;
		this.ProductQuantity = productQuantity;
		this.Productcost = productcost;
		this.ProductCategory=productCategory;
		this.ProductDescription=productDescription;
		this.ProductCategory=productCategory;
	}
	public long getProductId() {
		return ProductId;
	}
	public void setProductId(long productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	public double getProductcost() {
		return Productcost;
	}
	public void setProductcost(double productcost) {
		Productcost = productcost;
	}

	public String getProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}

	public String getProductManufacturer() {
		return ProductManufacturer;
	}

	public void setProductManufacturer(String productManufacturer) {
		ProductManufacturer = productManufacturer;
	}

	public String getProductDescription() {
		return ProductDescription;
	}

	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}

}
