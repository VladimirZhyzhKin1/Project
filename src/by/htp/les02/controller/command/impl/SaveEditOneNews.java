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

public class SaveEditOneNews implements Command{

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
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		try {
			newsService.editNews(idNews, title, brief, content); 
			
			response.sendRedirect("Controller?command=gotoindexpage&message=News was edit OK!&idnews=" + idNews);

		}catch(NumberFormatException e) {
			throw new ServiceException("Idnews was lose!", e);
		}
		
	}
	

}
