package com.cg.greatOutdoors.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatOutdoors.entity.Product;

@Repository

public class ProductDaoImp implements ProductDaoI{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
	String qStr="SELECT product FROM Product product";
		TypedQuery<Product> query=em.createQuery(qStr,Product.class);
		
		return query.getResultList();
	} 

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		
		em.persist(product);
		
		return product.getId();
		
	}

	public int deleteItem(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
			
		Product p=	em.find(Product.class, id);
		if(p!=null) {
			em.remove(p);
			return p.getProductid();
		}else {
			return 0;
		}
		
		
	}
	


public List<Product> searchProduct(String name) {
	// TODO Auto-generated method stub
	
	String qStr="SELECT product FROM Product product where product.productName like '%"+(name)+"%'";
	TypedQuery<Product> query=em.createQuery(qStr,Product.class);
	//query.setParameter("name", name);
	
	return query.getResultList();
}

public List<Product> searchCategoryProduct(String name) {
	// TODO Auto-generated method stub
	String qStr="SELECT product FROM Product product where product.productCategory='"+(name)+"'";
	TypedQuery<Product> query=em.createQuery(qStr,Product.class);
	return query.getResultList();
}
public List<Product> searchManufacturerProduct(String name) {
	// TODO Auto-generated method stub
	
	String qStr="SELECT product FROM Product product where product.productManufacturer like '%"+(name)+"%'";
	TypedQuery<Product> query=em.createQuery(qStr,Product.class);
	//query.setParameter("name", name);
	
	return query.getResultList();
}

}
