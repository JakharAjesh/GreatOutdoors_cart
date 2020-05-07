package com.cg.greatOutdoors.controller;

import com.cg.greatOutdoors.entity.Product;
import com.cg.greatOutdoors.exception.ProductNotFoundException;
import com.cg.greatOutdoors.service.ProductServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductDashController {
	
	@Autowired
	ProductServiceImp pService;
	
	 
	@GetMapping("/")
	public String getDashboard() {
		return "Welcome to your dashboard";
	}
	
	
	@GetMapping("/dashboard/Products")
	public List<Product> getProducts() {
		
		List<Product> products=pService.getAllProducts();
		
			if(products.size()==0) {
				throw new ProductNotFoundException("there are not products yet");
			}else {

				return products;
			}
		
	}
	
	@PostMapping("/dashboard/addProduct")
	public ResponseEntity<Integer> addProduct(@RequestBody Product product){
			int pid=pService.addProduct(product);
			if(pid==0) {
				throw new ProductNotFoundException("Could not add the product");
			}else {
				return new ResponseEntity<Integer>(pid,HttpStatus.OK);
	
			}
			
	}
	
	@DeleteMapping("/dashboard/deleteProduct/{id}")
	public boolean deleteProduct(@PathVariable int id) {
			boolean result=pService.deleteProduct(id);
		if(result) {
			return result;
		}else {
			throw new ProductNotFoundException("no product with such id...try with a different one");
		}
			
		
		
	}
	
	
	@GetMapping("/dashboard/searchProducts/{name}")
	public List<Product> SearchProducts(@PathVariable String name) {
		
		List<Product> products=pService.getSearchedProducts(name);
		
			if(products.size()==0) 
			{
				List<Product> categproducts=pService.getCategoryProducts(name);
				if(categproducts.size()==0)
				{
					List<Product> Manufproducts=pService.getManufacturerProducts(name);
					if(Manufproducts.size()==0)
					{
						throw new ProductNotFoundException("no product found");
					}
					else
						return Manufproducts;
				}
				else
					return categproducts;
			}
			else
				return products;
		
	}
	

}
