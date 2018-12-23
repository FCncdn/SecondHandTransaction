package servlet;

import MessageManagement.Dialogue;
import MessageManagement.Message;
import UserManagement.User;
import bean.UserBean;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class getMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getMessageServlet - dopost:start");
        String username = req.getParameter("username");
        String contact = req.getParameter("contact");

        int messageCount = 0;
        int dialogueID = 0;
        int currentDialogueListID = 0;

        UserBean userBean = new UserBean();
        User currentUser = new User(username);
        Dialogue currentDialogue = new Dialogue();
        ArrayList<Message> currentMessageList = new ArrayList<Message>();
        String currentContent = null;

        //设置currentUser的DialgoueArrayList
        userBean.setDialogueArrayList(currentUser);

        //获取当前会话的dialogue对象
        currentDialogue = userBean.getDialogueArrayList().get(currentDialogueListID);

        //获取dialogue对象的messageList
        currentMessageList = currentDialogue.getMessageArrayList();

        //获取dialogue对象的messageList大小
        messageCount = currentDialogue.getMessageArrayList().size();

        resp.setContentType("application/jason");

        PrintWriter writer = resp.getWriter();

        Gson gson = new Gson();

        String jsonStr = gson.toJson(currentMessageList);

        System.out.println(jsonStr);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
