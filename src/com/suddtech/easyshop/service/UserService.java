package com.suddtech.easyshop.service;

import java.util.List;

import com.suddtech.easyshop.dao.UserDao;
import com.suddtech.easyshop.model.User;

public interface UserService {

	public void setOffersDao(UserDao usersDao);

	public void create(User user);

	public boolean exists(String username);

	public List<User> getAllUsers();

}
