package com.example.demo.microservices.core;

import org.springframework.stereotype.Service;

public interface IBroker {
	
	public <T> T executeAction(IAction action,AppDbContext appDbContext);

			
}
