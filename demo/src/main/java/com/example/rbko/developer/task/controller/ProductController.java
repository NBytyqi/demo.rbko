package com.example.rbko.developer.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rbko.developer.task.entity.Products;
import com.example.rbko.developer.task.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductsService productService;

	@GetMapping("/")
	public List<Products> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Products getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/filterByQuantity")
	public List<Products> filterProductsByQuantity(@RequestParam int quantity_gt, @RequestParam int quantity_lt) {
		return productService.getFilteredProductsByQuantity(quantity_gt, quantity_lt);
	}
	
	@PostMapping("/")
	public Products createProduct(@RequestBody Products product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public Products updateProduct(@PathVariable Long id, @RequestBody Products product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
	}


}
