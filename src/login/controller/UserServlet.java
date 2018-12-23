package login.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import login.entity.User;
import login.service.UserService;
import login.service.impl.UserServiceImpl;
import login.util.*;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UserService userService;

    @Override
    public void init() throws ServletException {
        // 引入UserService
        System.out.println("UserServlet - init:start");
         userService = new UserServiceImpl();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet - doGet:start");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet - doPost:start");

		String method = request.getParameter("method");

		// 如果传入的参数是login
		if ("login".equals(method)) {
			login(request, response);
			// 如果传入的参数是regist
		} else if ("regist".equals(method)) {
			regist(request, response);
			// 如果传入的参数是logout
		} else if ("logout".equals(method)) {
			logout(request, response);
			// 如果传入的参数是tologin
		} else if ("tologin".equals(method)) {
			try {
				tologin(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 如果传入的参数是toregist
		} else if ("toregist".equals(method)) {
			toregist(request, response);
			// 如果传入的参数是对应不上
		} else {
			request.setAttribute("msg", "该功能正在开发...");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}

	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    System.out.println("UserServlet - login: start");
		/*
		 * 1. 获取前台jsp表单传递的参数
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 如果测试传入的参数。可以打开72行的注释
		// System.out.println("用户名：" + username + "<br/>" + "密码" + password);

		/*
		 * 2.根据参数进行判断
		 */
		// 2.1 如果用户名和密码都不为空
		if (StringUtils.isNotBlank(username)
				&& StringUtils.isNotBlank(password)) {
			// 2.1.1 传递到service层登录方法
            System.out.println("UserServlet - login: send to userService");
			User user = userService.userLogin(username, password);
            System.out.println("UserServlet - login: send to userService success");
			// 2.1.2 判断用户信息是否查询到
			if (user != null) {
                System.out.println("UserServlet - login: get user");
				// 查询到，存入session
				request.getSession().setAttribute("USER_SESSION", user);
				// 登录成功，转向主页
                //request.setAttribute("username",user.getUsername());
				request.getRequestDispatcher("/main.jsp").forward(
						request, response);

			} else {
                System.out.println("UserServlet - login: can not get user");
				// 未查询到或者用户名和密码不匹配，将失败的信息存储到msg中
				request.setAttribute("msg", "用户名或者密码不对！");
				// 登录失败，转向错误信息提示页面，根据存入的msg取出相对应的内容
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);//
			}
			// 2.2 如果用户名或者密码为空
		} else {
			request.setAttribute("msg", "用户名或者密码不许为空！");
			request.getRequestDispatcher("/login.jsp").forward(
					request, response);//
		}

	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		// 1. 获取前台jsp页面的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");

		// 2. 将获取到的参数封装到user对象中去
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setSex(sex);

		if (StringUtils.isNotBlank(user.getUsername())
				&& StringUtils.isNotBlank(user.getPassword())) {

			int rows = userService.userRegister(user);
			if (rows > 0) {
				response.setHeader("refresh",
						"1;url=UserServlet?method=tologin");
			} else {
				request.setAttribute("msg", "注册失败！");
				request.getRequestDispatcher("/message").forward(request,
						response);
			}
		}else{
			request.setAttribute("msg", "用户名或者密码不许为空");
			request.getRequestDispatcher("/message").forward(request,
					response);
		}

	}

	/**
	 * 转向到登录页面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void tologin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.getRequestDispatcher("/login.jsp").forward(request,
				response);//
//		try {
//			System.out.println("1234567897");
//			String userName=(String) request.getSession().getAttribute("USE_SESSION.username");
//		GetInfo aa = new GetInfo();
//		User bb = new User();
//		bb = aa.getUser(userName);
//		System.out.println(bb);
//		System.out.println("1234567897");
//      }
//	catch (SQLException e) {
//          e.printStackTrace();
//          System.out.println("tologin:" + e.getMessage());
//      }
		
	}
	
	  

	/**
	 * 转向到注册页面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void toregist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/regist.jsp").forward(
				request, response);//
	}
	
	/**
	 * 用户注销
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("/login.jsp").forward(
				request, response);//
	}

}
