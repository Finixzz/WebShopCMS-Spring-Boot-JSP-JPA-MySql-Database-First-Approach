package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ViewModels.CreateItemViewModel;
import com.example.demo.ViewModels.EditItemViewModel;
import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.Broker;
import com.example.demo.microservices.core.IAction;
import com.example.demo.microservices.core.Items.Queries.GetItemsByCategoryViewModelQuery;
import com.example.demo.microservices.core.Items.Commands.CreateItemCommand;
import com.example.demo.microservices.core.Items.Commands.DeleteItemCommand;
import com.example.demo.microservices.core.Items.Commands.EditItemCommand;
import com.example.demo.microservices.core.Items.Queries.GetAllItemsViewModelQuery;

@Controller
public class ItemController {
	

	
	@Autowired
	private AppDbContext _appDbContext;
	
	@Autowired
	private Broker _broker;
	
	
	/// endpoint /items?gender=&categoryId=
	@GetMapping({"/items","/itemsbygenderandcategory"})
	public String showItemsByGenderAndCategory(@RequestParam(name="gender") String gender,
							   				   @RequestParam(name="categoryId") Integer categoryId, 
							   				   Model model) {
		
		IAction query=new GetItemsByCategoryViewModelQuery(categoryId);
		
		List<ItemViewModel> itemsByCategoryViewModel=_broker.executeAction(query,_appDbContext);
		
		model.addAttribute("model",itemsByCategoryViewModel);		
		return "itemsbygenderandcategory";
	}
	

	@GetMapping({"/items/all","/itemlist"})
	public String showItems(Model model) {
		
		IAction query=new GetAllItemsViewModelQuery();

		List<ItemViewModel> itemViewModelList=_broker.executeAction(query,_appDbContext);
		
		
		model.addAttribute("model",itemViewModelList);		
		return "itemlist";
	}
	
	
	@GetMapping({"/items/new","/newitem"})
	public String addNewItem(Model model) {
		
		CreateItemViewModel createItemViewModel=new CreateItemViewModel();
		
		List<Item> itemsInDb=_appDbContext.items.findAll();
		for(int i=0;i<itemsInDb.size();i++) {

			
			List<Category> categories=_appDbContext.categories.findAll();
			createItemViewModel.setCategoryList(categories);
			
			List<Size> sizes = _appDbContext.sizes.findAll();
			createItemViewModel.setSizeList(sizes);
			
		
		}
	
		model.addAttribute("model",new Item());
		
		model.addAttribute("viewModel",createItemViewModel);	
		return "newitem";
	}
	
	@PostMapping({"/items/save"})
	public String saveNewCategory(@Validated @ModelAttribute("model") Item item,
							      BindingResult result) {
		
		if(result.hasErrors())
			return "redirect:/categories/new";
		
		IAction command=new CreateItemCommand(item);
		
		_broker.executeAction(command, _appDbContext);
		
		return "redirect:/items/all";
	}
	
	@GetMapping({"/items/edit","/edititem"})
	public String editItem(@RequestParam(name="itemId")	Integer itemId,
							  Model model) {
		
		EditItemViewModel editItemViewModel=new EditItemViewModel();

		editItemViewModel.Item=_appDbContext.items.findById(itemId).orElse(null);
		
		List<Item> itemsInDb=_appDbContext.items.findAll();
		for(int i=0;i<itemsInDb.size();i++) {

			
			List<Category> categories=_appDbContext.categories.findAll();
			editItemViewModel.setCategoryList(categories);
			
			List<Size> sizes = _appDbContext.sizes.findAll();
			editItemViewModel.setSizeList(sizes);

		}
		
		
		model.addAttribute("viewModel",editItemViewModel);
		model.addAttribute("model",editItemViewModel.Item);
		return "edititem";
	}
	
	@PostMapping({"/items/edit","/edititem"})
	public String saveEditedItem(@Validated @ModelAttribute("model") Item item,
							  Model model) {
		
		IAction command=new EditItemCommand(item);
		
		_broker.executeAction(command, _appDbContext);
		
		return "redirect:/items/all";
	}
	
	
	@PostMapping({"/items/delete/{id}","/items/all"})
	public String deleteCategory(@PathVariable int id) {
		
		IAction command=new DeleteItemCommand(id);
		
		_broker.executeAction(command, _appDbContext);
		
		return "redirect:/items/all";
	}


}
