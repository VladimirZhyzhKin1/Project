package by.htp.les02.dao;

import java.util.List;

import by.htp.les02.bean.News;

public interface NewsDAO {

	List<News> all() throws DAOException;
	
	News selectNewsDAO(int idnews) throws DAOException;

	void editNews(int idnews, String title, String brief, String content) throws DAOException;

	void deleteNews(int idnews) throws DAOException;
}
