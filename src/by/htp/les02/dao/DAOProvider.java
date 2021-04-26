package by.htp.les02.dao;

import by.htp.les02.dao.impl.SQLNewsDAO;
import by.htp.les02.dao.impl.SQLUserDAO;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();

	private final UserDAO userDAO = new SQLUserDAO();
	private final NewsDAO newsDAO = new SQLNewsDAO();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

}
