package com.cg.greatOutdoors.service;
import java.util.List;


import com.cg.greatOutdoors.entity.Product;
public interface ProductServiceI {
	
	
	public List<Product> getAllProducts();
	
	public int addProduct(Product product);
		
	
	public List<Product> getSearchedProducts(String name);
	
	public boolean deleteProduct(int id);
	
	public List<Product> getCategoryProducts(String name);
	
	public List<Product> getManufacturerProducts(String name);

}
 