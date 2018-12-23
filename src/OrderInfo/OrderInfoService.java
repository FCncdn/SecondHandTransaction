package OrderInfo;

import Order.entity.Order;
import login.entity.User;

import java.util.ArrayList;

public interface OrderInfoService {
    ArrayList<Order> getOrderList(User user);
}
