package com.suddtech.easyshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	public Session session() {
//		return sessionFactory.getCurrentSession();
//	}
public UserDaoImpl(){
	setEntityClass(User.class);
}
	@Transactional
	public void createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		getSession().save(user);
	}

//	public boolean exists(String username) {
//		Criteria crit = session().createCriteria(User.class);
//		crit.add(Restrictions.idEq(username));
//		User user = (User) crit.uniqueResult();
//		return user != null;
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<User> getAllUsers() {
//		return session().createQuery("from User").list();
//	}

}
