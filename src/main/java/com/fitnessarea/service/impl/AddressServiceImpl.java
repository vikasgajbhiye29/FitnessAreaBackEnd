package com.fitnessarea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessarea.entity.Address;
import com.fitnessarea.entity.User;
import com.fitnessarea.exception.ResourceNotFoundException;
import com.fitnessarea.repository.AddressRepository;
import com.fitnessarea.repository.UserRepository;
import com.fitnessarea.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository arepo;
	@Autowired
	private UserRepository urepo;

//	Create Address
	@Override
	public Address createAddress(Address address) {
		Address addAddress = new Address();
		addAddress.setHouseNo(address.getHouseNo());
		addAddress.setStreet(address.getStreet());
		addAddress.setColony(address.getColony());
		addAddress.setCity(address.getCity());
		addAddress.setDistrict(address.getDistrict());
		addAddress.setState(address.getState());
		addAddress.setCountry(address.getCountry());
		addAddress.setPin(address.getPin());
		Address save = this.arepo.save(addAddress);
		return save;
	}

//	Update Address By Its ID
	@Override
	public Address updateAddress(Address address, int addressID) {
		Address updateAddress = this.arepo.findById(addressID).orElseThrow(
				() -> new ResourceNotFoundException("ADDRESS ID : " + addressID + " Invalid Or Not Found "));
		updateAddress.setHouseNo(address.getHouseNo());
		updateAddress.setStreet(address.getStreet());
		updateAddress.setColony(address.getColony());
		updateAddress.setCity(address.getCity());
		updateAddress.setDistrict(address.getDistrict());
		updateAddress.setState(address.getState());
		updateAddress.setCountry(address.getCountry());
		updateAddress.setPin(address.getPin());
		Address update = this.arepo.save(updateAddress);
		return update;
	}

//	Generate Address By UserID
	public Address createAddressByUserID(Address address, int userID) {
		User findUser = this.urepo.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("USER ID : " + userID + " Invalid Or Not Found "));
		Address addAddress = new Address();
		addAddress.setHouseNo(address.getHouseNo());
		addAddress.setStreet(address.getStreet());
		addAddress.setColony(address.getColony());
		addAddress.setCity(address.getCity());
		addAddress.setDistrict(address.getDistrict());
		addAddress.setState(address.getState());
		addAddress.setCountry(address.getCountry());
		addAddress.setPin(address.getPin());
		findUser.setAddress(addAddress);
		Address save = this.arepo.save(addAddress);
		return save;
	}

}
