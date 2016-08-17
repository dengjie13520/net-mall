package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;


public class FirstVisit implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Cookie cookie=new Cookie("lastTime",new Date().toString());
		cookie.setMaxAge(60*60);
		cookie.setValue(new Date().toString());
		cookie.setPath(request.getServletContext().getContextPath());
		System.out.println(request.getServletContext().getContextPath());
		System.out.println("qqq");
		response.getWriter().print(cookie);
		chain.doFilter(request, response);
	}


	public void destroy() {

	}


	public void init(FilterConfig arg0) throws ServletException {

	}
}
