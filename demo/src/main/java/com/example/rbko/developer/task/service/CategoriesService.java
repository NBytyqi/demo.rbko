package com.example.rbko.developer.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rbko.developer.task.entity.Categories;
import com.example.rbko.developer.task.repository.CategoriesRepository;

@Service
public class CategoriesService {

	@Autowired
	CategoriesRepository categoriesRepository;
	
	/**
	 * Get Category by id
	 * 
	 * @param id - Id of category to be found
	 * @return Categories
	 */
	public Categories getCategoryById(Long id) {
		return categoriesRepository.findById(id).orElse(null);
	}
	
	/**
	 * Get all categories
	 * 
	 * @return List<Categories>
	 */
	public List<Categories> getAllCategories() {
		return categoriesRepository.findAll();
	}
	
	/**
	 * Create new category
	 * 
	 * @param category - Category to be created
	 * @return Categories
	 */
	public Categories createCategory(Categories category) {
		return categoriesRepository.save(category);
	}
	
	/**
	 * 
	 * @param id - Id of the category to be updated
	 * @param category - Category
	 * @return Categories 
	 */
	public Categories updateCategory(Long id, Categories category) {
		Categories existingCategory = categoriesRepository.findById(id).orElse(null);
		existingCategory.setCategoryName(category.getCategoryName());
		return categoriesRepository.save(category);
	}
	
}
