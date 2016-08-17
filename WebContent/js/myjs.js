//link register

function my_register(){
	//alert("hello");
	$.get("./html/register.html",function(data,status){
		$("#mall_middle").html(data);
	});
}
//log in
function my_login(){
	$.get("./html/login.html",function(data,status){
		$("#mall_middle").html(data);
	});
}

function log_start(){
	var user=$("#login_user").val();
	var password=$("#login_password").val();
	$.post("log_in.action",{user:user,password:password},function(data,status){
		$("#mall_middle").html(data);
	});
	
}
//email verification
function email_yz(myf){
	if(myf.value==""){
		alert("not empty!");
		return null;
	}else if(!/^\w+@\w+.\w+$/.test(myf.value)){
		alert("email format is wrong");
		myf.focus();
		myf.select();
		return null;
	}
}
			
//create a new user
function register_start(){
	var sex=$("input:checked[name='register_sex']").val();
	var profession=$("input:checked[name='register_profession']").val();
	
	var user=$("#register_user").val();
	var password=$("#register_password").val();
	
	var email=$("#register_email").val();
	var cellphone=$("#register_cellphone").val();
	
	$.post("register.action",{
		user:user,
		password:password,
		sex:sex,
		profession:profession,
		email:email,
		cellphone:cellphone
	},function(data,status){
		$("#mall_middle").html(data);
	});

}
//test
function test(){
	
//	$.get("test.action",function(data,status){
//		$("#mall_middle").html(data);
//	});
	
	$.post("test.action",{
		user:"haha",
		password:"123"
	
	},function(data,status){
		$("#mall_middle").html(data);
	});
}

