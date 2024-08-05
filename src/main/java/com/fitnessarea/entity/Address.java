package com.fitnessarea.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userAddressID;
	private String houseNo;
	@NotEmpty(message = "Enter Street")
	private String street;
	@NotEmpty(message = "Enter Street")
	private String colony;
	@NotEmpty(message = "Enter City or Village")
	private String city;
	@NotEmpty(message = "District")
	private String district;
	@NotEmpty(message = "Enter State")
	private String state;
	@NotEmpty(message = "Enter Country")
	private String country;
	@NotEmpty(message = "Enter PIN")
	private long pin;
//	User Mapping
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	
	
//	Setter and Getter
	public int getUserAddressID() {
		return userAddressID;
	}
	public void setUserAddressID(int userAddressID) {
		this.userAddressID = userAddressID;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	
//	ToString
	@Override
	public String toString() {
		return "Address [userAddressID=" + userAddressID + ", houseNo=" + houseNo + ", street=" + street + ", colony="
				+ colony + ", city=" + city + ", district=" + district + ", state=" + state + ", country=" + country
				+ ", pin=" + pin + "]";
	}
	

	

	

}
