package fuck;
import java.sql.*;
public class BaseDao {
    private static String driver="com.mysql.cj.jdbc.Driver\"";
    private static String url="jdbc:mysql://localhost:3306/fuck?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static String user="root";
    private static String password="qnxxkqqdm12.";
        static {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);    
    }
    
    public static void closeAll(Connection conn,Statement stmt,ResultSet rs) throws SQLException {
        if(rs!=null) {
            rs.close();
        }
        if(stmt!=null) {
            stmt.close();
        }
        if(conn!=null) {
            conn.close();
        }
    }
    

    public int executeSQL(String preparedSql, Object[] param) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        /* ����SQL,ִ��SQL */
        try {
            conn = getConnection(); // �õ����ݿ�����
            pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
                }
            }
        ResultSet num = pstmt.executeQuery(); // ִ��SQL���
        } catch (SQLException e) {
            e.printStackTrace(); // ����SQLException�쳣
        } finally {
            try {
                BaseDao.closeAll(conn, pstmt, null);
            } catch (SQLException e) {    
                e.printStackTrace();
            }
        }
        return 0;
    }
    
}