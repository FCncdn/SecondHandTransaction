package OrderInfo;

import Order.entity.Order;
import login.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "/OrderInfoServlet",loadOnStartup = 1)
public class OrderInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    OrderInfoService orderInfoService = new OrderInfoServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OrderInfoServlet - dopost:start");

        request.setAttribute("order_list", getOrders(request, response));
        request.getRequestDispatcher("/order.jsp").forward(request,
                response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private ArrayList<Order> getOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("OrderInfoServlet");
        User user = new User();

        user = (User) request.getSession().getAttribute("USER_SESSION");

        System.out.println("OrderServlet - createOrder:item," + user.getId());

        if (true) {
            ArrayList<Order> order_list = orderInfoService.getOrderList(user);
//            ArrayList<Order> order_list = null;
            return order_list;
//			response.setContentType("application/jason");
//
//			Gson gson = new Gson();
//
//			String jsonStr = gson.toJson(order_list);
//
//			System.out.println(jsonStr);
        }
        else return null;
    }
}
