package com.cg.greatOutdoors.service;

import java.util.List;

import com.cg.greatOutdoors.entity.Cart;



public interface CartService {
	
	 public List<Cart> findAll();
		
		public Cart findByProductId(long ProductId);
		
		public void save(Cart theCart);
		
		public boolean deleteByProductId(long ProductId);


}
