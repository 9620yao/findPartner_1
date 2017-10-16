<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>LOG-IN | Find Partner</title>

<!-- Set render engine for 360 browser -->
<meta name="renderer" content="webkit">

<!-- No Baidu Siteapp-->
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="icon" type="image/png" href="assets/i/favicon.png">

<!-- Add to homescreen for Chrome on Android -->
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192" href="assets/i/app-icon72x72@2x.png">

<!-- Add to homescreen for Safari on iOS -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="FindPartner" />
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">

<!-- Tile icon for Win8 (144x144 + tile color) -->
<meta name="msapplication-TileImage"
	content="assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileColor" content="#0e90d2">

<!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
<!--
  <link rel="canonical" href="http://www.example.com/">
  -->
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
		<div class="log-re">
			<a href="page/lw-re.jsp"
				class="am-btn am-btn-default am-radius log-button">注册</a>
		</div>
	</header>

	<div class="log">
		<div class="am-g">
			<div
				class="am-u-lg-3 am-u-md-6 am-u-sm-8 am-u-sm-centered log-content">
				<h1 class="log-title am-animation-slide-top">Find Partner</h1>
				<br>
				<form class="am-form" id="log-form" action="login/login"
					method="POST">
					<div class="am-alert am-alert-danger emdiv" data-am-alert>${errorMsg}</div>
					<div class="am-input-group am-radius am-animation-slide-left">
						<input type="email" id="doc-vld-email-2-1" name="email"
							class="am-radius" data-validation-message="请输入正确邮箱地址"
							placeholder="邮箱" required /> <span
							class="am-input-group-label log-icon am-radius"><i
							class="am-icon-user am-icon-sm am-icon-fw"></i></span>
					</div>
					<br>
					<div
						class="am-input-group am-animation-slide-left log-animation-delay">
						<input type="password" class="am-form-field am-radius log-input"
							name="password" placeholder="密码" minlength="1" required>
						<span class="am-input-group-label log-icon am-radius"><i
							class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
					</div>
					<br>
					<button type="submit"
						class="am-btn am-btn-primary am-btn-block am-btn-lg am-radius am-animation-slide-bottom log-animation-delay">登
						录</button>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>

	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/app.js"></script>
	<script type="text/javascript">
		var msg = $('.emdiv').html();
		if(msg==null||msg==""){
			$('.emdiv').hide();
		}else{
			$('.emdiv').show();
		}
	</script>
</body>
</html>
