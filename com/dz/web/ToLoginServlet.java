package com.dz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dz.dao.UserDao;
import com.dz.entity.User;
import com.dz.service.UserService;

public class ToLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		User user=new User();
		user.setUsername(name);
		user.setPassword(pwd);
		
		UserService uService=new UserService();
		uService.saveU(user);
		/*UserDao uDao=new UserDao();
		uDao.saveU(user);*/
		response.sendRedirect("logon.jsp");
	}

}
