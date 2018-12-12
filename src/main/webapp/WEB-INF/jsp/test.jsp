<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <p>${requestScope.name }</p>
        <p>${requestScope.time }</p>
        <p>${sessionScope.ss }</p>
        <p>${applicationScope.aa }</p>
		<button>点击</button>
		<form action="/ssm/user/testForm" method="post" enctype="multipart/form-data">
		用户名：	<input type="text" name="username"/>
			密码：<input type="password" name="password"/>
			文件一：<input type="file" name="files"/>
			文件二：<input type="file" name="files"/>
			<input type="submit"/>
		</form>
	 <script type="text/javascript" src="/ssm/js/jquery-1.11.1.js"></script>
	 <script type="text/javascript" src="/ssm/js/jquery-1.11.1.min.js"></script>
	 <script type="text/javascript">
	 $(document).ready(function(){
		 $("button").click(function(){
			 var mydate = new Date();
	        $.post("/ssm/user/getTime",{time:mydate.getTime()},function(data){
	        	console.log(data)
	             });   
	         });
	 })
	 </script>
</body>
</html>