<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<jsp:include page="/include/Icon.jsp" /><!-- 公共图标 -->
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="rel/css/message.css">
</head>
<body>
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-12 am-u-sm-12">
			<div>
				<article class="am-g blog-entry-article">
					<div class="wc">
						<span><span class="spanword">我的</span>留言(<a
							href="javascript:void(0)" class="spcount">0</a>)</span>
						<hr class="whr" />
					</div>
					<div id="divword">
						<span>发表您的留言</span>
						<div style="margin-top: 3%;">
							<form id="myword">
								<textarea id="ueditor" name="ueditor" rows="3" cols="39"
									placeholder="发表一个留言"></textarea>
								<input name="waid" class="waid" type="hidden"> <input
									name="wcontent" id="wcontent" type="hidden"> <a
									href="javascript:addword()" class="speakbtn">发表</a>
							</form>
						</div>
					</div>
				</article>
			</div>

			<!-- 留言 start -->
			<div id="hostAll"></div>
			<!-- 留言 end -->

			<!-- 分页 start -->
			<ul id="page">
			</ul>
			<!-- 分页 end -->
		</div>
		<div id="page"></div>
	</div>


	<jsp:include page="/include/model.jsp" /><!-- 公共模特框 -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="bootstrap-paginator/bootstrap-paginator.js"></script>

	<script src="rel/ueditor/ueditor.config.js"></script>
	<script src="rel/ueditor/ueditor.all.js"></script>
	<script src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/amazeui.min.js"></script>

	<script type="text/javascript" src="rel/js/index/first.js"></script>
	<script type="text/javascript" src="rel/js/uedit/uedit.js"></script>
	<script type="text/javascript" src="rel/js/message.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
	<jsp:include page="/include/injs.jsp"></jsp:include>
</body>
</html>