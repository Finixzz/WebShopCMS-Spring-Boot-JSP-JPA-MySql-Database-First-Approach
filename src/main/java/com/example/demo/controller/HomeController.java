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
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.Broker;
import com.example.demo.microservices.core.IAction;
import com.example.demo.microservices.core.Items.Queries.GetDiscountedItemsViewModelQuery;

@Controller
public class HomeController {
	
	@Autowired
	private AppDbContext _appDbContext;
	
	@Autowired
	private Broker _broker;
	
	
	
	
	@GetMapping({"/","/_NavBar"})
	public String loadNavbar() {
		return "redirect:/index";
	}
	
	@GetMapping({"/home","/index"})
	public String showHomePage(Model model) {
		
		IAction query=new GetDiscountedItemsViewModelQuery();
		
		List<ItemViewModel> discountedItemsviewModelList=_broker.executeAction(query, _appDbContext);
		
		model.addAttribute("model",discountedItemsviewModelList);		
		return "index";
	}
	
}
