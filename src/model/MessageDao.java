package model;

import MessageManagement.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MessageDao {
    private String sender;
    private String receiver;
    private String date;
    //Date test
    private java.util.Date date_test;
    private String content;
    private SQLConnection sqlConnection;
    private ResultSet resultSet = null;
    private Statement statement = null;

    public MessageDao(){
        sqlConnection = new SQLConnection();
        sender = null;
        receiver = null;
        content = null;
    }

    public String getSender() {
        //change
        String sql = "select sender, receiver, content from message;";

        statement =  sqlConnection.connectSQL();
        System.out.println("SQLConnection success");
        try{
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            sender = resultSet.getString("sender");
            System.out.println("MessageDao - getSender;" + sender);
        }catch (SQLException se){
            System.out.println("MessageDao - getSender;;" + se.getMessage());
        }
        sqlConnection.closeSQL(statement);
        return sender;
    }

    public String getReceiver() {
        String sql = "select sender, receiver, content from message";

        statement =  sqlConnection.connectSQL();
        try{
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            receiver = resultSet.getString("receiver");
            System.out.println("MessageDao - getSender;" + receiver);
        }catch (SQLException se){
            System.out.println("MessageDao - getReceiver:" + se.getMessage());
        }
        sqlConnection.closeSQL(statement);

        return receiver;
    }

    public String getContent() {
        String sql = "select sender, receiver, content, from message";

        statement = sqlConnection.connectSQL();
        try {
            resultSet = statement.getResultSet();
            resultSet.next();
            content = resultSet.getString("content");
            System.out.println("MessageDao - getContent:" + content);
        }catch (SQLException se){
            System.out.println("MessageDao - getContent:" + se.getMessage());
        }
        sqlConnection.closeSQL(statement);
        return content;
    }

    public boolean insertRecord(String sender, String receiver, String content, String messageType, String dialogueID){
        //sql operation
        String sql = "insert into message (sender,receiver,isread,content,type,dialogueId) " +
                "value(\"" + sender +"\",\"" + receiver +"\",0,\"" + content + "\", \"" + messageType + "\", \"" + dialogueID + "\");";
        statement =  sqlConnection.connectSQL();
        try {
            statement.execute(sql);
        }catch (SQLException se){
            System.out.println("MessageDao - insertRecord error:" + se.getMessage());
            return false;
        }
        sqlConnection.closeSQL(statement);
        System.out.println("MessageDao - insertRecord: success");
        return true;
    }


    public ArrayList<Message> getUnreadMessageList(String username){
        ArrayList<Message> messageArrayList = new ArrayList<>();
        //sql operation
        return messageArrayList;
    }

    public ArrayList<Message> getAllMessageList(String username){
        ArrayList<Message> messageArrayList = new ArrayList<>();
        //sql operation;
        return messageArrayList;
    }

    public ArrayList<Message> getDialogueMessageList(String dialogueID){
        ArrayList<Message> dialogueMessageList = new ArrayList<Message>();
        String sql = "select * from system.message where dialogueId=" + dialogueID + ";";
        statement =  sqlConnection.connectSQL();
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String sender = resultSet.getString("sender");
                String receiver = resultSet.getString("receiver");
                String content = resultSet.getString("content");
                String messageType = resultSet.getString("type");
                String dialogueId = resultSet.getString("dialogueId");
                Message message = new Message(sender, receiver, content, messageType, dialogueId);
                dialogueMessageList.add(message);
                System.out.println("MessageDao - getDialogueMessageList;" + message.getContent());
            }
        }catch (SQLException se){
            System.out.println("MessageDao - getDialogueMessageList;" + se.getMessage());
        }
        sqlConnection.closeSQL(statement);
        return dialogueMessageList;
    }
}
