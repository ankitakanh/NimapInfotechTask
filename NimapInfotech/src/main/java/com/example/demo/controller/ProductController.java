package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.ProductServices;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductServices productservices;
	
//	add products
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product prod) {
		return productservices.insertProduct(prod);
	}
	
//	get all data 
	@GetMapping("/products")
	public List<Product> getAllData(@RequestParam(defaultValue = "0") int page, 
									@RequestParam(defaultValue = "20") int size){
		return productservices.getAllProducts();
	}
	
//	get products by id
	@GetMapping("/products/{id}")
	public Optional<Product> getById(@PathVariable Long id){
		return productservices.getByIdProduct(id);
	}
	
//	update product
	@PutMapping("/producs")
	public Product updateProduct(@RequestBody Product prod) {
		return productservices.insertProduct(prod);
	}
	
//	delete product 
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productservices.deleteProductById(id);
		return "Product Deleted Successfully!!";
	}

}
