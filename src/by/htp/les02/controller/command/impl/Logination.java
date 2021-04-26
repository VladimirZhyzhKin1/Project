package by.htp.les02.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.les02.bean.User;
import by.htp.les02.controller.command.Command;
import by.htp.les02.service.ServiceException;
import by.htp.les02.service.ServiceProvider;
import by.htp.les02.service.UserService;

public class Logination implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login;
		String password;

		login = request.getParameter("login");
		password = request.getParameter("password");

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		User user = null;
		try {
			user = userService.authorization(login, password);

			if (user == null) {
				response.sendRedirect("Controller?command=gotoindexpage&message=wrong2");// we think which URL write here
				return;
			} // execute this, if login is good

			HttpSession session = request.getSession(true);
			session.setAttribute("auth", true);
			session.setAttribute("name", user.getName());
			session.setAttribute("role", user.getRole());

			response.sendRedirect("Controller?command=gotoindexpage");

		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=gotoindexpage&message=wrong in catch");// we think which URL write here
		}
	}
}
