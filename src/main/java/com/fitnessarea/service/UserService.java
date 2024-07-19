package com.fitnessarea.service;

import java.util.List;
import com.fitnessarea.entity.User;

public interface UserService {
	
	User updateUserById(User user, int uid);

	void deleteUserById(int uid);

	User getUserById(int uid);

	List<User> listOfUser();
}
