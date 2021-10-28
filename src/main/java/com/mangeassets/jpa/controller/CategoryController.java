package com.mangeassets.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mangeassets.jpa.dto.CategoryRequest;
import com.mangeassets.jpa.model.Category;
import com.mangeassets.jpa.repository.CategoryRepository;

@RestController
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody CategoryRequest request) {
		return categoryRepository.save(request.getCategory());
	}
	@GetMapping("/categories")
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
	
	@PutMapping("/categories/{id}")
	public Category updateCategory(@RequestBody CategoryRequest request,@PathVariable int id) {
		Category cat = categoryRepository.findById(id).get();
		if(null == cat) {
			return categoryRepository.save(request.getCategory());
		}
		cat.setId(id);
		cat.setName(request.getCategory().getName());
		cat.setDescription(request.getCategory().getDescription());
		return categoryRepository.save(cat);
	}
	
}
