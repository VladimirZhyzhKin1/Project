package by.htp.les02.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.les02.controller.command.Command;

public class LogOut implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session != null) {
			session.removeAttribute("auth");
		}
		
		response.sendRedirect("Controller?command=gotoindexpage&message=Logout OK");// we think which URL write here
	
	}

}
