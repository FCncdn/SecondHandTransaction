package model;

import UserManagement.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContactDao {
    private SQLConnection sqlConnection;
    private ResultSet resultSet;
    private Statement statement;

    public ContactDao(){
        ResultSet resultSet = null;
        Statement statement = null;
        sqlConnection = new SQLConnection();
    }

    public ArrayList<String> getContactList(String username){
        ArrayList<String> contactList = new ArrayList<String>();
        String sql = "select * from contact where user = '"+ username +"';";
        statement = sqlConnection.connectSQL();

        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                contactList.add(resultSet.getString("contact"));
            }

            for (int i = 0; i < contactList.size(); i++){
                System.out.println("ContactDao - getContactList;" + contactList.get(i));
            }


        }catch (SQLException se){
            System.out.println("ContactDao - getContactList error:" + se.getMessage());
        }

        sqlConnection.closeSQL(statement);

        return contactList;
    }
}
