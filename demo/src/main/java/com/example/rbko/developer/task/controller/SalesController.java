package com.example.rbko.developer.task.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rbko.developer.task.entity.Products;
import com.example.rbko.developer.task.entity.Sales;
import com.example.rbko.developer.task.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	SalesService salesService;
	
	@GetMapping("/{id}")
	public Sales getSaleById(@PathVariable Long id) {
		return salesService.getSaleById(id);
	}
	
	@GetMapping("/secondMostSold")
	public Products getSecondMostSoldProduct(@RequestParam String start, @RequestParam String end) {
		return salesService.getSencondMostBetweenDates(new Date(start), new Date(end));
	}
	
	@GetMapping("/")
	public List<Sales> getAllSales() {
		return salesService.getAllSales();
	}
	
	@PostMapping("/") 
	public Sales createNewSale(@RequestBody Sales sale) {
		return salesService.createSale(sale);
	}
}
