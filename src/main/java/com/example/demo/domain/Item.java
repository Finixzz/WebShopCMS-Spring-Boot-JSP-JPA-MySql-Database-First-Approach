package com.example.demo.domain;

import javax.persistence.*;

@Entity(name="item")
@Table(name="item")
public class Item   {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="itemid",nullable=false)
    private int ItemId;

    @Column(name="categoryid",nullable=false)
    private int CategoryId;
    

    @Column(name="sizeid",nullable=false)
    private int SizeId; 
    
    

    @Column(name="name",nullable=false)
    private String Name;

    @Column(name="unitprice",nullable=false)
    private double UnitPrice;

    @Column(name="description")
    private String Description;

    @Column(name="isdiscounted")
    private boolean IsDiscounted;

    @Column(name="discountrate")
    private int DiscountRate;

    public Item(){}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public int getSizeId() {
		return SizeId;
	}

	public void setSizeId(int sizeId) {
		SizeId = sizeId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public boolean isIsDiscounted() {
		return IsDiscounted;
	}

	public void setIsDiscounted(boolean isDiscounted) {
		IsDiscounted = isDiscounted;
	}

	public int getDiscountRate() {
		return DiscountRate;
	}

	public void setDiscountRate(int discountRate) {
		DiscountRate = discountRate;
	}

  
}
