package com.suddtech.easyshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suddtech.easyshop.model.User;

@Repository
@Transactional
@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserDaoImpl() {
		setEntityClass(User.class);
	}

	@Transactional
	public void createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		getCurrentSession().save(user);
	}
	public void deleteById(String id) {
		delete(getByID(id));
	}

	

}
