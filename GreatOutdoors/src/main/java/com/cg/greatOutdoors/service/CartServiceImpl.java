package com.cg.greatOutdoors.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatOutdoors.dao.CartDao;
import com.cg.greatOutdoors.entity.Cart;

@Transactional
@Service
public class CartServiceImpl implements CartService {
	
	
    @Autowired
	CartDao cartDao;

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return cartDao.findAll();	
	}

	@Override
	public Cart findByProductId(long ProductId) {
		// TODO Auto-generated method stub
		return cartDao.findByProductId(ProductId);
	}

	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.save(cart);
	}

	@Override
	public boolean deleteByProductId(long ProductId) {
		// TODO Auto-generated method stub
		return cartDao.deleteByProductId(ProductId);
	}

}