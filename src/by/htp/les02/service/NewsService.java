package by.htp.les02.service;

import java.util.List;

import by.htp.les02.bean.News;

public interface NewsService {

	List<News> takeAllNews() throws ServiceException;

	News selectOneNews(int idnews) throws ServiceException;

	void editNews(int idnews, String title, String brief, String content) throws ServiceException;

	void deleteNews(int idnews) throws ServiceException;

}
