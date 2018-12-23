package Order.service.impl;

import java.sql.SQLException;

import Order.dao.UserDao;
import Order.dao.impl.UserDaoImpl;
import Order.entity.Order;
import Order.service.UserService;

/**
 * Title: UserServiceImpl.java
 * @date 2018年10月5日 下午4:17:34
 * @author Mr.yang  
 */
public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	public int orderCreation(Order order) {
		try {
			return userDao.createOrder(order);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
