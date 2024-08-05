package com.fitnessarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessarea.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
