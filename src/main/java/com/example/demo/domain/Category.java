package com.example.demo.domain;

import javax.persistence.*;

@Entity(name="category")
@Table(name="category")
public class Category  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="categoryid",nullable=false)
    private int CategoryId;

    @Column(name="name",nullable=false)
    private String Name;
    
    @Column(name="gender",nullable=false)
    private String Gender;

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
    
  
    
    
}
