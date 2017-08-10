<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="UTF-8">
<title>新密码</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="rel/css/forgetPassword.css">
</head>
<body>
	<div id="newPwd">
		<form action="partner/newPwd" method="post">
			<p>
				<input type="hidden" name="newemail" id="newemail" required="required"
					placeholder="请求输入找出密码邮箱" />
			</p>
			<p>
				<input type="password" name="newpwd" id="newpwd" required="required"
					placeholder="请求输入新密码" />
			</p>
			<button>修改</button>
		</form>
	</div>

	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="rel/js/newPwd.js"></script>
</body>
</html>