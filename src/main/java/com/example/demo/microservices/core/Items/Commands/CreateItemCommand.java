package com.example.demo.microservices.core.Items.Commands;

import com.example.demo.domain.Item;
import com.example.demo.microservices.core.AppDbContext;
import com.example.demo.microservices.core.ICommand;

public class CreateItemCommand implements ICommand {

	private Item item;
	
	public CreateItemCommand(Item item)
	{
		this.item=item;
	}
	@Override
	public <T> T execute(AppDbContext appDbContext) {
		return (T) appDbContext.items.save(item);
	}

}
