package com.Application.Inventory.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{
	
	@RequestMapping("/mock-api")
	public String mockApi() {
		return "Hello World";
	}
	
	
	
}