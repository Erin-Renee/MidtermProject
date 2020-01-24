package com.skilldistillery.travelboard.data;

import java.util.List;

import com.skilldistillery.travelboard.entities.User;

public interface DAOUser {

	public User create(User user);
	public boolean delete(int userId);
	public User updateBasicUserInfo(User user, int userId);
	public List<User> read(String name);
	public User login(String userName, String password);
}
