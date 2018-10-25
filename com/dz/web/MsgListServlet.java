package com.dz.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dz.dao.MessageDao;
import com.dz.entity.Message;
import com.dz.service.MessageService;

public class MsgListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				doPost(request, response);}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*MessageDao msgDao=new MessageDao();
		List<Message> msgList = msgDao.findAll();*/
		
		MessageService msgService=new MessageService();
		List<Message> msgList = msgService.findAll();
		
		request.setAttribute("msglist", msgList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
