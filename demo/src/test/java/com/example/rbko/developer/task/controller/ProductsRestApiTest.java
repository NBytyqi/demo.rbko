package com.example.rbko.developer.task.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.client.RestTemplate;

import com.example.rbko.developer.task.entity.Products;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsRestApiTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void getProductById() {
		ResponseEntity<Products> res = restTemplate.getForEntity("http://localhost:8080/api/products/" + 1,
				Products.class);
		
	assertTrue(res.getStatusCodeValue() == HttpStatus.OK.value(), "Request did not go as expected, because of not getting status 200 as expected!");
	assertTrue(res.getBody().getId().equals((long) 1), "Wrong id!");
	assertTrue(res.getBody().getName().equals("Apple"), "Wrong name!");
	assertTrue(res.getBody().getPrice() == 0.99, "Wrong price!");
	assertTrue(res.getBody().getUnitOfMeasurement().equals("KG"), "Wrong measurement unit!");
	assertTrue(res.getBody().getCategory().getId().equals((long) 1) && res.getBody().getCategory().getCategoryName().equals("Fruit"), "Wrong category!");
	}
	
	@Test
	public void deleteProductByIdTest() {
		ResponseEntity<Products> res = restTemplate.getForEntity("http://localhost:8080/api/products/" + 10,
				Products.class);
	
		assertTrue(res.getBody().getId().equals((long) 10), "Wrong id!");
		assertTrue(res.getBody().getName().equals("Kitchen paper"), "Wrong name!");
		
		restTemplate.delete("http://localhost:8080/api/products/" + 10);
		res = restTemplate.getForEntity("http://localhost:8080/api/products/" + 10,
				Products.class);
		
		assertNull(res.getBody(), "Object is not deleted");
	}
	
	@Test
	public void createProductTest() {
		
		Products products = new Products();
		
		products.setName("Candy" + Calendar.getInstance().getTimeInMillis());
		products.setPrice(1.00);
		products.setQuantity(200);
		products.setUnitOfMeasurement("PCS");
		
		ResponseEntity<Products> res = restTemplate.postForEntity("http://localhost:8080/api/products/", products, Products.class);
		
		Products newProduct = res.getBody();
		assertTrue(newProduct.getName().equals(products.getName()), "Wrong name!");
		assertTrue(newProduct.getPrice() == (products.getPrice()), "Wrong price!");
		assertTrue(newProduct.getUnitOfMeasurement().equals(products.getUnitOfMeasurement()), "Wrong measurement unit!");
	}
	
	@Test
	public void updateProductByIdTest() {
		
		ResponseEntity<Products> res = restTemplate.getForEntity("http://localhost:8080/api/products/" + 2,
				Products.class);
		
		Products products = new Products();
		
		products.setId((long) 2);
		products.setName("Candy");
		products.setPrice(1.00);
		products.setQuantity(200);
		products.setUnitOfMeasurement("PCS");
		products.setCategory(res.getBody().getCategory());
		
		restTemplate.put("http://localhost:8080/api/products/2", products);
		
		res = restTemplate.getForEntity("http://localhost:8080/api/products/" + 2,
				Products.class);
		
		assertTrue(res.getBody().equals(products), "Product has not been updated");		
	}

}
