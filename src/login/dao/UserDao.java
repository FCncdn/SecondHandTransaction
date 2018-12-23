package login.dao;

import java.sql.SQLException;

import login.entity.User;

public interface UserDao {
	
	/**
	 * 用户登录（需要传入两个参数）
	 * @param username 用户名 
	 * @param password 密码
	 * @return	用户对象
	 * @throws SQLException 
	 */
	User login(String username, String password) throws SQLException;

	/**
	 * 用户注册（传入的是对象）
	 * @param user
	 * @return 整数
	 * @throws SQLException 
	 */
	int regist(User user) throws SQLException;
	
}
