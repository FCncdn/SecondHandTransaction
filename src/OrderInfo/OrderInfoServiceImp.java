package OrderInfo;

import Order.entity.Order;
import login.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

    public class OrderInfoServiceImp implements OrderInfoService{
    OrderInfoDao orderinfoDao = new OrderInfoDaoImp();

    public ArrayList<Order> getOrderList(User user){
        try {
            return orderinfoDao.getOrderList(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
