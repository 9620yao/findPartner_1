<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!doctype html>
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" /><!-- 公共图标 -->
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="rel/css/new-imgs.css">
<link rel="stylesheet" href="rel/css/indexcss.css">
</head>
<body id="blog-article-sidebar">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<!-- content srart -->
	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-8 am-u-sm-12">
			<article class="am-g blog-entry-article">
				<!-- 修改密码 start -->
				<div style="margin-left: 10%;" id="modifyPwd">
					<form class="fmodifyPwd" method="post" id="modifyForm"
						action="user/mofifyPwd">
						<p>
							<label style="color: red;">${errorpwd}&nbsp;</label>
						</p>
						<p>
							<input name="strmdpwd" class="strmdpwd" type="hidden"><input
								style="margin-left: 2%;" type="hidden" id="email" name="email"
								value="${loginUser.email }">
						</p>
						<p>
							<label for="password">原密码：</label><input style="margin-left: 2%;"
								type="password" id="password" name="password"
								placeholder="请输入原密码" required="required">
						</p>
						<p>
							<label for="newPassword">新密码：</label><input
								style="margin-left: 2%;" type="password" id="newPassword"
								name="newPassword" placeholder="请输入新密码" required="required">
						</p>
						<p>
							<a style="margin-left: 3%;" href="javascript:void(0)"
								onclick="strupdate()">修改</a> <a class="rback"
								style="margin-left: 3%;" href="page/lw-index.jsp">退出</a>
					</form>
				</div>
				<!-- 修改密码  end -->
			</article>
		</div>
	</div>

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	<script src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="rel/js/modifyPwd.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>