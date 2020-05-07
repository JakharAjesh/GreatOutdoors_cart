package com.cg.greatOutdoors.dao;

import java.util.List;

import com.cg.greatOutdoors.entity.Product;

public interface ProductDaoI {
	
	public List<Product> getProducts();
	
	public int insertProduct(Product product);
	
	public int deleteItem(int id);
	
	public List<Product> searchProduct(String name);
	
	public List<Product> searchCategoryProduct(String name);

}
  