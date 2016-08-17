package filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import myService.mall_forRegister;


public class FirstVisit implements Filter {
	private void doBeforeProcessing(ServletRequest request){
		HttpSession session =((HttpServletRequest)request).getSession();
		Cookie[] cookies=((HttpServletRequest)request).getCookies();
		String user=null;
		String password =null;
		if(cookies !=null){
			for(Cookie c:cookies){
				System.out.println(c.getName()+"----"+c.getValue());
				if(c.getName().equals("user")){
					user=c.getValue();
				}
				if(c.getName().equals("password")){
					password=c.getValue();
				}
			}
		}
		if(!((user==null) || (password==null))){
					mall_forRegister mfr=new ClassPathXmlApplicationContext("applicationContext.xml").getBean("mymfr",mall_forRegister.class);
					HashMap<String, String> hmm=mfr.getMall_top().lookPassword(user);
					if(!(hmm.isEmpty())){
						if(hmm.get("PASSWORD").equals(password)){
							session.setAttribute("user", user);
							session.setAttribute("password", password);
							System.out.println("user is ok");
						}
					}
			}
		}
	
	
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		doBeforeProcessing(request);
		System.out.println("I am in firstvisit.java");
		chain.doFilter(request, response);
	}


	public void destroy() {

	}


	public void init(FilterConfig arg0) throws ServletException {

	}
}
