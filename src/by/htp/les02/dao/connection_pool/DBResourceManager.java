package by.htp.les02.dao.connection_pool;

import java.util.ResourceBundle;

//for read db.properties file
public class DBResourceManager {
	
	private final static DBResourceManager instance = new DBResourceManager();
	
	private ResourceBundle bundle = ResourceBundle.getBundle("db");

	public ResourceBundle getBundle() {
		return bundle;
	}

	public static DBResourceManager getInstance() {
		return instance;
	}
	
	public String getValue(String key) {
		return bundle.getString(key);
	}

}
