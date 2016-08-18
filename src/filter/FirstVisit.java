package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
	private void doBeforeProcessing(ServletRequest request) throws UnsupportedEncodingException{
		HttpSession session =((HttpServletRequest)request).getSession();
		Cookie[] cookies=((HttpServletRequest)request).getCookies();
		String user=null;
		String password =null;
		if(cookies !=null){
			for(Cookie c:cookies){
//				String myName=URLEncoder.encode(c.getValue(), "UTF-8");
//				System.out.println(c.getName()+"----"+myName);
//				myName=URLDecoder.decode(c.getValue(), "UTF-8");
//				System.out.println(c.getName()+"----"+myName);
				String myName=URLDecoder.decode(c.getValue(), "UTF-8");
				
				System.out.println(c.getName()+"----"+myName);
				if(c.getName().equals("user")){
					user=myName;
				}
				if(c.getName().equals("password")){
					password=myName;
				}
			}
		}
		if(!((user==null) || (password==null))){
					mall_forRegister mfr=new ClassPathXmlApplicationContext("applicationContext.xml").getBean("mymfr",mall_forRegister.class);
					HashMap<String, String> hmm=mfr.getMall_top().lookPassword(user);
					if(!(hmm==null)){
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
