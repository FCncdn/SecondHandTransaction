package servlet;

import MessageManagement.Dialogue;
import MessageManagement.Message;
import bean.UserBean;
import login.entity.User;
import model.ContactDao;
import model.DialogueDao;
import model.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class messageIndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contactId;
        User mCurrentUser;
        mCurrentUser = (User) req.getSession().getAttribute("USER_SESSION");
        ArrayList<String> contactList = new ArrayList<String>();
        ContactDao contactDao = new ContactDao();
        contactId = req.getParameter("contactId");
        //
        Dialogue dialogue = new Dialogue();
        DialogueDao dialogueDao = new DialogueDao();
        ArrayList<Message> messageArrayList = new ArrayList<Message>();
        MessageDao messageDao = new MessageDao();

        if (mCurrentUser == null){
            System.out.println("messageIndexServlet - error:user null");
        }

        contactList = contactDao.getContactList(mCurrentUser.getUsername());
        String mCurrentContact = contactList.get(Integer.parseInt(contactId));
        mCurrentUser.setContactList(contactList);
        req.getSession().setAttribute("user",mCurrentUser);
        req.getSession().setAttribute("currentContact", mCurrentContact);
        req.getRequestDispatcher("/Message/Message2.jsp").forward(req,resp);
            dialogue = dialogueDao.getDialouge(mCurrentUser.getUsername(), mCurrentContact);
            messageArrayList = messageDao.getDialogueMessageList(dialogue.getDialogueId());
            dialogue.setMessageArrayList(messageArrayList);
        System.out.println("message: " + messageArrayList.get(0));

        if (contactId.equals("0")){
        }else{

        }
    }
}
