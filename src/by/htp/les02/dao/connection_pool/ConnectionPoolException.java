package by.htp.les02.dao.connection_pool;

public class ConnectionPoolException extends Exception {

	private static final long serialVersionUID = 4305649459143717204L;

	public ConnectionPoolException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ConnectionPoolException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public ConnectionPoolException(Exception e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
		// TODO Auto-generated constructor stub
	}

}
