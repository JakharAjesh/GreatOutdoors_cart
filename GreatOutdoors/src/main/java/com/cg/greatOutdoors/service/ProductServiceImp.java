package com.cg.greatOutdoors.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatOutdoors.dao.ProductDaoImp;
import com.cg.greatOutdoors.entity.Product;
@Transactional
@Service
public class ProductServiceImp  implements ProductServiceI{
	
	@Autowired
	ProductDaoImp pDao;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pDao.getProducts();
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		
		 
		return pDao.insertProduct(product);
	}

	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		int check= pDao.deleteItem(id);
		if(check==id) {
			return true;
			
		}else {
			return false;
		}
	}
	
	public List<Product> getSearchedProducts(String name) {
		// TODO Auto-generated method stub
		return pDao.searchProduct(name);
	}
	
	public List<Product> getCategoryProducts(String name) {
		// TODO Auto-generated method stub
	return pDao.searchCategoryProduct(name);
	
	}
	public List<Product> getManufacturerProducts(String name) {
		// TODO Auto-generated method stub
		return pDao.searchManufacturerProduct(name);
	}

}
