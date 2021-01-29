package com.example.demo.ViewModels;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;


public class ItemViewModel {
	private Item Item;
	private Size Size;
	private Category Category;
	
	public Item getItem() {
		return Item;
	}
	
	public ItemViewModel() {
		
	}
	public void setItem(Item item) {
		Item = item;
	}
	public Size getSize() {
		return Size;
	}
	public void setSize(Size size) {
		Size = size;
	}
	public Category getCategory() {
		return Category;
	}
	public void setCategory(Category category) {
		Category = category;
	}
	
	
}
