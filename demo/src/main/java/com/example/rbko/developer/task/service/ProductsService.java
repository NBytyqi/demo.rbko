package com.example.rbko.developer.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rbko.developer.task.entity.Products;
import com.example.rbko.developer.task.repository.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Get a product by id
	 * 
	 * @param id - Id of product to be found
	 * @return Products
	 */
	public Products getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	/**
	 * Get all products
	 * 
	 * @return List<Products>
	 */
	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}
	
	/**
	 * Filter products based on minimum and maximum quantity
	 * 
	 * @param quantity_min - minimum quantity 
	 * @param quantity_max - maximum quantity
	 * @return
	 */
	public List<Products> getFilteredProductsByQuantity(int quantity_min, int quantity_max) {
		return productRepository.getFilteredProductsByQuantity(quantity_min, quantity_max);
	}
	
	/**
	 * Create new product
	 * 
	 * @param product - Product to be created
	 * @return Products
	 */
	public Products createProduct(Products product) {
		return productRepository.save(product);
	}

	/**
	 * Update product
	 * 
	 * @param id - Id of product to be updated 
	 * @param product - Product
	 * @return Products
	 */
	public Products updateProduct(Long id, Products product) {
		Products existingProduct = productRepository.findById(id).orElse(null);
		
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setUnitOfMeasurement(product.getUnitOfMeasurement());
		existingProduct.setCategory(existingProduct.getCategory());
		
		return productRepository.save(existingProduct);
	}
	
	/**
	 * Delete product by id
	 * 
	 * @param id - Id of the product to be deleted
	 * @return
	 */
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	

	
}
