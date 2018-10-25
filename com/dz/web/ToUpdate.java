package com.dz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dz.dao.MessageDao;
import com.dz.entity.Message;
import com.dz.service.MessageService;


public class ToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		MessageService msgService=new MessageService();
		Message msg=msgService.findById(Integer.valueOf(id));
		
		
/*
		MessageDao msgDao=new MessageDao();
		Message msg=msgDao.findById(Integer.valueOf(id));
*/
		request.setAttribute("msglist",msg);
		request.getRequestDispatcher("update.jsp").forward(request,response);

		
	}

}
