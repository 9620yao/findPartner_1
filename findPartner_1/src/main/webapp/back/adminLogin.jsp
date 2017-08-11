<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%><!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="utf-8">
<title>后台管理 | Find Partner</title>
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
</head>
<body>
	<header>
		<div class="log-header">
			<h1>
				<a href="/">Find Partner</a>
			</h1>
		</div>
	</header>
	<div class="log">
		<div class="am-g">
			<div
				class="am-u-lg-3 am-u-md-6 am-u-sm-8 am-u-sm-centered log-content">
				<h1 class="log-title am-animation-slide-top">Find Partner</h1>
				<br>
				<form class="am-form" id="log-form" action="admin/adminLogin"
					method="POST">
					<p>
						<label style="color: red;">${errorMsg}&nbsp;</label>
					</p>
					<div class="am-input-group am-radius am-animation-slide-left">
						<input type="email" id="doc-vld-email-2-1" name="baemail"
							class="am-radius" data-validation-message="请输入正确邮箱地址"
							placeholder="邮箱" required /><span
							class="am-input-group-label log-icon am-radius"><i
							class="am-icon-user am-icon-sm am-icon-fw"></i></span>
					</div>
					<br>
					<div
						class="am-input-group am-animation-slide-left log-animation-delay">
						<input type="password" class="am-form-field am-radius log-input"
							name="bapwd" placeholder="密码" minlength="1" required><span
							class="am-input-group-label log-icon am-radius"><i
							class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
					</div>
					<br>
					<button type="submit"
						class="am-btn am-btn-primary am-btn-block am-btn-lg am-radius am-animation-slide-bottom log-animation-delay">登
						录</button>
					<p class="am-animation-slide-bottom log-animation-delay"></p>
					<div
						class="am-btn-group  am-animation-slide-bottom log-animation-delay-b">
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
</body>
</html>