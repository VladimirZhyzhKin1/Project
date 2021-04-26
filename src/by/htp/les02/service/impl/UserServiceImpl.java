package by.htp.les02.service.impl;

import by.htp.les02.bean.RegistrationInfo;
import by.htp.les02.bean.User;
import by.htp.les02.dao.DAOException;
import by.htp.les02.dao.DAOProvider;
import by.htp.les02.dao.UserDAO;
import by.htp.les02.service.ServiceException;
import by.htp.les02.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String login, String password) throws ServiceException {

		/*if (login == null || "".equals(login)) { // .......
			throw new ServiceException("wrong login or password");
		}*/

		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();

		User user = null;
		try {
			user = userDAO.autorization(login, password);
		} catch (DAOException e) {
			throw new ServiceException("Error message", e);
		}

		return user;
	}

	@Override
	public void registration(RegistrationInfo regInfo) throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		
		try {			
			userDAO.registration(regInfo);
		}catch (DAOException e) {
			throw new ServiceException (e);
		}
	}

}
