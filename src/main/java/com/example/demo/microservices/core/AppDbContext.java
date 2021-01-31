package com.example.demo.microservices.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.example.demo.repository.ICategoryRepository;
import com.example.demo.repository.IItemRepository;
import com.example.demo.repository.ISizeRepository;

@Service
public  class  AppDbContext
{
	@Autowired
	public IItemRepository items;
	
	@Autowired 
	public ICategoryRepository categories;
	
	@Autowired
	public ISizeRepository sizes;
	
	
	public AppDbContext()
	{
		
	}
}


