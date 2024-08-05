package com.fitnessarea.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessarea.entity.User;
import com.fitnessarea.exception.ResourceNotFoundException;
import com.fitnessarea.repository.UserRepository;
import com.fitnessarea.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

// Create User	
	@Override
	public User createUser(User request) {
		User user = new User();
		user.setFname(request.getFname());
		user.setLname(request.getLname());
		user.setEmail(request.getEmail());
		user.setUsername(request.getFname() + request.getLname());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole().USER);
		user = this.userRepository.save(user);
		return user;
	}

//	Update User By Its ID
	@Override
	public User updateUserById(User user, int userID) {
		User newuser = this.userRepository.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("USER_ID : " + userID + " Invalid Or Not Found "));
		newuser.setFname(user.getFname());
		newuser.setLname(user.getLname());
		newuser.setEmail(user.getEmail());
		newuser.setUsername(user.getUsername());
		newuser.setPassword(user.getPassword());
		newuser.setRole(user.getRole().USER);
		return this.userRepository.save(newuser);

	}

// Delete user By Its ID
	@Override
	public void deleteUserById(int userID) {
		User finduser = this.userRepository.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("DELETE_USER_ID : " + userID + " Invalid Or Not Found "));
		this.userRepository.delete(finduser);
	}

// Getting User Details By Its ID
	@Override
	public User getUserById(int userID) {
		User userByID = this.userRepository.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("USER_ID : " + userID + " Invalid Or Not Found "));
		return userByID;
	}

// List Of All User
	@Override
	public List<User> listOfUser() {
		List<User> userList = this.userRepository.findAll();
		List<User> list = userList.stream().map(user -> user).collect(Collectors.toList());
		return list;
	}

}
