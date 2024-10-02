package com.practice.test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FirstController {
	
	@GetMapping("/hello")
	public String HelloWorld () {
		return "Hello";
	}
		
	@GetMapping("/hello/{user}")
	public String GetUser (@PathVariable String user) {
		return "hello " + user;
	}
	
}
