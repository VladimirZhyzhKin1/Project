package by.htp.les02.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.les02.bean.RegistrationInfo;
import by.htp.les02.bean.User;
import by.htp.les02.dao.DAOException;
import by.htp.les02.dao.UserDAO;

public class SQLUserDAO implements UserDAO {

	private static final String URL = "jdbc:mysql://127.0.0.1/news_managment?useSSL=false&serverTimezone=UTC";
	private static final String USER = "Valdar";
	private static final String PASSWORD = "Valdar123456789";

	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public User autorization(String login, String password) throws DAOException {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		User user = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM users WHERE login = '" + login + "' AND password = '" + password + "'");
			while (rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setLogin(rs.getString("login"));
				user.seteMail(rs.getString("email"));
				user.setRole(rs.getString("role"));
			}

			// for information
			System.out.println("USER AUTHORIZATION");

		} catch (SQLException e) {
			throw new DAOException("ERROR in DataBase", e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException("ERROR, loss of connection with the closure of resources", e);
			}
		}
		return user;
	}

	@Override
	public void registration(RegistrationInfo regInfo) throws DAOException {

		final String CREATE_NEW_USER = "INSERT INTO users(login, password, name, surname, email, status, role) VALUES('"+regInfo.getLogin()+
				"', '"+regInfo.getPassword()+"', '"+regInfo.getName()+"', '"+regInfo.getSurname()+"', '"+regInfo.getEmail()+"','active','user')";

		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();

			st.executeUpdate(CREATE_NEW_USER);

		} catch (SQLException e) {
			throw new DAOException("ERROR in DataBase", e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException("ERROR, loss of connection with the closure of resources", e);
			}
		}
	}
}
