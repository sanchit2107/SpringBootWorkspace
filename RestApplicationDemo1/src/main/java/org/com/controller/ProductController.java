package org.com.controller;

import java.util.List;
import java.util.Optional;

import org.com.dao.ProductRepository;
import org.com.error.RecordNotFoundException;
import org.com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepository dao;
	
	@RequestMapping("/allProducts")
	public List<Product> getAllProducts() {
		
		return dao.findAll();
	}
	
	@RequestMapping("/searchProduct/{id}") 
	public Product searchProduct(@PathVariable("id") int pid) {
		
		Optional<Product> findById = dao.findById(pid);
		if(findById.isPresent())
			return findById.get();
		else
			return null;
	}
	
	@RequestMapping("/searchProduct1/{id}") 
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> searchProduct1(@PathVariable("id") int pid) {
		
		Optional<Product> findById = dao.findById(pid);
		try {
		if(findById.isPresent()) {
			Product p = findById.get();
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}
		else
			throw new RecordNotFoundException("Record not found!!");
		}
		catch (Exception e) {
			
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product prd) {
		
		Optional<Product> findPrd = dao.findById(prd.getPrdId());
		if(findPrd.isPresent())
			return null;
		else {
			dao.save(prd);
			return prd;
		}
	}
	
	@PostMapping("/addProduct1")
	public String addProduct1(@RequestBody Product prd) {
		
		Optional<Product> findPrd = dao.findById(prd.getPrdId());
		if(findPrd.isPresent())
			return "Product Already Exists!!";
		else {
			dao.save(prd);
			return "Product Added!!";
		}
	}
	
	@PostMapping("/addProduct2")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Product> saveProduct2(@RequestBody Product prd) {
		
		Optional<Product> findPrd = dao.findById(prd.getPrdId());
		try {
		if(!findPrd.isPresent()) {
			dao.save(prd);
			return new ResponseEntity<Product>(prd,HttpStatus.OK);
		}
		else 
			throw new RecordNotFoundException("Record Already Present!!");
		}
		catch (RecordNotFoundException e) {

			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int pid) {
		
		Optional<Product> findPrd = dao.findById(pid);
		if(findPrd.isPresent()) {
			dao.deleteById(pid);
			return "Product Deleted!!";
		}
			return "Product not exists!!";
	}
	
	
	@PutMapping("/updateProduct/")
	public String updateProduct(@RequestBody Product pd) {
		
		Optional<Product> findPrd = dao.findById(pd.getPrdId());
		if(findPrd.isPresent()) {
			dao.save(pd);
			return "Product Updated!!";
		}
			return "Product not exists!!";
	}
	
	@GetMapping("/countTotal")
	public String totalProduct() {
		
		return "Total Products Available = " + dao.count();
	}

	@GetMapping("/averageCost")
	public String avgCostProduct() {
		
		return "Average Cost of Products Available = " + dao.getAverageCost();
	}
	
	@GetMapping("/minimumCost")
	public String minCostProduct() {
		
		return "Minimum Cost of Products Available = " + dao.getMinCostProduct();
	}
	

}
