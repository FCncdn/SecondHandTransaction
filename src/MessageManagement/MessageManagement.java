package MessageManagement;

import UserManagement.User;
import model.MessageDao;

import java.util.ArrayList;

public class MessageManagement {
    private int unreadCount;
    private int allCount;
    private ArrayList<Message> unreadMessagesList;
    private ArrayList<Message> messageList;

    private User user;
    private MessageDao messageDao;

    public MessageManagement(User user){
        unreadCount = 0;
        unreadMessagesList = new ArrayList<Message>();
        messageList = new ArrayList<Message>();
        this.user = user;
        messageDao = new MessageDao();
    }

    public int getUnreadCount() {
        unreadCount = getUnreadMessagesList().size();
        return unreadCount;
    }

    public int getAllCount() {
        allCount = getMessageList().size();
        return allCount;
    }

    //q2
    public ArrayList<Message> getUnreadMessagesList() {
        messageDao.getUnreadMessageList(user.getUsername());
        return unreadMessagesList;
    }

    public ArrayList<Message> getMessageList() {
        messageDao.getUnreadMessageList(user.getUsername());
        return messageList;
    }
}
