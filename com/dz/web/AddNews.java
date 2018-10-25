package com.dz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dz.dao.MessageDao;
import com.dz.entity.Message;
import com.dz.service.MessageService;

public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		//取出来
		String name=request.getParameter("username");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//存进Message类,形成一个对象	
		Message msg=new Message();
		msg.setUsername(name);
		msg.setTitle(title);
		msg.setContent(content);
		//将对象存进数据库	
		MessageService msgService=new MessageService();
		msgService.saveMsg(msg);
		
	/*	MessageDao msgDao=new MessageDao();
		msgDao.saveMsg(msg);*/
		
		//重定向，为了解决页面每刷新一次的重复的请求转发	
		response.sendRedirect("msglist");
		
		
	}

}
