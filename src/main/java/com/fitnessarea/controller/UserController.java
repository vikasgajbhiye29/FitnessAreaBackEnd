package com.fitnessarea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessarea.entity.User;
import com.fitnessarea.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
//	Create User, URL:- http://localhost:8080/cu
	@PostMapping("/cu")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = this.userService.createUser(user);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
//	Update User By Its ID, URL:- http://localhost:8080/uu/enterid
	@PutMapping("/uu/{uid}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int uid){
		User user1 = this.userService.updateUserById(user, uid);
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
//	Delete User By Its ID, URL:- http://localhost:8080/du/enterid
	@DeleteMapping("/du/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable int uid) {
		this.userService.deleteUserById(uid);
		return new ResponseEntity<String>("Delete User Successfully", HttpStatus.OK);
	}
//	Getting User Details By Its ID, URL:- http://localhost:8080/su/enterid
	@GetMapping("/su/{uid}")
	public ResponseEntity<User> getSingleUser(@PathVariable int uid){
		User user =this.userService.getUserById(uid);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
//	Getting List Of All User, URL:- http://localhost:8080/ul
	@GetMapping("/ul")
	public ResponseEntity<List<User>> userList(){
		List<User> userList = this.userService.listOfUser();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
		
}
