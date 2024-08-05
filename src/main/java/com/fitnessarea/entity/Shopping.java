package com.fitnessarea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Shopping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shoppingID;
	
	
}
