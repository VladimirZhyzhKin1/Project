package by.htp.les02.controller.validator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidatorAuth {
	
	public static boolean checkAuthorisation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Boolean result = false;

		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect("Conrtoller?command=gotoindexpage&message=Log in, please!");
			result = true;
		}

		Boolean isAuth = (Boolean)session.getAttribute("auth");
		if(isAuth == null || !isAuth) {
			response.sendRedirect("Controller?command=gotoindexpage&message=Authorization is required to work on the site");
			result = true;
		}
		return result;
	}

}
