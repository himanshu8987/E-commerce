package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.ProductEntity;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	//@GetMapping("/products")
	@RequestMapping(value="/getProducts", method = RequestMethod.GET)
	public List<ProductEntity> getProducts(){
		System.out.println("Get producct list");
		List<ProductEntity> products = productService.getProducts();
		if(products.isEmpty()) {
			System.out.println("Products do not exist");
		}
		return products;
	}
	
	@RequestMapping(value="/addProduct",method = RequestMethod.POST)
	public ProductEntity addProduct(@RequestBody Product product){
		ProductEntity prd = productService.addProduct(product);
		if(prd !=null) {
			System.out.println("Product Added");
		}else {
			System.out.println("Product Not Added");
		}
		return prd;	
	}
	
	@RequestMapping(value="/updateProduct",method = RequestMethod.PUT)
	public ProductEntity updateProduct(@RequestBody Product product){
		ProductEntity prd = productService.updateProduct(product);
		if(prd !=null) {
			System.out.println("Product updated");
		}else {
			System.out.println("Product Not updated");
		}
		return prd;	
		
	}
	

	@RequestMapping(value="/deleteProduct",method = RequestMethod.DELETE)
	public String deleteProduct(@RequestParam Integer productId){
		productService.deleteProduct(productId);
		
		System.out.println("Product Deleted");
		
		
		return "Product Deleted";	
	}
	

}
