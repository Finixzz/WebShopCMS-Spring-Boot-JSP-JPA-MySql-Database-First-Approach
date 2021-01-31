package com.example.demo.ViewModels;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;

public class EditItemViewModel {
	public Item Item;
	public List<Category> CategoryList;
	public List<Size> SizeList;
	public List<Integer> DiscountList= new LinkedList<Integer>();
	
	public EditItemViewModel() {
		
		int discount=5;
		for(int i=0;i<10;i++)
		{
			DiscountList.add(discount);
			discount+=5;
		}
			
	}
	
	public Item getItem() {
		return Item;
	}
	public void setItem(Item item) {
		Item=item;
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
	
	public Category getCategoryById(int categoryId)
	{
		for(int i=0;i<CategoryList.size();i++) 
		{
			if(CategoryList.get(i).getCategoryId()==categoryId)
				return CategoryList.get(i);
		}
			
		return null;
	}
	
	public Size getSizeById(int sizeId)
	{
		for(int i=0;i<SizeList.size();i++)
		{
			if(SizeList.get(i).getSizeId()==sizeId)
				return SizeList.get(i);
		}
		return null;
	}

	public List<Integer> getDiscountList() {
		return DiscountList;
	}

	public void setDiscountList(List<Integer> discountList) {
		DiscountList = discountList;
	}
	
	
	
}
