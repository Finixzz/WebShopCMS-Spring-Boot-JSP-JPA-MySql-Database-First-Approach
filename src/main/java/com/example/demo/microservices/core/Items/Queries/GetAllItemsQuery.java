package com.example.demo.microservices.core.Items.Queries;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.IQuery;

public class GetAllItemsQuery implements IQuery {

	@Override
	public <T> T execute(AppDbContext appDbContext) {
		
		List<ItemViewModel> itemViewModelList=new LinkedList<ItemViewModel>();
		
		List<Item> itemsInDb=appDbContext.items.findAll();
		for(int i=0;i<itemsInDb.size();i++) {
			Item item=itemsInDb.get(i);
			
			ItemViewModel itemViewModel=new ItemViewModel();
			itemViewModel.setItem(item);
			
			Category category=appDbContext.categories.findById(item.getCategoryId()).orElse(null);
			itemViewModel.setCategory(category);
			
			Size size = appDbContext.sizes.findById(item.getSizeId()).orElse(null);
			itemViewModel.setSize(size);
		
			itemViewModelList.add(itemViewModel);
		}
		
		return (T) itemViewModelList;
	}

}
