package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public Product getProduct(Long id) {
		
		Optional<Product> product = productRepo.findById(id);
		return (product.isPresent()) ? product.get() : null;
		
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public boolean updateProduct(Long id, Product product) {
		
		Product dbProduct = productRepo.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
		dbProduct.setName(product.getName());
		dbProduct.setDescription(product.getDescription());
		dbProduct.setPrice(product.getPrice());
		productRepo.save(dbProduct);
		logger.info("product updated and saved successfully");
		return true;
	}

	@Override
	public boolean  deleteProduct(Long id) {
		
		Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		productRepo.delete(product);
		logger.info("product deleted");
		return true;
	}

}
