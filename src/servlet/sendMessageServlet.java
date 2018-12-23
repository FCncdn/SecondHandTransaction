package servlet;

import MessageManagement.Dialogue;
import MessageManagement.Message;
import Publish.Items;
import UserManagement.User;
import bean.ItemBean;
import bean.UserBean;
import model.DialogueDao;
import model.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class sendMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        System.out.println("sendMessageServlet - type:" + type);
        String sender = req.getSession().getAttribute("sender").toString();
        String receiver = req.getSession().getAttribute("receiver").toString();
        String dialogueID = req.getSession().getAttribute("dialogueID").toString();
        String enter = "";

        if (type.equals("normalDialogue")){
            enter = "messageBox";

            System.out.println("sendMessageServlet:start");
            System.out.println("sendMessageServlet - sender:" + req.getSession().getAttribute("sender").toString());
            System.out.println("sendMessageServlet - receiver:" + req.getSession().getAttribute("receiver").toString());
            System.out.println("sendMessageServlet - dialogueID:" + req.getSession().getAttribute("dialogueID").toString());

            String messageContent = req.getParameter("MessageContent");
            System.out.println("sendMessageServlet:" + messageContent);

            String messageType = "dialogue";

            Message newMessage = new Message(sender,receiver,messageContent, messageType, dialogueID);
            if (newMessage.send()){
                System.out.println("sendMessageServlet:send success");
            }else{
                System.out.println("sendMessageServlet:send fail");
            }

        }else if (type.equals("itemDialogue")){
            enter = "itemDetail";

            int itemID = Integer.parseInt(req.getSession().getAttribute("itemId").toString());
            ItemBean itemBean = new ItemBean();
            Items items = new Items();
            DialogueDao dialogueDao = new DialogueDao();
            String seller = req.getSession().getAttribute("seller").toString();
            System.out.println("sendMessageServlet:seller:" + seller);

            dialogueDao.updataActivateItem(dialogueID,Integer.toString(itemID));
            items = itemBean.getItem(itemID);

            String messageContent = "想要咨询关于商品:" + items.getGoodName() + "的问题。";
            String messageType = "notification";
            Message newMessage = new Message(sender,receiver, messageContent, messageType, dialogueID);
            if (newMessage.send()){
                System.out.println("sendMessageServlet:send success");
            }else{
                System.out.println("sendMessageServlet:send fail");
            }

        }
        resp.sendRedirect("/Message/Message.jsp?username="+sender +"&enter="+enter);





    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
