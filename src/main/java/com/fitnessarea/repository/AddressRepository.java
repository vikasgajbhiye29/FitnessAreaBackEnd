package com.fitnessarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessarea.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
