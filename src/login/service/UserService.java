package login.service;

import login.entity.User;

public interface UserService {

	/**
	 * 用户登录（传入两个参数，用户名和密码）
	 * @param username
	 * @param password
	 * @return 用户对象
	 */
	User userLogin(String username, String password);

	/**
	 * 用户注册（传入的是对象）
	 * @param user
	 * @return 影响的行数
	 */
	int userRegister(User user);
	
	
	
}
