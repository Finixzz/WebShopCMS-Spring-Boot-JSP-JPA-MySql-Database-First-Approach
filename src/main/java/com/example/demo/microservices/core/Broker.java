package com.example.demo.microservices.core;

import org.springframework.stereotype.Service;

@Service
public class Broker implements IBroker {

	
	@Override
	public <T> T executeAction(IAction action,AppDbContext appDbContext) {
		return action.execute(appDbContext);

	}

	




	
}
