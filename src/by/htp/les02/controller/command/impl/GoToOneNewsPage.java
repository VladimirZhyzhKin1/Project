package by.htp.les02.controller.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les02.bean.News;
import by.htp.les02.controller.command.Command;
import by.htp.les02.controller.validator.ValidatorAuth;
import by.htp.les02.service.NewsService;
import by.htp.les02.service.ServiceException;
import by.htp.les02.service.ServiceProvider;

public class GoToOneNewsPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
		
		if (ValidatorAuth.checkAuthorisation(request, response)) {
			return;
		}
			
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		String idString = request.getParameter("idnews");
		int idNews = Integer.parseInt(idString);
		try {
			News selectedNews = newsService.selectOneNews(idNews);
			if (selectedNews == null) {
				System.out.println("News with Idnews=" + idNews+ " was lose!");
			}
			request.setAttribute("selectedNews", selectedNews);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/view_one_news_page.jsp");
			requestDispatcher.forward(request, response);
			
		}catch(Exception e) {
			throw new ServiceException("Error", e);
		}		
	}

}
