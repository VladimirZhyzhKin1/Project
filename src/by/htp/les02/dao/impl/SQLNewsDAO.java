package by.htp.les02.dao.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.les02.bean.News;
import by.htp.les02.dao.DAOException;
import by.htp.les02.dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO {

	private static final String URL = "jdbc:mysql://127.0.0.1/news_managment?useSSL=false&serverTimezone=UTC";
	private static final String USER = "Valdar";
	private static final String PASSWORD = "Valdar123456789";

	static {
		MYSQLDriverLoader.getInstance();// loading Driver
	}

	@Override
	public List<News> all() throws DAOException {
		final String NEWS_ALL_LIST = "SELECT * FROM news";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		List<News> news = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery(NEWS_ALL_LIST);

			news = new ArrayList<News>();
			while (rs.next()) {
				int idnews = rs.getInt("idnews");
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				News n = new News(idnews, title, brief);

				news.add(n);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return news;
	}

	@Override
	public News selectNewsDAO(int idnews) throws DAOException {

		final String NEWS_ONE_SELECT = "SELECT * FROM news WHERE idnews =" + idnews;

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		News result = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery(NEWS_ONE_SELECT);

			while (rs.next()) {
				int idDB = rs.getInt("idnews");
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String data = rs.getString("data");
				String content = rs.getString("content");
				String status = rs.getString("status");
				result = new News(idDB, title, brief, data, content, status);
			}

		} catch (SQLException e) {
			throw new DAOException("one news not received: DB error", e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException("resource closing error", e);
			}
		}

		return result;
	}

	@Override
	public void editNews(int idnews, String title, String brief, String content) throws DAOException {

		final String NEWS_EDIT_REQUEST = "UPDATE news SET title='" + title + "', brief='" + brief + "', content='"
				+ content + "' WHERE idnews=" + idnews;

		Connection con = null;
		Statement st = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();
			st.executeUpdate(NEWS_EDIT_REQUEST);

		} catch (SQLException e) {
			throw new DAOException("Database problem, no way to update resource", e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException("resource closing error", e);
			}
		}
	}

	@Override
	public void deleteNews(int idnews) throws DAOException {
		
		final String NEWS_DELET_QUERY = "UPDATE news SET status = 'not Actual' WHERE idnews=" + idnews;
		
		Connection con = null;
		Statement st = null;
				
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();
			st.executeUpdate(NEWS_DELET_QUERY);
			
		}catch (SQLException e) {
			throw new DAOException("Database problem, no way to delete the news", e);
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				throw new DAOException("resource closing error", e);
			}
		}
	}

}