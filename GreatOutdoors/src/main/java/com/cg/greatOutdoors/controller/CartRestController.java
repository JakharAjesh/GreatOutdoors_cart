package com.cg.greatOutdoors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.greatOutdoors.entity.Cart;
import com.cg.greatOutdoors.exception.DeleteIdException;
import com.cg.greatOutdoors.exception.IdNotFoundException;
import com.cg.greatOutdoors.service.CartService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CartRestController {


    @Autowired
    CartService cartService;
    
    
    
    /*********************************************************************
     * Method: finalAll()
     * params:
     * return: findall() of service class
     * Description: This method gets all the data from repository
     ************************************************************************/
    @GetMapping("/carts")
    public List<Cart> finalAll()
    {
    	return cartService.findAll();
    }
    
    
    /*********************************************************************
     * Method: getCart()
     * params: ProductId
     * return: Instance of entity class
     * Description: This method gets the product information based upon its id
     ************************************************************************/
    @GetMapping("/carts/{ProductId}")
    public Cart getCart(@PathVariable long ProductId) {
    	Cart theCart=cartService.findByProductId(ProductId);
    	if(theCart==null)
    	{
    		throw new IdNotFoundException("Id Doesn't Exist");
    	}
    	return theCart;
    }
    
    
    /*********************************************************************
     * Method: addCart()
     * params: instance of cart
     * return: also the instance 
     * Description: This method saves the new product in the repository
     ************************************************************************/
    @PostMapping("/carts")
    public Cart addCart(@RequestBody Cart theCart)
    {
    	
    	cartService.save(theCart);
    	return theCart;
    }
    
    /*********************************************************************
     * Method: deleteCart()
     * params: ProductId
     * return: product id
     * Description: This method deletes a particular product based upon its id
     ************************************************************************/
    @DeleteMapping("/carts/{ProductId}")
    public String deleteCart(@PathVariable long ProductId) {
    	
    	Cart tempCart=cartService.findByProductId(ProductId);
    	if(tempCart==null)
    	{
    		throw new IdNotFoundException("Id Doesn't Exist");
    	}
    	 Boolean status=cartService.deleteByProductId(ProductId);
    	 
    	 if(!status) throw new DeleteIdException("Can't Perform delete Operation");
    	 
    	return "Deleted Product - "+ProductId;
    }
    
    
	

}

