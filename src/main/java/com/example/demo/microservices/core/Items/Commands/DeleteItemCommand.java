package com.example.demo.microservices.core.Items.Commands;

import com.example.demo.domain.Item;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.ICommand;

public class DeleteItemCommand implements ICommand {
	
	private int itemId;

	public DeleteItemCommand(int itemId) {
		this.itemId=itemId;
	}
	@Override
	public <T> T execute(AppDbContext appDbContext) {
		
		Item itemInDb=appDbContext.items.findById(itemId).orElse(null);
		
		 appDbContext.items.delete(itemInDb);
		 
		 return (T)itemInDb;
	}

}
