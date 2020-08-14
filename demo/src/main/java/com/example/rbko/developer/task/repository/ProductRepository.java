package com.example.rbko.developer.task.repository;

import java.util.List;
import com.example.rbko.developer.task.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Products, Long> {
	
	@Query("SELECT p FROM Products p WHERE p.quantity BETWEEN ?1 AND ?2")
	List<Products> getFilteredProductsByQuantity(int quantity_gt, int quantity_lt);
}
