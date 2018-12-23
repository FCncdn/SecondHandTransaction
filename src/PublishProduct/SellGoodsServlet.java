package fuck;

import java.io.IOException;
import java.sql.*;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
;
/**
 * Servlet implementation class DatabaseAccess
 */
@WebServlet("/DatabaseAccess")
@MultipartConfig(maxFileSize = 16177215)    // 上传的文件最大为16MB
public class SellGoodsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://localhost:3306/ZYweb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    final String USER = "root";
    final String PASS = "qnxxkqqdm12.";
    
    public SellGoodsServlet() {
        super();
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
    	Connection conn = null;
    	InputStream inputStream = null;
    	Part filePart = request.getPart("image");   //getpart（）用于获取上传文件
    	if(filePart!=null) {  //输出文件的一些基本信息
    		System.out.println(filePart.getName());
    		System.out.println(filePart.getSize());
    		System.out.println(filePart.getContentType());
    		
    		inputStream = filePart.getInputStream();  //获取所上传文件的输入流
    	}
    	try {
    		Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("连接数据库");
            String sql = "INSERT INTO items(item_name,item_price,seller_id,itemimage) VALUE(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,price);
            statement.setString(3,"23");
            if(inputStream!=null) {  //如果输入流不为空
            	statement.setBlob(4, inputStream);  
            	 System.out.println("保存文件");
            	
            	int row = statement.executeUpdate(); //executeUpdate 的返回值是一个整数（int），指示受影响的行数（即更新计数）
            	if(row>0) {
            		System.out.println("成功保存文件到数据库");
            	}
            }
            HttpSession session =request.getSession();
            session.setAttribute("itemname",name);//将要发布的商品信息传到getGoodsImage这个servlet中
            session.setAttribute("itemprice",price);
            
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "sellResult.html");//response.sendRedirect("/sellResult.html");
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
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }
}