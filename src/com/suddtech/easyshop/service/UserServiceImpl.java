package com.suddtech.easyshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.suddtech.easyshop.dao.MessageDao;
import com.suddtech.easyshop.dao.UserDao;
import com.suddtech.easyshop.model.Message;
import com.suddtech.easyshop.model.User;

@Service("usersService")
public class UserServiceImpl implements UserService {
	@Autowired	
private UserDao usersDao;
	@Autowired
private MessageDao messagesDao;
	
	//@Autowired
	public void setOffersDao(UserDao usersDao) {
		this.usersDao = usersDao;
	}

	
	public void create(User user) {
		usersDao.create(user);
	}


	public boolean exists(String username) {
		return usersDao.exists(username);
	}
	//@Autowired
	public void sendMessage(Message message) {
		messagesDao.saveOrUpdate(message);
	}
	

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getList();//.getAllUsers();
	}
}
