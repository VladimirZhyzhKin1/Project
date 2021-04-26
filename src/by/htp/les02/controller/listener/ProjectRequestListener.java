package by.htp.les02.controller.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ProjectRequestListener implements ServletRequestListener {

	public ProjectRequestListener() {

	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("Request from " + request.getContextPath() + " was destroyed!");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("Request from " + request.getContextPath() + " was created!");
	}

}
