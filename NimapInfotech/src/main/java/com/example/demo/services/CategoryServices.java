package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServices {
	
	
	@Autowired
	CategoryRepo categoryRepo;
	
//	insert category
	public Category insertCategory(Category cat) {
		return categoryRepo.save(cat);
	}
	
	
//	get all category 
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	
//	get by id
	public Optional<Category> getByIdCategory(Long id) {
		return categoryRepo.findById(id);
	}
	
	
//	delete category
	public void deleteCategoryById(Long id) {
		categoryRepo.deleteById(id);
	}
	
}
