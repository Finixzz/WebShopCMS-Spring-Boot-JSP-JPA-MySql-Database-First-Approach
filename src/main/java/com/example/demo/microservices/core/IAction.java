package com.example.demo.microservices.core;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface IAction {

	public <T> T execute(AppDbContext appDbContext);
	
}
