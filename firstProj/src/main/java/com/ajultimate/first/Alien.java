package com.ajultimate.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	@Autowired
	Laptop lap;
	
	public void code()
	{
		lap.compile();
		System.out.println("I am coding");
		System.out.println("I am coding");
	}
}
