package com.example.rbko.developer.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rbko.developer.task.entity.Categories;
import com.example.rbko.developer.task.service.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoriesService categoriesService;
	
	@GetMapping("/{id}")
	public Categories getCategoryById(@PathVariable Long id) {
		return categoriesService.getCategoryById(id);
	}
	
	@GetMapping("/")
	public List<Categories> getAllCategories() {
		return categoriesService.getAllCategories();
	}
	
	@PostMapping("/")
	public Categories createCategory(Categories category) {
		return categoriesService.createCategory(category);
	}
	
	@PutMapping("/{id}")
	public Categories updateCategory(@PathVariable Long id, @RequestBody Categories category) {
		return categoriesService.updateCategory(id, category);
	}
}
