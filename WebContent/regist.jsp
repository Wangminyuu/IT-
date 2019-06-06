<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title></title>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style_login.css"/>
<script type="text/javascript">
function checkUserNameExit(){

	 //JSON格式数据
	 $.get("${pageContext.request.contextPath }/user?method=checkUserNameExit",
	       {username:$("#username").val()},
	       function(data){
	    	
	    	   if(data=='success'){
	    		  alert("用户名已存在，请重新填写!");
	    	  }else{
	    		  alert("此用户名可以注册!");
	    	  }
	       });
 }
 </script>

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

<div class="register-container">
	<h1>注册界面</h1>
	
	<div class="connect">
		<p></p>
	</div>
	<form action="${pageContext.request.contextPath }/user?method=add" method="post" id="registerForm">
		<div>
			<input type="text" id="username" name="uname" class="username" placeholder="您的用户名" autocomplete="off"/>

		</div>
		<div>
			<input type="password" id="password" name="upass" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" id="confirm_password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="text" name="telephone" class="phone_number" placeholder="输入手机号码" autocomplete="off" id="number"/>
		</div>
		<div>
			<input type="email" name="email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false" onpaste="return false" />
		</div>

		<button id="submit" type="submit" onclick="sub()">注 册</button>
		<a href="login_login.jsp">
		<button type="button" class="register-tis">已经有账号？</button>
	</a>
	</form>
	

</div>
<script type="text/javascript">
function sub() {  
    $.ajax({  
            cache: true,  
            type:"POST",  
            url:"${pageContext.request.contextPath }/user?method=add",  
            data:$('#registerForm').serialize(),
            async: false,  
            error: function(request) {  
           		alert("注册失败！");
            },  
            success: function(data) {  
              
           	  alert("注册成功！请登录");
            $("#registerForm").html("<a href='login_login.jsp'>请登录</a>");
           //window.location.href="login_login.jsp";
          
            }  
           
        });  
   
}  
</script>

<script src="js/jquery.min.js"></script>
<script src="js/common.js"></script>
<!--背景图片自动更换-->
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<!--表单验证-->
<script src="js/jquery.validate.min.js?var1.14.0"></script>

</body>
</html>