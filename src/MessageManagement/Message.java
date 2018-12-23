package MessageManagement;

import model.MessageDao;

import java.util.Date;

public class Message {
    private String sender;
    private String receiver;
    private String date;
    //Date test
    private java.util.Date date_test;
    private String content;
    private String messageType;
    private String dialogueID;

    private MessageDao messageDao;

    public Message(String sender, String receiver, String content, String messageType, String dialogueID){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.messageType = messageType;
        this.dialogueID = dialogueID;
        messageDao = new MessageDao();
    }

    public boolean send(){
        System.out.println("Message:start");
        if (messageDao.insertRecord(sender, receiver, content, messageType, dialogueID)){
            System.out.println("Message:send success");
            return true;
        }else{
            return false;
        }
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
