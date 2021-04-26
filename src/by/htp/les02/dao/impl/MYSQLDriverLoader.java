package by.htp.les02.dao.impl;

import by.htp.les02.dao.DBDriverLoadingException;

public class MYSQLDriverLoader {//Singleton
	private static final MYSQLDriverLoader instance = new MYSQLDriverLoader();
	
	static {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DBDriverLoadingException(e);
		}	
	}
	
	private MYSQLDriverLoader() {}
	
	public static MYSQLDriverLoader getInstance() {
		return instance;
	}
}
