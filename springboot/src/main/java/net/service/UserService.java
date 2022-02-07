package net.service;


import java.util.List;

import net.model.User;

public interface UserService {
	
	String saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user,long id);
	void deleteUser(long id);

}
