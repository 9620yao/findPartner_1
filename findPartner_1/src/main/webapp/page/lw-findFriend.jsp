<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" /><!-- 加载公共图标 -->
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="rel/css/indexcss.css">
</head>

<body id="blog-article-sidebar">
	<jsp:include page="/include/header.jsp" /><!-- 加载公共头部 -->
	<!-- content srart -->
	<a href="javascript:void(0)" style="margin-left: 100px; color: red;"
		onclick="friendIntro()">系统推荐好友</a>
	<br />
	<a href="javascript:void(0)" style="margin-left: 100px; color: red;"
		onclick="friendKnow()">可能认识的人</a>
	<br />
	<div id="RequestFriend"></div>
	<div style="margin-left: 400px;">
		<!-- 推荐好友 -->

		<div id="friend"
			style="width: 900px; height: 900px; border-collapse: separate; border-spacing: 0px 15px;">

		</div>
	</div>
	<!-- content end -->
	<!-- 加载公共foot start-->
	<jsp:include page="/include/foot.jsp"></jsp:include>
	<!-- 加载公共foot end-->


	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/pinto.min.js"></script>
	<script src="assets/js/img.js"></script>
	<script type="text/javascript" src="rel/js/findFriends.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>