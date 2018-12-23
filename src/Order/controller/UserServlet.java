package Order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Order.entity.Order;
import Order.service.UserService;
import Order.service.impl.UserServiceImpl;

/**
 * 
 * @author Mryang StringUtilsz中的isNotbBlock：判断某字符串是否不为空且长度不为0且不由空白符构成
 *
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 引入UserService
	UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");


		if ("buy".equals(method)) {
			createOrder(request, response);
		}

	}

	private void createOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Order order = new Order();

		String item = request.getSession().getAttribute("itemId").toString();
		String buyer = request.getSession().getAttribute("buyer").toString();
		String seller = request.getSession().getAttribute("seller").toString();
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		order.setItem(item);
		order.setbuyer(buyer);
		order.setAddress(address);
		order.setPhone(phone);
		order.setSeller(seller);

		System.out.println("OrderServlet - createOrder:item," + order.getItem());
        System.out.println("OrderServlet - createOrder:buyer," + order.getBuyer());
        System.out.println("OrderServlet - createOrder:address," + order.getAddress());
        System.out.println("OrderServlet - createOrder:phone," + order.getPhone());
        System.out.println("OrderServlet - createOrder:seller," + order.getSeller());

		

		if (true) {

			int rows = userService.orderCreation(order);
//			if (rows > 0) {
//				response.setHeader("refresh",
//						"1;url=UserServlet?method=tologin");
//			} else {
//				request.setAttribute("msg", "注册失败！");
//				request.getRequestDispatcher("/message").forward(request,
//						response);
//			}
		}

	}

}
