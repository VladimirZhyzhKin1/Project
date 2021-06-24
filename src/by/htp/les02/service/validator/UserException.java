package by.htp.les02.service.validator;

public class UserException extends Exception{
	
	private static final long serialVersionUID = -2399236232541848678L;

	public UserException() {
		super();
	}
	
	public UserException(String message) {
		super(message);
	}
	
	public UserException(Exception e) {
		super(e);
	}
	
	public UserException(String message, Exception e) {
		super(message, e);
	}
	

}
