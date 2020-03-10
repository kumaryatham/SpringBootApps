package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WecomController {
	
	@GetMapping("/")
	public String welcomeToSecurit() {
		
		return "Welcome";
	}
	
	@GetMapping("/admin")
	public String welcomeToSecuritAdmin() {
		
		return "Welcome to Admin ";
	}
	
	@GetMapping("/user")
	public String welcomeToSecuritUser() {
		
		return "Welcome to User ";
	}

}
