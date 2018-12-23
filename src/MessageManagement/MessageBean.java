package MessageManagement;

import UserManagement.User;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageBean implements Serializable {

    private int unreadCount;
    private int allCount;

    public MessageBean(){
        unreadCount = 0;
        allCount = 0;
    }

    public int getUnreadCount(User user) {
        MessageManagement messageManagement = new MessageManagement(user);
        unreadCount = messageManagement.getUnreadCount();
        return unreadCount;
    }

    public int getAllCount(User user) {
        MessageManagement messageManagement = new MessageManagement(user);
        allCount = messageManagement.getAllCount();
        return allCount;
    }

}
