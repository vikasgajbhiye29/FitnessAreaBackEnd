package com.fitnessarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessarea.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
