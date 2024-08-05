package com.fitnessarea.service;

import com.fitnessarea.entity.Address;

public interface AddressService {

//	Create Address
	Address createAddress(Address address);

//	Update Address By ID
	Address updateAddress(Address address, int addressID);

//	Create Address By UserID
	Address createAddressByUserID(Address address, int userID);

}
