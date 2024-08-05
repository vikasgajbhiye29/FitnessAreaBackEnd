package com.fitnessarea.service;

import java.util.List;
import com.fitnessarea.entity.User;

public interface UserService {
// Create User
	User createUser(User user);

//	Update User By Its ID
	User updateUserById(User user, int uid);

// Delete user By Its ID
	void deleteUserById(int uid);

// Getting User Details By Its ID
	User getUserById(int uid);

// List Of All User
	List<User> listOfUser();
}
