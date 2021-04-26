package by.htp.les02.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les02.service.ServiceException;


public interface Command {

	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException;

}
