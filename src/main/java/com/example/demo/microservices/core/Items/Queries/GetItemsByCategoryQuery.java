package com.example.demo.microservices.core.Items.Queries;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ViewModels.ItemViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.IQuery;

@Service
public class GetItemsByCategoryQuery implements IQuery {

		
	 private int categoryId;
	
	 public GetItemsByCategoryQuery()
	 {
		
	 }
	 
	 public GetItemsByCategoryQuery(int categoryId)
	 {
		this.categoryId=categoryId;
		
	 }
	 
	
	 
	@Override
	public <T> T execute(AppDbContext _appDbContext) {
		List<ItemViewModel> itemsByCategoryViewModel=new LinkedList<ItemViewModel>();
		
		List<Item> itemsByGenderAndCategory=_appDbContext.items.getItemsByCategory(this.categoryId);
		for(int i=0;i<itemsByGenderAndCategory.size();i++) {
			Item item=itemsByGenderAndCategory.get(i);
			
			ItemViewModel itemByCategoryViewModel=new ItemViewModel();
			itemByCategoryViewModel.setItem(item);
			
			Category category=_appDbContext.categories.findById(item.getCategoryId()).orElse(null);
			itemByCategoryViewModel.setCategory(category);
			
			Size size = _appDbContext.sizes.findById(item.getSizeId()).orElse(null);
			itemByCategoryViewModel.setSize(size);
		
			itemsByCategoryViewModel.add(itemByCategoryViewModel);
		}
		
		return (T) itemsByCategoryViewModel;
	}

}
