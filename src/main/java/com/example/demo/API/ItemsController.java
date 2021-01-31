package com.example.demo.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.Broker;
import com.example.demo.microservices.core.IAction;
import com.example.demo.microservices.core.Items.Commands.DeleteItemCommand;
import com.example.demo.microservices.core.Items.Queries.GetAllItemsViewModelQuery;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IItemRepository;

@RestController
public class ItemsController {

	@Autowired
	private AppDbContext _appDbContext;
	
	@Autowired
	private Broker _broker;
	
	
	@GetMapping("/api/items/all")
	List<Item> GetAllItems(){
		IAction query=new GetAllItemsViewModelQuery();
		
		return _broker.executeAction(query, _appDbContext);
	}
	
	
	/// /api/items?categoryId=
	@GetMapping("/api/items")
	List<Item> GetItemsByCategory(@RequestParam(name="categoryId")	Integer categoryId ){
		return _appDbContext.items.getItemsByCategory(categoryId);
	}
	
	
		
}
