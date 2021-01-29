package com.example.demo.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Category;
import com.example.demo.repository.ICategoryRepository;

@RestController
public class CategoriesController {

	@Autowired
	private ICategoryRepository _categoryRepository;
	
	
	@GetMapping("/api/categories")
	List<Category>GetAllCategories(){
		return _categoryRepository.findAll();
	}
	
	
	
}
