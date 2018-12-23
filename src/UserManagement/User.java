package UserManagement;

import model.DialogueDao;

import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<String> dialogueIDList;

    public User(String username){
        this.username = username;
        dialogueIDList = new ArrayList<String>();
        DialogueDao dialogueDao = new DialogueDao();
        dialogueIDList = dialogueDao.getDialogueList(username);
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<String> getDialogueIDList() {
        return dialogueIDList;
    }
}
