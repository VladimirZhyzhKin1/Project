package by.htp.les02.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les02.controller.command.Command;
import by.htp.les02.controller.command.CommandProvider;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (ServletException | IOException e) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/global_error_page.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (ServletException | IOException e) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/global_error_page.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name;
		Command command;

		name = request.getParameter("command");
		command = provider.takeCommand(name);

		try {
			command.execute(request, response);
		} catch (Exception e) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/global_error_page.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
