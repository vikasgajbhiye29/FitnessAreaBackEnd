package com.fitnessarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessarea.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
