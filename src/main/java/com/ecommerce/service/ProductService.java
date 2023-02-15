package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.ProductEntity;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

//service class is used for writing business logic
@Service
public class ProductService {
	
	@Autowired
	ProductRepository prodRepository;
	

	public ProductEntity addProduct(Product product) {
		if(product != null && !product.getProductName().isEmpty()) {
			
			ProductEntity prdEntity = new ProductEntity();
			prdEntity.setProductName(product.getProductName());
			prdEntity.setPrice(product.getPrice());
			prdEntity.setQuantity(product.getQuantity());
			
			ProductEntity prd = prodRepository.save(prdEntity);
			return prd;
		}
		return null;
	}


	public List<ProductEntity> getProducts(){
		return prodRepository.findAll();
	}


	public ProductEntity updateProduct(Product product) {
		if(product != null && !product.getProductName().isEmpty()) {
			Optional<ProductEntity> prd = prodRepository.findById(product.getProductId());
			if(prd.isPresent()) {
				ProductEntity prdEntity = new ProductEntity();
				prdEntity.setProductId(product.getProductId());
				prdEntity.setProductName(product.getProductName());
				prdEntity.setPrice(product.getPrice());
				prdEntity.setQuantity(product.getQuantity());
				
				return prodRepository.save(prdEntity);
			}
			
		}
		return null;
	}


	public void deleteProduct(Integer productId) {
		if(productId !=0) {
			prodRepository.deleteById(productId);
		}
	}

}
