package by.htp.les02.dao;

public class DBDriverLoadingException extends RuntimeException{

	private static final long serialVersionUID = -7240792216747107660L;

	public DBDriverLoadingException(Exception e) {
		super(e);
	}

}
