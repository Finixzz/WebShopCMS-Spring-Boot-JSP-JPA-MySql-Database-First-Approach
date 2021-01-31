package com.example.demo.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.Broker;
import com.example.demo.microservices.core.IAction;
import com.example.demo.microservices.core.Items.Queries.GetItemsByCategoryQuery;

@RestController
public class TestController {

	@Autowired
	private AppDbContext _appDbContext;
	
	@Autowired
	private Broker _broker;
	
	
	@GetMapping("/api/test/items")
	List<ItemViewModel> GetItemsByCategory(@RequestParam(name="categoryId")	Integer categoryId ){
		IAction query=new GetItemsByCategoryQuery(categoryId);
		return _broker.executeAction(query,_appDbContext);
	}
	
	
}
