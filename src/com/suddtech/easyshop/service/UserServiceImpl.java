package com.suddtech.easyshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.suddtech.easyshop.dao.MessageDao;
import com.suddtech.easyshop.dao.UserDao;
import com.suddtech.easyshop.model.Message;
import com.suddtech.easyshop.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MessageDao messagesDao;

	// @Autowired
	public void setOffersDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void setMessagesDao(MessageDao messagesDao) {
		this.messagesDao = messagesDao;
	}


	public void createUser(User user) {
		userDao.createUser(user);
	}

	public boolean exists(String username) {
		return userDao.exists(username);
	}

	// @Autowired
	public void sendMessage(Message message) {
		messagesDao.saveOrUpdate(message);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return userDao.getList();// .getAllUsers();
	}
}
