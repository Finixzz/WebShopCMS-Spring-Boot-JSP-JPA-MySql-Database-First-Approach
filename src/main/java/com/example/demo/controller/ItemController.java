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
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IItemRepository;
import com.example.demo.repository.ISizeRepository;

@Controller
public class ItemController {
	
	@Autowired
	private IItemRepository _itemRepository;
	
	
	@Autowired
	private ICategoryRepository _categoryRepository;
	
	@Autowired
	private ISizeRepository _sizeRepository;
	
	
	/// endpoint /items?gender=&categoryId=
	@GetMapping({"/items","/itemsbygenderandcategory"})
	public String showItemsByGenderAndCategory(@RequestParam(name="gender") String gender,
							   				   @RequestParam(name="categoryId") Integer categoryId, 
							   				   Model model) {
		
		List<ItemViewModel> itemsByCategoryViewModel=new LinkedList<ItemViewModel>();
		
		List<Item> itemsByGenderAndCategory=_itemRepository.getItemsByCategory(categoryId);
		for(int i=0;i<itemsByGenderAndCategory.size();i++) {
			Item item=itemsByGenderAndCategory.get(i);
			
			ItemViewModel itemByCategoryViewModel=new ItemViewModel();
			itemByCategoryViewModel.setItem(item);
			
			Category category=_categoryRepository.findById(item.getCategoryId()).orElse(null);
			itemByCategoryViewModel.setCategory(category);
			
			Size size = _sizeRepository.findById(item.getSizeId()).orElse(null);
			itemByCategoryViewModel.setSize(size);
		
			itemsByCategoryViewModel.add(itemByCategoryViewModel);
		}
	
		
		model.addAttribute("model",itemsByCategoryViewModel);		
		return "itemsbygenderandcategory";
	}
	

	@GetMapping({"/items/all","/itemlist"})
	public String showItems(Model model) {
		
		List<ItemViewModel> itemViewModelList=new LinkedList<ItemViewModel>();
		
		List<Item> itemsInDb=_itemRepository.findAll();
		for(int i=0;i<itemsInDb.size();i++) {
			Item item=itemsInDb.get(i);
			
			ItemViewModel itemViewModel=new ItemViewModel();
			itemViewModel.setItem(item);
			
			Category category=_categoryRepository.findById(item.getCategoryId()).orElse(null);
			itemViewModel.setCategory(category);
			
			Size size = _sizeRepository.findById(item.getSizeId()).orElse(null);
			itemViewModel.setSize(size);
		
			itemViewModelList.add(itemViewModel);
		}
	
		
		model.addAttribute("model",itemViewModelList);		
		return "itemlist";
	}
	
	
	@GetMapping({"/items/new","/newitem"})
	public String addNewItem(Model model) {
		
		CreateItemViewModel createItemViewModel=new CreateItemViewModel();
		
		List<Item> itemsInDb=_itemRepository.findAll();
		for(int i=0;i<itemsInDb.size();i++) {

			
			List<Category> categories=_categoryRepository.findAll();
			createItemViewModel.setCategoryList(categories);
			
			List<Size> sizes = _sizeRepository.findAll();
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
		
		_itemRepository.save(item);
		
		return "redirect:/items/all";
	}
	
	@GetMapping({"/items/edit","/edititem"})
	public String editItem(@RequestParam(name="itemId")	Integer itemId,
							  Model model) {
		
		EditItemViewModel editItemViewModel=new EditItemViewModel();

		editItemViewModel.Item=_itemRepository.findById(itemId).orElse(null);
		
		List<Item> itemsInDb=_itemRepository.findAll();
		for(int i=0;i<itemsInDb.size();i++) {

			
			List<Category> categories=_categoryRepository.findAll();
			editItemViewModel.setCategoryList(categories);
			
			List<Size> sizes = _sizeRepository.findAll();
			editItemViewModel.setSizeList(sizes);
			
		
			
		}
		
		
		model.addAttribute("viewModel",editItemViewModel);
		model.addAttribute("model",editItemViewModel.Item);
		return "edititem";
	}
	
	@PostMapping({"/items/edit","/edititem"})
	public String saveEditedItem(@Validated @ModelAttribute("model") Item item,
							  Model model) {
		Item itemInDb=_itemRepository.findById(item.getItemId()).orElse(null);
		
		
		itemInDb.setCategoryId(item.getCategoryId());
		itemInDb.setSizeId(item.getSizeId());
		itemInDb.setName(item.getName());
		itemInDb.setDescription(item.getDescription());
		
		if(item.getDiscountRate()==0)
		{
			itemInDb.setIsDiscounted(false);
			itemInDb.setDiscountRate(0);
		}
		else
		{
			itemInDb.setIsDiscounted(true);
			itemInDb.setDiscountRate(item.getDiscountRate());
		}
		
		_categoryRepository.flush();
		
		return "redirect:/items/all";
	}
	
	
	@PostMapping({"/items/delete/{id}","/items/all"})
	public String deleteCategory(@PathVariable int id) {
		
		Item itemInDb=_itemRepository.findById(id).orElse(null);
		
		_itemRepository.delete(itemInDb);
		
		return "redirect:/items/all";
	}


}
