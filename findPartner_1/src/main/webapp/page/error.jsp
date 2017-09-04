<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" />
<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap.min.css">
<!-- 公共图标 -->
<title>错误页面</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-sm-10">
					<h1 class="hd page-header">系统错误!</h1>
				</div>
				<div class="col-sm-10 col-md-offset-1">
					<span>
						<h3>Sorry</h3>
					</span>
				</div>
				<div class="col-sm-10 col-md-offset-2">
					<br>首先，对于给您造成的不便，我们致于珍重的歉意。 <br>对于您的问题，我们的后方程序员正在努力,<br>我们将在第一时间内解决您的问题.
					<br>若有其他问题<br>或者想法以及您的宝贵意见<br>请联系我们：<br>
					<span id="basic-addon2">15675456193@163.com</span>
				</div>
				<div class="col-sm-10 col-md-offset-1">
					<br>
					<h2>
						<a href="page/lw-log.jsp">Sorry，点击进入登录页面</a>
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-8 col-md-offset-2">
			<h3>错误信息:</h3>
			<div class="col-sm-10">
				<span style="color: red;">${ex.message }</span>
			</div>
		</div>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>