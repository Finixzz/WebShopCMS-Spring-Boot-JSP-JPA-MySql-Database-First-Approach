package com.example.demo.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IItemRepository;

@RestController
public class ItemsController {

	@Autowired
	private IItemRepository _itemRepository;
	
	@GetMapping("/api/items/all")
	List<Item> GetAllItems(){
		return _itemRepository.findAll();
	}
	
	
	/// /api/items?categoryId=
	@GetMapping("/api/items")
	List<Item> GetItemsByCategory(@RequestParam(name="categoryId")	Integer categoryId ){
		return _itemRepository.getItemsByCategory(categoryId);
	}
	
	
		
}
