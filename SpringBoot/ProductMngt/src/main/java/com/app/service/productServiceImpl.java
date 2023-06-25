package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Product;
import com.app.repository.ProductRepository;
@Service
@Transactional
public class productServiceImpl implements ProductService {
	@Autowired
	private ProductRepository prodRep;

	@Override
	public List<Product> getproductList() {
		
		return prodRep.findAll();
	}

}
