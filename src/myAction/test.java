package myAction;

import java.util.HashMap;

import myEntity.Myperson;
import myService.mall_forRegister;

public class test {
	private Myperson myperson;
	private mall_forRegister mymfr;
	private String user;
	private String password;
	public String showperson(){
		System.out.println(myperson.getAge());
		System.out.println(myperson.getName());
		HashMap<String,String> hhm=new HashMap<String,String>();
		hhm.put("id", "80");
		hhm.put("name", user);
		hhm.put("password",password);
		hhm.put("sex", "sex");
		hhm.put("profession", "profession");
		hhm.put("email", "email");
		hhm.put("cellphone", "cellphone");
		mymfr.getMall_top().createNewUser(hhm);
		return "success";
	}
	public Myperson getMyperson() {
		return myperson;
	}
	public void setMyperson(Myperson myperson) {
		this.myperson = myperson;
	}
	public mall_forRegister getMymfr() {
		return mymfr;
	}
	public void setMymfr(mall_forRegister mymfr) {
		this.mymfr = mymfr;
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

}
