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
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole().USER);
		user = this.userRepository.save(user);
		return user;
	}

//	Update User By Its ID
	@Override
	public User updateUserById(User user, int uid) {
		User newuser = this.userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("UserId : " + uid + " is Not Available For Update"));
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
	public void deleteUserById(int uid) {
		User finduser = this.userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("UserId : " + uid + " is Not Present For Deletion"));
		this.userRepository.delete(finduser);
	}

// Getting User Details By Its ID
	@Override
	public User getUserById(int uid) {
		User userByID = this.userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("UserId : " + uid + " is Not Available"));
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
