package com.dz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dz.dao.MessageDao;
import com.dz.entity.Message;
import com.dz.service.MessageService;
import com.sun.xml.internal.bind.unmarshaller.Messages;


public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
				doPost(request, response);
				}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String id=request.getParameter("id");
		
		Message msg=new Message();
		msg.setUsername(name);
		msg.setTitle(title);
		msg.setContent(content);
		msg.setId(Integer.valueOf(id));
		
		MessageService msgService=new MessageService();
		msgService.updateMsg(msg);
		/*MessageDao msgDao=new MessageDao();
		msgDao.updateMsg(msg);*/
		response.sendRedirect("msglist");
		
	}

}
