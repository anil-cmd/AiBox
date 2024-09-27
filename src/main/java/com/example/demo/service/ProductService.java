package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Product;



public interface ProductService {
	
	Product getProduct(Long id);
	
	List<Product> getAllProducts();
	
	Product createProduct(Product product);
	
	boolean updateProduct(Long id, Product product);
	
	boolean deleteProduct(Long id);

}
