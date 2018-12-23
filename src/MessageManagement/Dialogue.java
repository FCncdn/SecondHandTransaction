package MessageManagement;

import Publish.Items;
import UserManagement.User;

import java.util.ArrayList;

public class Dialogue {
    private String dialogueId;
    private String sender;
    private String receiver;
    private ArrayList<Message> messageArrayList;
    private int activateItemID;

    public Dialogue(){
        dialogueId = null;
        sender = null;
        receiver = null;
        activateItemID = 0;
        messageArrayList = new ArrayList<Message>();
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String  receiver){
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public String  getReceiver() {
        return receiver;
    }

    public void addMessage(Message newMessage){
        messageArrayList.add(newMessage);
    }

    public String getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(String dialogueId) {
        this.dialogueId = dialogueId;
    }

    public void setMessageArrayList(ArrayList<Message> messageArrayList) {
        this.messageArrayList = messageArrayList;
    }

    public ArrayList<Message> getMessageArrayList() {
        return messageArrayList;
    }

    public int getActivateItemID() {
        return activateItemID;
    }

    public void setActivateItemID(int activateItemID) {
        this.activateItemID = activateItemID;
    }
}
