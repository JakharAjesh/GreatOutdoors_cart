package com.cg.greatOutdoors.dao;

import java.util.List;

import com.cg.greatOutdoors.entity.Cart;



public interface CartDao {
	  public List<Cart> findAll();
		
		public Cart findByProductId(long ProductId);
		
		public void save(Cart theCart);
		
		public boolean deleteByProductId(long ProductId);

}
