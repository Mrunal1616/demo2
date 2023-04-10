package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exception.UserException;
import com.revature.model.User;

@Service
public interface UserService {

	public List<User> findAllUsers();

	public User createUser(User user);

	public String deleteUser(int userId);

	public User updateUser(int userId,User user) throws UserException;

	public User findUserByUsername(String username);

}
