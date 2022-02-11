package com.zensar.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	// localhost:8080/all
	
	@GetMapping("/all")
	public String hello() {
		return "Hello  !!!";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Hello User !!!!";
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		return "Hello Admin !!!!!";
	}

}
