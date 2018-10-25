package com.dz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dz.dao.UserDao;
import com.dz.entity.User;
import com.dz.service.UserService;

/**
 * Servlet implementation class ToLogonServlet
 */
public class ToLogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("username");
		String pwd =request.getParameter("password");
		
		UserService uService=new UserService();
		 User u= (User)uService.getUser(name);
		
		/*UserDao uDao=new UserDao();
	    User u= (User)uDao.getUser(name);*/
	    if(u!=null){
	    	if(u.getPassword().equals(pwd)){
	    		request.setAttribute("user", u);
	    		response.sendRedirect("news.jsp");
	    	}else{
	    		
	    		response.sendRedirect("logon.jsp");
	    	}
	    }
		
	}

}
