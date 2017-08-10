<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" /><!-- 公共图标 -->
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" href="rel/css/indexcss.css">
<link type="text/css" rel="stylesheet" href="rel/css/forgetPassword.css">
</head>
<body>
	<div id="forgrtPwdDiv">
		<form action="partner/forget" id="forgetForm" method="post">
			<p>
				<label style="color: red;" id="laerror">${errorEmail}</label>
			</p>
			<p>
				<input type="email" name="email" id="email" required="required"
					placeholder="请求输入找出密码邮箱" />
			</p>
			<p>
				<input name="vcode" type="text" class="Mail" placeholder="请输入验证码"
					required="required" />
			</p>
			<p>
				<a href="javascript:void(0)"
					style="display: block; border: 1px solid #ffffff; width: 100px"
					class="sendMail" onclick="sendMail()">发送邮件</a>
			</p>
			<p>
				<button>找回密码</button>
			</p>
		</form>
	</div>


	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
	<script type="text/javascript" src="rel/js/forgetPassword.js"></script>
</body>
</html>