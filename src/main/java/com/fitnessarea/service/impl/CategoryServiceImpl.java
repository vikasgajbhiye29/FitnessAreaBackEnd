package com.fitnessarea.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessarea.entity.Category;
import com.fitnessarea.exception.ResourceNotFoundException;
import com.fitnessarea.repository.CategoryRepository;
import com.fitnessarea.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository catRepository;

//	Create Category
	@Override
	public Category createCategory(Category category) {
		Category createCategory = new Category();
		createCategory.setCategoryName(category.getCategoryName());
		Category saveCategory = this.catRepository.save(createCategory);
		return saveCategory;
	}

//	Update Category By Its ID
	@Override
	public Category updateCategory(Category category, int categoryID) {
		Category newupdate = this.catRepository.findById(categoryID).orElseThrow(
				() -> new ResourceNotFoundException("UPDATE_CATEGORY_ID : " + categoryID + " Invalid Or Not Found "));
		newupdate.setCategoryName(category.getCategoryName());
		Category update = this.catRepository.save(newupdate);
		return update;
	}

//	Delete Category By Its ID
	@Override
	public void deleteCategory(int categoryID) {
		Category find = this.catRepository.findById(categoryID).orElseThrow(
				() -> new ResourceNotFoundException("DELETE_CATEGORY_ID : " + categoryID + " Invalid Or Not Found "));
		this.catRepository.delete(find);

	}

//	Getting Details Of Category By Its ID
	@Override
	public Category getCategoryById(int categoryID) {
		Category find = this.catRepository.findById(categoryID).orElseThrow(
				() -> new ResourceNotFoundException("CATEGORY_ID : " + categoryID + " Invalid Or Not Found "));
		return find;
	}

//	List Of All Category
	@Override
	public List<Category> listOfCategory() {
		List<Category> list = this.catRepository.findAll();
		List<Category> listofcat = list.stream().map(cat -> cat).collect(Collectors.toList());
		return listofcat;
	}

}
