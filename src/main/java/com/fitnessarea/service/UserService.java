package com.fitnessarea.service;

import java.util.List;
import com.fitnessarea.entity.User;

public interface UserService {
	
	User createUser(User user);
	
	User updateUserById(User user, int uid);

	void deleteUserById(int uid);

	User getUserById(int uid);

	List<User> listOfUser();
}
