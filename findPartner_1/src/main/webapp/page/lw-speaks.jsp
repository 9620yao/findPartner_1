<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" /><!-- 公共图标 -->
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="rel/css/speak.css">
<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body id="blog">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<!-- content srart -->
	<!-- <!-- 添加说说 -->
	<div id="addSpeaks"></div>
	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-12 am-u-sm-12">
			<div>
				<article class="am-g blog-entry-article">
					<div class="countdiv">
						<span><span class="spanspeak">我的</span>说说(<a
							href="javascript:void(0)" class="spcount">0</a>)</span>
						<hr
							style="height: 1px; border: none; border-top: 1px solid #555555;" />
					</div>
					<div class="editdiv">
						<form id="myspeak">
							<textarea id="ueditor" name="ueditor" rows="4" cols="39"
								placeholder="发表一个说说"></textarea>
							<a href="javascript:void(0)" onclick="return addSpeak();">发表</a>
						</form>
					</div>
				</article>
			</div>

			<!-- 显示说说 start -->
			<div id="speaksInfo"></div>
			<!-- 显示说说 end -->
		</div>
		<!-- 分页 -->
		<ul id="page">
		</ul>
	</div>
	<!-- content end -->

	<jsp:include page="/include/model.jsp" /><!-- 公共模特框 -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="bootstrap-paginator/bootstrap-paginator.js"></script>

	<script src="assets/js/amazeui.min.js"></script>
	<script src="rel/ueditor/ueditor.config.js"></script>
	<script src="rel/ueditor/ueditor.all.js"></script>
	<script src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>

	<script type="text/javascript" src="rel/js/index/first.js"></script>
	<script type="text/javascript" src="rel/js/uedit/uedit.js"></script>
	<script type="text/javascript" src="rel/js/speaks.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
	<jsp:include page="/include/injs.jsp"></jsp:include>
</body>
</html>