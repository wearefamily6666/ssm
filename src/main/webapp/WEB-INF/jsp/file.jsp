<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>上传文件</h1>
	<form action="/ssm/user/doUpload" enctype="multipart/form-data"
		method="post">
		用户名：<input name="username" type="text" /><br /> 
		密码：<input name="password"
			type="password" /><br />
		<textarea id="editor_id" name="content"
			style="width: 700px; height: 300px;">
	&lt;strong&gt;HTML内容&lt;/strong&gt;
</textarea>
		<input type="submit" value="上传文件" />
	</form>
	<script charset="utf-8" src="../kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
	<script>
		KindEditor.ready(function(K) {
			window.editor = K.create('#editor_id');
		});
		var editor = K.create('textarea[name="content"]', options);

		// 同步数据后可以直接取得textarea的value
		editor.sync();
		html = editor.val(); // jQuery
	</script>
</body>
</html>