package Order.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Order.dao.UserDao;
import Order.entity.Order;
import Order.entity.Item;
import Order.util.DBCPUtils;


public class UserDaoImpl implements UserDao {

	QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());

	public int createOrder(Order order) throws SQLException{
	    System.out.println("UserDaoImpl - createOrder: start");
		Item item1 = new Item();
		item1 = queryRunner.query(
				"select * from items where item_id=?",
				new BeanHandler<Item>(Item.class), order.getItem());
		
		queryRunner.update("update items set item_status=? where item_id=?",
				"0",
				order.getItem()				
				);

		//修改订单id
		return queryRunner.update("insert into orders(itemId,seller,buyer,address,phone)values(?,?,?,?,?)",
				order.getItem(),
				order.getSeller(),
				order.getBuyer(),
				order.getAddress(),
				order.getPhone()
		);
	}

}
