package by.htp.les02.service;

import by.htp.les02.bean.RegistrationInfo;
import by.htp.les02.bean.User;

public interface UserService {

	User authorization(String login, String password) throws ServiceException;

	void registration(RegistrationInfo regInfo) throws ServiceException;

}
