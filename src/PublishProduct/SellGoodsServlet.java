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
@MultipartConfig(maxFileSize = 16177215)    // �ϴ����ļ����Ϊ16MB
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
    	Part filePart = request.getPart("image");   //getpart�������ڻ�ȡ�ϴ��ļ�
    	if(filePart!=null) {  //����ļ���һЩ������Ϣ
    		System.out.println(filePart.getName());
    		System.out.println(filePart.getSize());
    		System.out.println(filePart.getContentType());
    		
    		inputStream = filePart.getInputStream();  //��ȡ���ϴ��ļ���������
    	}
    	try {
    		Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("�������ݿ�");
            String sql = "INSERT INTO items(item_name,item_price,seller_id,itemimage) VALUE(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,price);
            statement.setString(3,"23");
            if(inputStream!=null) {  //�����������Ϊ��
            	statement.setBlob(4, inputStream);  
            	 System.out.println("�����ļ�");
            	
            	int row = statement.executeUpdate(); //executeUpdate �ķ���ֵ��һ��������int����ָʾ��Ӱ��������������¼�����
            	if(row>0) {
            		System.out.println("�ɹ������ļ������ݿ�");
            	}
            }
            HttpSession session =request.getSession();
            session.setAttribute("itemname",name);//��Ҫ��������Ʒ��Ϣ����getGoodsImage���servlet��
            session.setAttribute("itemprice",price);
            
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "sellResult.html");//response.sendRedirect("/sellResult.html");
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
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }
}