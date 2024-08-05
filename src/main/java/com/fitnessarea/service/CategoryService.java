package com.fitnessarea.service;

import java.util.List;

import com.fitnessarea.entity.Category;

public interface CategoryService {
//	Create Category
	Category createCategory(Category category);

//	Update Category By Its ID
	Category updateCategory(Category category, int cid);

//	Delete Category By Its ID
	void deleteCategory(int cid);

//	Getting Details Of Category By Its ID
	Category getCategoryById(int cid);

//	List Of All Category
	List<Category> listOfCategory();

}
