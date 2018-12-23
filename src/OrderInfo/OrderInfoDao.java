package OrderInfo;

import Order.entity.Order;
import login.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderInfoDao {
    ArrayList<Order> getOrderList(User user) throws SQLException;
}
