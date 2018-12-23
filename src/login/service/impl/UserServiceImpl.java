package login.service.impl;

import java.sql.SQLException;

import login.dao.UserDao;
import login.dao.impl.UserDaoImpl;
import login.entity.User;
import login.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl(){
	    userDao = new UserDaoImpl();
    }
	
	@Override
	public User userLogin(String username, String password) {
		
		try {
			User user = userDao.login(username, password);
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int userRegister(User user) {
		try {
			return userDao.regist(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
