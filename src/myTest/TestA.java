/**
 * 
 */
package myTest;

import java.util.HashMap;


import myService.mall_forRegister;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xjb
 * @2016骞�鏈�3鏃�
 */
public class TestA {

	/**
	 * @auth xjb
	 * @date 2016骞�鏈�3鏃�涓婂崍11:03:46
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		HashMap<String,String> hhm=new HashMap<String,String>();
		hhm.put("id", "2");
		hhm.put("name", "user");
		hhm.put("password", "password");
		hhm.put("sex", "sex");
		hhm.put("profession", "profession");
		hhm.put("email", "email");
		hhm.put("cellphone", "cellphone");
		ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
		mall_forRegister lrs = apc.getBean("mymfr",mall_forRegister.class);
		System.out.println("hello");
		
		HashMap<String,String> hhm2=lrs.getMall_top().lookPassword("EE");
		if(hhm2==null){
			System.out.println("do not find !");
		}else{
			System.out.println(hhm2.get("PASSWORD"));
		}
		
//		int i=lrs.createNewUser(hhm);
//		System.out.println(i);
		
	
	}

}
