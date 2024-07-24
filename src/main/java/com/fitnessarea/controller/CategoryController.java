package com.fitnessarea.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessarea.entity.Category;
import com.fitnessarea.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService catService;
	@PostMapping("/cc")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		Category cat = this.catService.createCategory(category);
		return new ResponseEntity<Category>(cat, HttpStatus.CREATED);
	}
	@PutMapping("/uc/{cid}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category cat, @PathVariable int cid){
		Category category =  this.catService.updateCategory(cat, cid);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	@DeleteMapping("/dc/{cid}")
	public ResponseEntity<String> deleteCategory(@PathVariable int cid){
		this.catService.deleteCategory(cid);
		return new ResponseEntity<String>("Delete Category Successfully...", HttpStatus.OK);
	}
	@GetMapping("/sc/{cid}")
	public ResponseEntity<Category> getSingleCategory(@PathVariable int cid){
		Category cat = this.catService.getCategoryById(cid);
		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}
	@GetMapping("/cl")
	public ResponseEntity<List<Category>> categoryList(){
		List<Category> list = this.catService.listOfCategory();
		List<Category> listofcat = list.stream().map(cat -> cat).collect(Collectors.toList());
		return new ResponseEntity<List<Category>>(listofcat, HttpStatus.OK);
	}

}
