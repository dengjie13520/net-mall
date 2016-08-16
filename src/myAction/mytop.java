package myAction;


import java.util.HashMap;
import myService.mall_forRegister;

public class mytop {
	

	private String user;
	private String password; 
	private String sex;
	private String profession;
	private String email;
	private String cellphone;

	private mall_forRegister mymfr;
	public String log_in(){
		
		
		
		return "success";
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

}
