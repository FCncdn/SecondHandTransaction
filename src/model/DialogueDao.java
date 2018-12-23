package model;

import MessageManagement.Dialogue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DialogueDao {
    private ArrayList<String> dialogueList;
    private SQLConnection sqlConnection;
    private ResultSet resultSet;
    private Statement statement;

    public DialogueDao(){
        ResultSet resultSet = null;
        Statement statement = null;
        dialogueList = new ArrayList<String>();
        sqlConnection = new SQLConnection();
    }

    public ArrayList<String> getDialogueList(String username) {
        String sql = "SELECT * FROM system.dialogue where playerA='" + username + "' or playerB='"+ username +"';";
        ArrayList<String> dialogueList = new ArrayList<String>();
        statement = sqlConnection.connectSQL();

        try{
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                dialogueList.add(Integer.toString(resultSet.getInt("iddialogue")));
            }

            for (int i = 0; i < dialogueList.size(); i++){
                System.out.println("DialogueDao - getDialogueList;" + dialogueList.get(i));
            }


        }catch (SQLException se){
            System.out.println("DialogueDao - getDialogueList;" + se.getMessage());
        }

        sqlConnection.closeSQL(statement);
        return dialogueList;
    }

    public Boolean updataActivateItem(String DialogueId, String itemId){
        System.out.println("DialogueDao - updataActivateItem: start");
        String sql="update dialogue set activateItemId = '"+ itemId +"' where iddialogue="+ DialogueId +";";
        statement = sqlConnection.connectSQL();
        try {
            statement.execute(sql);
        }catch (SQLException se){
            System.out.println("DialogueDao - updataActivateItem: error" + se.getMessage());
            return false;
        }
        sqlConnection.closeSQL(statement);
        System.out.println("DialogueDao - updataActivateItem: success");
        return true;
    }

    public Dialogue getDialouge(String dialogueId, String sender){
        Dialogue dialogue = new Dialogue();
        String sql = "select * from dialogue where iddialogue="+ dialogueId +";";
        statement = sqlConnection.connectSQL();
        try {
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            String receiver = "";
            String temp = resultSet.getString("playerA");
            System.out.println("getDialouge - temp:" + temp);
            if (temp.equals(sender)){
                receiver = resultSet.getString("playerB");
            }else {
                receiver = temp;
            }
            dialogue.setSender(sender);
            dialogue.setReceiver(receiver);
            dialogue.setDialogueId(dialogueId);

        }catch (SQLException se){
            System.out.println("DialogueDao - getDialouge: error" + se.getMessage());
        }
        sqlConnection.closeSQL(statement);
        return dialogue;
    }

    public Dialogue getDialogue(String user, String contact){
        Dialogue dialogue = new Dialogue();

        String sql = "SELECT * FROM system.dialogue where playerA = '"+ user +"' and playerB = '"+ contact +"' or " +
                "playerA='" + contact+  "' and playerB = '"+ user +"';";
        statement = sqlConnection.connectSQL();

        try{
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            dialogue.setDialogueId(Integer.toString( resultSet.getInt("iddialogue")));
            dialogue.setSender(user);
            dialogue.setReceiver(contact);
        }catch (SQLException se){
            System.out.println("DialogueDao - getDialouge: error" + se.getMessage());
        }

        sqlConnection.closeSQL(statement);
        return dialogue;
    }
}
