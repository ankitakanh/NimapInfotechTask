package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductsRepo;

@Service
public class ProductServices {
	
	@Autowired
	ProductsRepo productsRepo;
	
//	insert products
	public Product insertProduct(Product prod) {
		return productsRepo.save(prod);
	}
	
//	get all products
	public List<Product> getAllProducts(){
		return productsRepo.findAll();
	}
	
//	get by id
	public Optional<Product> getByIdProduct(Long id){
		return productsRepo.findById(id);
	}
	
//	delete product
	public void deleteProductById(Long id) {
		productsRepo.deleteById(id);
	}
	
}
