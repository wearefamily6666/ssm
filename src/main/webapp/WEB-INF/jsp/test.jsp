<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <p>${username }</p>
<p>${age }</p>
        <p>${requestScope.name }</p>
        <p>${requestScope.time }</p>
        <p>${sessionScope.ss }</p>
        <p>${applicationScope.aa }</p>
		<button>点击</button>
 		<form action="testForm" method="post" enctype="multipart/form-data">
		用户名：	<input type="text" name="username"/>
			密码：<input type="password" name="password"/>
			文件一：<input type="file" name="files"/>
			文件二：<input type="file" name="files"/>
			<input type="submit"/>
		</form> --%>  
         <h3>el表达式使用empty运算符检查对象是否为null(空)</h3>
 
    <%--使用empty运算符检查对象是否为null(空) --%>
        <c:forEach var="str" items="${list}">
            ${str}<br/>
        </c:forEach>
 <% 
        session.setAttribute("user","张三");
    %>
    ${user==null? "对不起，您没有登陆 " : sessionScope.user}
 
    <%--使用empty运算符检查对象是否为null(空) --%>
    <c:if test="${empty(list)}">
        对不起，没有您想看的数据
    </c:if>
    
  ${pageContext }
       <input type="radio" name="gender" value="male" ${gender=='male'?'checked':''}>男
       <input type="radio" name="gender" value="female" ${gender=='female'?'checked':''}>女
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