package login.controller;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/showUserPhotoServlet")
public class show extends HttpServlet {

	 private static final long serialVersionUID = 1L;
	 final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
     final String DB_URL = "jdbc:mysql://localhost:3306/register";
	 final String USER = "root";
	 final String PASS = "zxasqw";
	    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
		
		Connection conn = null;
		HttpSession session =request.getSession();
		try {
    		Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("�������ݿ�");
            String sql = "SELECT photo from items where username=?";//��Ӧ��ѯitem_name ��seller_id
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,String.valueOf(session.getAttribute("username"))); //ͨ���û��ύ������Ʒ���ƺͼ۸��������ݿ⣬���ؽ��
            ResultSet result = statement.executeQuery();
            if(result.next()) {
            	Blob blob = result.getBlob("photo");
            	InputStream input = blob.getBinaryStream(); //��ȡbolb��������
            	
            	 OutputStream output = response.getOutputStream();
            	 output.write(blob.getBytes(1, (int) blob.length()));//��ȡ��ȡ������д��������
                 output.flush();
                 System.out.println("�ɹ���");
            }
            
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}catch(Exception e) {
            // ���� Class.forName ����
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
