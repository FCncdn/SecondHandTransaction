package search;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import search.Item;
import search.ItemDao;



public class ItemServlet extends HttpServlet {
 
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String zh = request.getParameter("xxid");
        List<Item> itemList = new ItemDao().list(zh);
        request.setAttribute("itemList",itemList);
        request.getRequestDispatcher( "Item.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}