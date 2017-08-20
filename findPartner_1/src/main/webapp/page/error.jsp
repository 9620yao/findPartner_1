<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" />	<!-- 公共图标 -->
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<title>错误页面</title>
</head>
<body>
	<h1>ERROR!</h1>
	<br> message:
	<span style="border-color: red;">${ex.message }</span>
	
	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script src="assets/js/amazeui.min.js"></script>
</body>
</html>