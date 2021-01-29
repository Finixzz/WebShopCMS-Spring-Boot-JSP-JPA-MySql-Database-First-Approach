package com.example.demo.ViewModels;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;

public class CreateItemViewModel {
	public Item NewItem;
	public List<Category> CategoryList;
	public List<Size> SizeList;
	public List<Integer> DiscountList= new LinkedList<Integer>();
	
	public CreateItemViewModel() {
		NewItem=new Item();
		
		int discount=5;
		for(int i=0;i<10;i++)
		{
			DiscountList.add(discount);
			discount+=5;
		}
			
	}
	
	public Item getNewItem() {
		return NewItem;
	}
	public void setNewItem(Item newItem) {
		NewItem = newItem;
	}

	public List<Category> getCategoryList() {
		return CategoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		CategoryList = categoryList;
	}

	public List<Size> getSizeList() {
		return SizeList;
	}

	public void setSizeList(List<Size> sizeList) {
		SizeList = sizeList;
	}
	
	
	
	
	
	
	
}
