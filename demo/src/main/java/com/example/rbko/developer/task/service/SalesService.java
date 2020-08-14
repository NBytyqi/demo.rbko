package com.example.rbko.developer.task.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rbko.developer.task.entity.Products;
import com.example.rbko.developer.task.entity.Sales;
import com.example.rbko.developer.task.repository.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	SalesRepository salesRepository;
	
	/**
	 * Get Sale by id
	 * 
	 * @param id - Id of sale to be found
	 * @return Sales
	 */
	public Sales getSaleById(Long id) {
		return salesRepository.findById(id).orElse(null);
	}
	
	/**
	 * Get all sales
	 * 
	 * @return List<Sales>
	 */
	public List<Sales> getAllSales() {
		return salesRepository.findAll();
	}
	
	/**
	 * Create new sale
	 * 
	 * @param sale - Sales to be created
	 * @return Sales
	 */
	public Sales createSale(Sales sale) {
		return salesRepository.save(sale);
	}	
	
	/**
	 * Get second most sold product between dates
	 * 
	 * @param start date
	 * @param end date
	 * @return Products
	 */
	public Products getSencondMostBetweenDates(Date start, Date end) {
		return (salesRepository.getMostSoldProductBetweenDates(start, end).get(1)).getProduct();
	}
}
