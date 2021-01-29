package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;
import com.example.demo.repository.ICategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private ICategoryRepository _categoryRepository;
	
	
	@GetMapping({"/categories","/categorylist"})
	public String showCategories(Model model) {
		List<Category> categories=_categoryRepository.findAll();
		model.addAttribute("model",categories);		
		return "categorylist";
	}
	
	
	@GetMapping({"/categories/new","/newcategory"})
	public String addNewCategory(Model model) {
		Category category=new Category();
		model.addAttribute("model",category);
		return "newcategory";
	}
	
	
	@PostMapping({"/categories/save"})
	public String saveNewCategory(@Validated @ModelAttribute("model") Category category,
							      BindingResult result) {
		
		if(result.hasErrors())
			return "redirect:/categories/new";
		
		_categoryRepository.save(category);
		
		return "redirect:/categories";
	}
	
	@GetMapping({"/categories/edit","/editcategory"})
	public String editCategory(@RequestParam(name="categoryId")	Integer categoryId,
							  Model model) {
		Category categoryInDb=_categoryRepository.findById(categoryId).orElse(null);
		model.addAttribute("model",categoryInDb);
		return "editcategory";
	}
	
	@PostMapping({"/categories/edit","/editcategory"})
	public String saveEditedCategory(@Validated @ModelAttribute("model") Category category,
							  Model model) {
		Category categoryInDb=_categoryRepository.findById(category.getCategoryId()).orElse(null);
		
		categoryInDb.setName(category.getName());
		categoryInDb.setGender(category.getGender());
		
		_categoryRepository.flush();
		
		return "redirect:/categories";
	}
	
	@PostMapping({"/categories/delete/{id}","/categories"})
	public String deleteCategory(@PathVariable int id) {
		
		Category categoryInDb=_categoryRepository.findById(id).orElse(null);
		
		_categoryRepository.delete(categoryInDb);
		
		return "redirect:/categories";
	}
	
	
}
