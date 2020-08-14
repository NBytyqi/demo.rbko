package com.example.rbko.developer.task.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rbko.developer.task.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
	
	@Query("SELECT s FROM Sales s  WHERE s.soldDate BETWEEN ?1 AND ?2 ORDER BY s.unitsSold DESC")
	List<Sales> getMostSoldProductBetweenDates(Date start, Date end);
}
