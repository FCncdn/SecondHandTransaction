package OrderInfo;

import Order.entity.Order;
import login.entity.User;
import model.SQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderInfoDaoImp implements OrderInfoDao {
    public ArrayList<Order> getOrderList(User user) throws SQLException {
        SQLConnection sqlConnection = new SQLConnection();
        ResultSet resultSet = null;
        Statement statement = null;

        System.out.println("UserDaoImpl - getOrderList: start");
        ArrayList<Order> order_list = new ArrayList<Order>();
        String sql = "select * from orders where buyer =" + user.getId() + "or seller =" + user.getId() + ";";
        statement =  sqlConnection.connectSQL();
        System.out.println("SQLConnection success");
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String idorders = resultSet.getString("idorders");
                String seller = resultSet.getString("seller");
                String buyer = resultSet.getString("buyer");
                String itemId = resultSet.getString("itemId");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Order order = new Order(idorders, seller, buyer, itemId, phone, address);
                order_list.add(order);
            }
        }catch (SQLException se){
            System.out.println("UserDaoImpl - getOrderList;" + se.getMessage());
        }
        sqlConnection.closeSQL(statement);
        return order_list;
    }
}
