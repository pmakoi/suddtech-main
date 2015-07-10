package com.suddtech.easyshop.service;

import java.util.List;

import com.suddtech.easyshop.model.Message;
import com.suddtech.easyshop.model.User;

public interface UserService {

	public void createUser(User user);
	public User getUser(String username);
	public boolean exists(String username);

	public List<User> getAllUsers();
	public void sendMessage(Message message);

}
