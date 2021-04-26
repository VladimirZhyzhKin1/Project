package by.htp.les02.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les02.bean.RegistrationInfo;
import by.htp.les02.controller.command.Command;
import by.htp.les02.service.ServiceException;
import by.htp.les02.service.ServiceProvider;
import by.htp.les02.service.UserService;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userLogin = request.getParameter("login");
		String userPassword = request.getParameter("password");
		String userName = request.getParameter("name");
		String userSurname = request.getParameter("surname");
		String userEmail = request.getParameter("email");
		String userStatus = request.getParameter("status");
		String userRole = request.getParameter("role");

		ServiceProvider service = ServiceProvider.getInstance();
		UserService userService = service.getUserService();

		RegistrationInfo userInfo = new RegistrationInfo();
		userInfo.setLogin(userLogin);
		userInfo.setPassword(userPassword);
		userInfo.setName(userName);
		userInfo.setSurname(userSurname);
		userInfo.setEmail(userEmail);
		userInfo.setStatus(userStatus);
		userInfo.setRole(userRole);

		System.out.println(userInfo.toString());

		try {
			userService.registration(userInfo);
		} catch (ServiceException e) {
			System.out.println("ERROR in DataBase");
		}
		response.sendRedirect("Controller?command=gotoindexpage&message=Registration OK!");
	}
}
