<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
课堂笔记网址：androidxx.cn
</h1>

<form action="/androidxx/upload.do" method="post" enctype="multipart/form-data">
	用户名：<input type="text" name="username"/>
	密码：<input type="password" name="password"/>
	文件上传:<input type="file" name="upload"/><br/><br/>
	<input type="submit" value="上传"/>
</form>

</center>
</body>
</html>