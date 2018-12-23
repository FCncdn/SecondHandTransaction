package model;

import java.sql.*;

public class SQLConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String ADDRESS = "jdbc:mysql://localhost:3306/System?serverTimezone=GMT%2B8";
    private static final String USER = "root";
    private static final String PASS = "fcncdn";

    public Connection connection = null;

    public Statement connectSQL(){
        Statement statement = null;
        try{
            //register
            System.out.println("注册数据库");
            Class.forName(DRIVER);

            //connect
            System.out.println("连接数据库");
            connection = DriverManager.getConnection(ADDRESS, USER, PASS);

            //operate
            System.out.println("实例化Statement对象");
            statement = connection.createStatement();
        }catch (SQLException se){
            //JDBC
            System.out.println("connectSQL:JDBC error - " + se.getMessage());
        }catch (Exception e){
            //Class.forName
            System.out.println("connectSQL:Class error - " + e.getMessage());
        }
        return statement;

    }

    public void closeSQL(Statement statement){
        try{
            if (statement != null)
                statement.close();
        }catch (SQLException se){
            System.out.println("closeSQL:" + se.getMessage());
        }
        try{
            if (connection != null)
                connection.close();
        }catch (SQLException se){
            System.out.println("closeSQL:" + se.getMessage());
        }
    }
}
