package search;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
  
import search.Item;
   
public class ItemDao {
	 public List<Item> list(String zh) {
	        List<Item> itemList = new ArrayList<Item>();
	        //数据库连接
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = null;
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/system?useSSL=false&serverTimezone=GMT%2B8","root","fcncdn");
	            Statement stmt=conn.createStatement();//创建一个Statement对象
	            String sql="select * from items where item_name like '%"+zh+"%'";//生成sql语句
	            ResultSet rs=stmt.executeQuery(sql);//执行sql语句
	        while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("item_id"));
                item.setname(rs.getString("item_name"));
                //item.seturl(rs.getString("url"));
                item.setPrice(rs.getString("item_price"));
                //item.setcountry(rs.getString("country"));
                item.setHrefPath("/goods_show.jsp?itemId=" + Integer.toString(item.getId()) + "&recommendImage=" + Integer.toString(item.getId()));
                itemList.add(item);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;   
	 }
}
