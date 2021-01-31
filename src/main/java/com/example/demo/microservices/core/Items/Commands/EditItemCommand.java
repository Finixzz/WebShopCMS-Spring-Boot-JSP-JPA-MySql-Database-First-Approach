package com.example.demo.microservices.core.Items.Commands;

import com.example.demo.domain.Item;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.ICommand;

public class EditItemCommand implements ICommand {

	private Item item;
	
	public EditItemCommand(Item item)
	{
		this.item=item;
	}
	
	@Override
	public <T> T execute(AppDbContext appDbContext) {
		
		Item itemInDb=appDbContext.items.findById(item.getItemId()).orElse(null);
		
		
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
		
		appDbContext.items.flush();
		
		return (T)item;
	}

}
