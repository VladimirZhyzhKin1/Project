package by.htp.les02.dao;

import by.htp.les02.bean.RegistrationInfo;
import by.htp.les02.bean.User;

public interface UserDAO {

	User autorization(String login, String password) throws DAOException;

	void registration(RegistrationInfo regInfo) throws DAOException;

}