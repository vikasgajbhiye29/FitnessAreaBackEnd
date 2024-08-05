package com.fitnessarea.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	@NotEmpty(message = "Enter First Name")
	@Size(min = 3, max = 10)
	private String fname;
	@NotEmpty(message = "Enter Last Name")
	private String lname;
	private String username;
	@Email(message = "Enter Valid Email Address")
	@Size(min = 10, max = 50)
	private String email;
	@NotEmpty(message = "Enter Min 4 Char And Max 8 Char")
	@Size(min = 4, max = 8)
	private String password;
	@Enumerated(value = EnumType.STRING)
	private Role role;
//	Address Mapping
	@OneToOne
	@JoinColumn(name = "addressID")
	private Address address;

//	Product Mapping
	@JsonIgnore
	@OneToMany(mappedBy = "productUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Product> userProduct = new ArrayList<>();

//	Setter And Getter
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Product> getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(List<Product> userProduct) {
		this.userProduct = userProduct;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// ToString
	@Override
	public String toString() {
		return "User [userID=" + userID + ", fname=" + fname + ", lname=" + lname + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", role=" + role + ", address=" + address
				+ ", userProduct=" + userProduct + "]";
	}

//	Constructors

}
