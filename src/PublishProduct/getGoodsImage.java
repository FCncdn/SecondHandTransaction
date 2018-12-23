package fuck;

import java.io.IOException; 
import java.io.OutputStream; 
import java.net.URLDecoder; 
import java.sql.Blob; 
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class getGoodsImage extends HttpServlet {

	 private static final long serialVersionUID = 1L;
	 final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
     final String DB_URL = "jdbc:mysql://localhost:3306/ZYweb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	 final String USER = "root";
	 final String PASS = "qnxxkqqdm12.";
	    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
		
		Connection conn = null;
		HttpSession session =request.getSession();
		try {
    		Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("连接数据库");
            String sql = "SELECT itemimage from items where item_name=? AND item_price=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,String.valueOf(session.getAttribute("itemname"))); //通过用户提交表单的商品名称和价格搜索数据库，返回结果
            statement.setString(2,String.valueOf(session.getAttribute("itemprice")));//get.Attribute获得的是obj类型，用string.valueof转化为string类型
            ResultSet result = statement.executeQuery();
            System.out.println("查询...");
            if(result.next()) {
            	Blob blob = result.getBlob("itemimage");
            	InputStream input = blob.getBinaryStream(); //获取bolb的输入流
            	
            	 OutputStream output = response.getOutputStream();
            	 output.write(blob.getBytes(1, (int) blob.length()));//获取读取的数据写到返回中
                 output.flush();
                 System.out.println("成功！");
            }
            
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}catch(Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
         }finally {
    		if(conn!=null) {
    			try {
    				conn.close();
    			}catch(SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
}
