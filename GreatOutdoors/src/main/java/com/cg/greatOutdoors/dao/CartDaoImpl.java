package com.cg.greatOutdoors.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.greatOutdoors.entity.Cart;
@Repository
public class CartDaoImpl implements CartDao{

	
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		/*Query theQuery=entityManager.createQuery("from Cart");
		
		List<Cart> carts=theQuery.getResultList();
		return carts;*/
		String qStr="SELECT cart FROM Cart cart";
		TypedQuery<Cart> query=em.createQuery(qStr,Cart.class);
		
		return query.getResultList();
		
	}

	@Override
	public Cart findByProductId(long ProductId) {
		// TODO Auto-generated method stub
		Cart cart=em.find(Cart.class, ProductId);
		return cart;
	}

	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		em.persist(cart);
	}

	@Override
	public boolean deleteByProductId(long ProductId) {
		// TODO Auto-generated method stub
		Cart cart=em.find(Cart.class, ProductId);
		if(cart!=null) {
		em.remove(cart);
		return true;}
		return false;
		
	}

}
