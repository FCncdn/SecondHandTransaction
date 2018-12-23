package Order.dao;

import java.sql.SQLException;
import Order.entity.Order;

public interface UserDao {
	int createOrder(Order order) throws SQLException;
}
