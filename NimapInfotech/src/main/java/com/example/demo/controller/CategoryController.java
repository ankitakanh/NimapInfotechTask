package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

import com.example.demo.model.Category;
import com.example.demo.services.CategoryServices;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryController {

	@Autowired
	CategoryServices catservices;
	
//	add category
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category cat) {
		return catservices.insertCategory(cat);
	}
	
	
//	get all data 
	@GetMapping("/categories")
	public List<Category> getAlldata(@RequestParam(defaultValue = "0") int page, 
									@RequestParam(defaultValue = "20") int size){
		return catservices.getAllCategory();
	}
	
//	get category by id
	@GetMapping("/categories/{id}")
	public Optional<Category> getById(@PathVariable Long id) {
		return catservices.getByIdCategory(id);
	}
	
	
//	update category
	@PutMapping("/categories")
	public Category updateCategory(@RequestBody Category cat) {
		return catservices.insertCategory(cat);
	}
	
	
//	delete category
	@DeleteMapping("/categories/{id}")
	public String deleteCategory(@PathVariable Long id) {
		catservices.deleteCategoryById(id);
		
		return "Category Deleted Successfully!!";
	}
}
