package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IItemRepository;
import com.example.demo.repository.ISizeRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import com.example.demo.domain.Size;

@Controller
public class HomeController {
	
	@Autowired
	private IItemRepository _itemRepository;
	
	
	@Autowired
	private ICategoryRepository _categoryRepository;
	
	@Autowired
	private ISizeRepository _sizeRepository;
	
	
	
	@GetMapping({"/","/_NavBar"})
	public String loadNavbar() {
		return "redirect:/index";
	}
	
	@GetMapping({"/home","/index"})
	public String showHomePage(Model model) {
		
		List<ItemViewModel> discountedItemsviewModelList=new LinkedList<ItemViewModel>();
		
		List<Item> discountedItems=_itemRepository.getDiscountedItems();
		for(int i=0;i<discountedItems.size();i++) {
			Item item=discountedItems.get(i);
			
			ItemViewModel discountedItemviewModel=new ItemViewModel();
			discountedItemviewModel.setItem(item);
			
			Category category=_categoryRepository.findById(item.getCategoryId()).orElse(null);
			discountedItemviewModel.setCategory(category);
			
			Size size = _sizeRepository.findById(item.getSizeId()).orElse(null);
			discountedItemviewModel.setSize(size);
		
			discountedItemsviewModelList.add(discountedItemviewModel);
		}
	
		
		model.addAttribute("model",discountedItemsviewModelList);		
		return "index";
	}
	
}
