package myAction;


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
		
		Cookie userCookie=new Cookie("user","");
		Cookie passwordCookie =new Cookie("password","");
		userCookie.setMaxAge(0);
		passwordCookie.setMaxAge(0);
		
		userCookie.setPath("/");
		passwordCookie.setPath("/");
		
		response.addCookie(userCookie);
		response.addCookie(passwordCookie);
		
		
		
		
		return "success";
	}
	public String log_in(){
		
		
		HashMap<String,String> hhm2=mymfr.getMall_top().lookPassword(user);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		
		if(hhm2==null){
			System.out.println("do not find !");
			myresult="the user does not exist";
			return "failure";
		}else{
			System.out.println(hhm2.get("PASSWORD"));
			if(password.equals(hhm2.get("PASSWORD"))){
				myresult="welcome!!!"+user;
				
				ActionContext.getContext().getSession().put("user", user);
				
				Cookie userCookie=new Cookie("user",user);
				Cookie passwordCookie=new Cookie("password",password);
				
				userCookie.setPath("/dj/");
				userCookie.setMaxAge(60*60);
				
				passwordCookie.setPath("/dj/");
				passwordCookie.setMaxAge(60*60);
				
				response.addCookie(userCookie);
				response.addCookie(passwordCookie);
				
				
				
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
