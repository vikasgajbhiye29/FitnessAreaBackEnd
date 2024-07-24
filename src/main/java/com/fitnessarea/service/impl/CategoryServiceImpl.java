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
	@Override
	public Category createCategory(Category category) {
		Category createCategory = new Category();
		createCategory.setCname(category.getCname());
		createCategory.setCproduct(category.getCproduct());
		Category saveCategory = this.catRepository.save(createCategory);
		return saveCategory;
	}

	@Override
	public Category updateCategory(Category category, int cid) {
		Category newupdate = this.catRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Category ID : " + cid + "Invalid Category ID For Updation"));
		newupdate.setCname(category.getCname());
		newupdate.setCproduct(category.getCproduct());
		Category update = this.catRepository.save(newupdate);
		return update;
	}

	@Override
	public void deleteCategory(int cid) {
		Category find = this.catRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Category ID : " + cid + "Invalid Category ID For Deletion"));
		this.catRepository.delete(find);
		
	}

	@Override
	public Category getCategoryById(int cid) {
		Category find = this.catRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Category ID : " + cid + "Invalid Category ID"));
		return find;
	}

	@Override
	public List<Category> listOfCategory() {
		List<Category> list = this.catRepository.findAll();
		List<Category> listofcat = list.stream().map(cat -> cat).collect(Collectors.toList());
		return listofcat;
	}

}
