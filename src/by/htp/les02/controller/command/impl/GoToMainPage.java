package by.htp.les02.controller.command.impl;

import java.io.IOException;
import java.util.List;

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

public class GoToMainPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {

		if (ValidatorAuth.checkAuthorisation(request, response)) {
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		try {
			List<News> news = newsService.takeAllNews();

			request.setAttribute("news", news);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
			requestDispatcher.forward(request, response);

		} catch (ServletException e) {
			throw new ServiceException("can't forward to main page", e);
		}
	}
}
