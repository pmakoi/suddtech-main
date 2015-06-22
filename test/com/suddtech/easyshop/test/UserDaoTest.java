package com.suddtech.easyshop.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suddtech.easyshop.dao.UserDao;
import com.suddtech.easyshop.model.User;

@ActiveProfiles("test")
@ContextConfiguration(locations = {
		"classpath:com/suddtech/easyshop/config/dao-context.xml",

		"classpath:com/suddtech/easyshop/config/security-context.xml",
		"classpath:com/suddtech/easyshop/test/config/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	@Autowired
	private DataSource dataSource;
	private User user1 = new User("johnwpurcell", "John Purcell", "hellohello",
			"johnpurcell@yh.com", true, "ROLE_USER");
	private User user2 = new User("johnwpurcell1", "John Purcell",
			"hellohello1", "johnpurcell@yh.com", true, "ROLE_USER");
	private User user3 = new User("johnwpurcell2", "John Purcell",
			"hellohello2", "johnpurcell@yh.com", true, "ROLE_USER");
	private User user4 = new User("johnwpurcell3", "John Purcell",
			"hellohello3", "johnpurcell@yh.com", true, "ROLE_USER");

	// @Autowired
	// private User user;
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");

		// userDao = EasyMock.createMock(UserDao.class);
	}

	@Test
	public void TestCreateUser() {
		assertNotNull(userDao);
		assertNotNull("Uesr should not be null", user1);
		
		userDao.create(user1);
		List<User> users = userDao.getList();
		
		assertNotNull("Uesrs List  should not be null", users);
		assertEquals("Number of users shuld be 1", 1, users.size());
		assertEquals(user1, users.get(0));
		
		userDao.create(user2);
		userDao.create(user3);
		userDao.create(user4);
		users = userDao.getList();
		
		assertEquals("Number of users shuld be 4", 4, users.size());

	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
