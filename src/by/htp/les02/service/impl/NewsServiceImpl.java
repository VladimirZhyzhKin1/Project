package by.htp.les02.service.impl;

import java.util.List;

import by.htp.les02.bean.News;
import by.htp.les02.dao.DAOException;
import by.htp.les02.dao.DAOProvider;
import by.htp.les02.dao.NewsDAO;
import by.htp.les02.service.NewsService;
import by.htp.les02.service.ServiceException;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> takeAllNews() throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();

		List<News> news;
		try {
			news = newsDAO.all();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return news;
	}

	@Override
	public News selectOneNews(int idnews) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();

		News selectNews = null;

		try {
			selectNews = newsDAO.selectNewsDAO(idnews);

		} catch (DAOException e) {
			throw new ServiceException("Error BD", e);
		}
		return selectNews;
	}

	@Override
	public void editNews(int idnews, String title, String brief, String content) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
		
		try {
			newsDAO.editNews(idnews, title, brief, content);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	
	}
	
	 @Override public void deleteNews(int idnews) throws ServiceException { 
		DAOProvider provider = DAOProvider.getInstance();
		NewsDAO newsDAO = provider.getNewsDAO();
			
		try {
			newsDAO.deleteNews(idnews);
				
		}catch(DAOException e) {
			throw new ServiceException("Error BD", e);
		}
			  
	 }
	 
}
