package by.htp.les02.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les02.controller.command.Command;
import by.htp.les02.controller.validator.ValidatorAuth;
import by.htp.les02.service.NewsService;
import by.htp.les02.service.ServiceException;
import by.htp.les02.service.ServiceProvider;

public class DeleteOneNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {
		if (ValidatorAuth.checkAuthorisation(request, response)) {
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		String idString = request.getParameter("idnews");
		int idNews = Integer.parseInt(idString);
		try {
			newsService.deleteNews(idNews);
			
 			response.sendRedirect("Controller?command=gotomainpage&message=News was deleted");
			
		}catch(Exception e) {
			throw new ServiceException("Error", e);
		}
	}

}
