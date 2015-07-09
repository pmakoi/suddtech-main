package com.suddtech.easyshop.dao;

import com.suddtech.easyshop.model.User;

public interface UserDao extends GenericDao<User> {
	
	public void createUser(User user);
	public void deleteById(String id);
}
