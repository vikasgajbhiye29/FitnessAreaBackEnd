package com.fitnessarea.service;

import java.util.List;

import com.fitnessarea.entity.Category;

public interface CategoryService {
	
	Category createCategory(Category category);
	
	Category updateCategory(Category category, int cid);
	
	void deleteCategory(int cid);
	
	Category getCategoryById(int cid);
	
	List<Category> listOfCategory();

}
