package com.dz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dz.dao.MessageDao;
import com.dz.service.MessageService;

public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			String id=request.getParameter("id");
			
			MessageService msgService=new MessageService();
			msgService.delMsg(Integer.valueOf(id));
			
			/*MessageDao msgDao=new MessageDao();
			msgDao.delMsg(Integer.valueOf(id));	*/
			response.sendRedirect("msglist");
		}catch(Exception e){
			e.getStackTrace();
		}

	
	}

}
