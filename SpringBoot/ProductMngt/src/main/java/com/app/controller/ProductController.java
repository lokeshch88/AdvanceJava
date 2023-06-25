package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	@Autowired
	private ProductService empService;
	
	
	public ProductController() {
		System.out.println("in ctor of "+getClass());
	}
	
	@GetMapping
	public List<Product> productList(){
		System.out.println("in get pod list");
		//Product getproductList = empService.getproductList();
		return empService.getproductList();
		
	}

}
