package com.example.rbko.developer.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rbko.developer.task.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
