package com.practice.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.test.model.Product;
import com.practice.test.service.ProductService;
import com.practice.test.service.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	//Instancia de clase
	//ProductService productsService = new ProductServiceImpl(); //Polimorfismo dinámico
	
	@Autowired // inyección de dependencias por campo
	@Qualifier("listResourceService")
	private ProductService productsService; //Composición
	
	@GetMapping
	public ResponseEntity<?> getProducts(){
		List<Product> products = productsService.getProducts();	 //dependencia
		
		return ResponseEntity.ok(products); 
	}
	
}
