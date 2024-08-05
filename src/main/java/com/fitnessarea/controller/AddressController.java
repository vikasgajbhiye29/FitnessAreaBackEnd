package com.fitnessarea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessarea.entity.Address;
import com.fitnessarea.service.AddressService;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;

//	Create Address 
//	URL:- http://localhost:8080/generate-address
	@PostMapping("/generate-address")
	public ResponseEntity<Address> generateAddress(@RequestBody Address address) {
		Address generate = this.addressService.createAddress(address);
		return new ResponseEntity<Address>(generate, HttpStatus.OK);
	}

//	Update Address By Its ID 
//	URL:- http://localhost:8080//update-address/addressID
	@PutMapping("/update-address/{addressID}")
	public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable int addressID) {
		Address update = this.addressService.updateAddress(address, addressID);
		return new ResponseEntity<Address>(update, HttpStatus.OK);

	}

//	Create Address By UserID 
//	URL:- http://localhost:8080/cabuID/userID
	@PostMapping("/cabuID/{userID}")
	public ResponseEntity<Address> createAddressInUserByUserID(@RequestBody Address address, @PathVariable int userID) {
		Address add = this.addressService.createAddressByUserID(address, userID);
		return new ResponseEntity<Address>(add, HttpStatus.OK);
	}

}
