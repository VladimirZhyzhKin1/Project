package by.htp.les02.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les02.controller.command.Command;
import by.htp.les02.service.ServiceException;

public class ChangeLocal implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {
		
		String local = request.getParameter("local");
		String redirectTo = request.getParameter("redirectTo"); 
		
		request.getSession(true).setAttribute("localLanguage", local);
		response.sendRedirect("Controller?" + redirectTo);
			
	}

}
