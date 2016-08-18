package myAction;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;




import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import myService.mall_forRegister;

public class mytop {
	

	private String user;
	private String password; 
	private String sex;
	private String profession;
	private String email;
	private String cellphone;
	
	private String myresult;

	private mall_forRegister mymfr;
	public String log_out(){
		ActionContext ac=ActionContext.getContext();
		ac.getSession().clear();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		Cookie userCookie=new Cookie("user","");
		Cookie passwordCookie =new Cookie("password","");
		userCookie.setMaxAge(0);
		passwordCookie.setMaxAge(0);
		
		userCookie.setPath("/dj/");
		passwordCookie.setPath("/dj/");
		
		response.addCookie(userCookie);
		response.addCookie(passwordCookie);
		
		
		
		
		return "success";
	}
	public String log_in() throws UnsupportedEncodingException{
		
		
		HashMap<String,String> hhm2=mymfr.getMall_top().lookPassword(user);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		
		if(hhm2==null){
			System.out.println("do not find !");
			myresult="the user does not exist";
			return "failure";
		}else{
			System.out.println(hhm2.get("PASSWORD"));
			
			if(password.equals(hhm2.get("PASSWORD"))){
				System.out.println("haahahah");
				myresult="welcome!!!"+user;
				
				ActionContext.getContext().getSession().put("user", user);
				
				Cookie userCookie=new Cookie("user",URLEncoder.encode(user, "UTF-8"));
				Cookie passwordCookie=new Cookie("password",URLEncoder.encode(password,"UTF-8"));
				
				System.out.println("haahahah");
				
				userCookie.setPath("/dj/");
				userCookie.setMaxAge(60*60);
				
				passwordCookie.setPath("/dj/");
				passwordCookie.setMaxAge(60*60);
				
				System.out.println("haahahah");
				
				response.addCookie(userCookie);
				response.addCookie(passwordCookie);
				
				
				System.out.println("haahahah");
				return "success";
			}else{
				myresult= "Password does not match user!!!";
				return "failure";
			}
			
		}
		
		
		
	}
	public String register_start(){
		
		System.out.println(user+password+sex+profession+email+cellphone);
		
		HashMap<String,String> hhm=new HashMap<String,String>();
		hhm.put("id", "9");
		hhm.put("name", user);
		hhm.put("password", password);
		hhm.put("sex", sex);
		hhm.put("profession", profession);
		hhm.put("email", email);
		hhm.put("cellphone", cellphone);
		System.out.println("2");
		System.out.println(hhm.size());
		System.out.println(hhm.get("email"));
	//	mall_forRegister mfr=new mall_forRegister();
		
		
		int i=mymfr.getMall_top().createNewUser(hhm);
		System.out.println("3");
		System.out.println(i);
		
		
		return "success";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public mall_forRegister getMymfr() {
		return mymfr;
	}

	public void setMymfr(mall_forRegister mymfr) {
		this.mymfr = mymfr;
	}
	public String getMyresult() {
		return myresult;
	}
	public void setMyresult(String myresult) {
		this.myresult = myresult;
	}

}
