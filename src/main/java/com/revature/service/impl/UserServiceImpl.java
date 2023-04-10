package com.revature.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exception.UserException;
import com.revature.model.User;
import com.revature.repository.UserRepo;
import com.revature.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
		return "deleted";
	}

	@Override
	public User updateUser(int userId,User user) throws UserException {
		// TODO Auto-generated method stub
		if(userRepo.findById(userId).isEmpty()) {
			throw new UserException("Requested Id does not exist");
		}
		User user1 = userRepo.findById(userId).get();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
	    userRepo.save(user1);
	    return user1;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.getUserByUsername(username);
	}

}
