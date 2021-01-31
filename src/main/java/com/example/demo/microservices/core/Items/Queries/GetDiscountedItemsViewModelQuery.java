package com.example.demo.microservices.core.Items.Queries;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.IQuery;

public class GetDiscountedItemsViewModelQuery implements IQuery {

	public GetDiscountedItemsViewModelQuery()
	{
		
	}
	@Override
	public <T> T execute(AppDbContext appDbContext) {
		
		List<ItemViewModel> discountedItemsviewModelList=new LinkedList<ItemViewModel>();
		
		List<Item> discountedItems=appDbContext.items.getDiscountedItems();
		for(int i=0;i<discountedItems.size();i++) {
			Item item=discountedItems.get(i);
			
			ItemViewModel discountedItemviewModel=new ItemViewModel();
			discountedItemviewModel.setItem(item);
			
			Category category=appDbContext.categories.findById(item.getCategoryId()).orElse(null);
			discountedItemviewModel.setCategory(category);
			
			Size size = appDbContext.sizes.findById(item.getSizeId()).orElse(null);
			discountedItemviewModel.setSize(size);
		
			discountedItemsviewModelList.add(discountedItemviewModel);
		}
		
		return (T) discountedItemsviewModelList;
	}

}
