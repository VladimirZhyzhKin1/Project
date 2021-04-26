package by.htp.les02.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {
	
	private String encoding;
	private ServletContext contex;
	
	public void init(FilterConfig fConfig) throws ServletException{
		encoding = fConfig.getInitParameter("characterEncoding");
		contex = fConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		contex.log("Charset was set.");
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {}

}
