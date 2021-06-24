package by.htp.les02.service.impl;

import by.htp.les02.bean.RegistrationInfo;
import by.htp.les02.bean.User;
import by.htp.les02.dao.DAOException;
import by.htp.les02.dao.DAOProvider;
import by.htp.les02.dao.UserDAO;
import by.htp.les02.service.ServiceException;
import by.htp.les02.service.UserService;
import by.htp.les02.service.validator.UserException;
//import by.htp.les02.service.validator.ValidatorForLogination;
import by.htp.les02.service.validator.ValidatorForLogination;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String login, String password) throws ServiceException{
		
		try {
			ValidatorForLogination.validationForLogination(login, password);
		} catch (UserException e1) {
			System.out.println("Hi");
		}
						
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
			throw new ServiceException ("Error message");
		}
	}

}
