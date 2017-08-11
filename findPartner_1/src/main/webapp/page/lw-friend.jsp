<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" /><!-- 公共图标 -->
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="rel/css/indexcss.css">
</head>
<body id="blog-article-sidebar">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<!-- content srart -->
	<div style="margin-left: 200px;">
		<div id="divmyfriend" style="width: 900px; height: 800px;">
			<!-- 好友列表 -->
		</div>
	</div>
	<!-- content end -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/pinto.min.js"></script>
	<script src="assets/js/img.js"></script>
	<script src="rel/js/friend.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>
