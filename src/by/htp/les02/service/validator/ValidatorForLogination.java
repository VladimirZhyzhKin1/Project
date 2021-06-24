package by.htp.les02.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//DONOT WORK!!!!I don't know how to turn on
public class ValidatorForLogination {
	/*
	 * Between 2 and 25 characters long. Contain at least one lower case character.
	 * Contain at least one upper case character.
	 */
	private static final String LOGIN_PATTERN = "((?=.*[a-z])(?=.*[A-Z]).{2,25})";
	/*
	 * Be between 4 and 40 characters long Contain at least one digit. Contain at
	 * least one lower case character. Contain at least one upper case character
	 */
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{4,40})";


	public static boolean validationForLogination(String login, String password) throws UserException{
		Pattern patternLogin = Pattern.compile(LOGIN_PATTERN);
		Matcher matcherLogin = patternLogin.matcher(login);

		if (!matcherLogin.matches()) {
			throw new UserException("Wrong login! Please correct.");
		}
		if (login==null || login.isEmpty()) {
			throw new UserException("Fill login correct!");
		}
		System.out.println("2");
		Pattern patternPassword = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcherPassword = patternPassword.matcher(password);
		
		if (!matcherPassword.matches()) {
			throw new UserException("Wrong password! Please correct.");
		}
		if (password==null || password.isEmpty()) {
			throw new UserException("Fill password correct!");
		}

		return matcherLogin.find() && matcherPassword.find();
	}
}
