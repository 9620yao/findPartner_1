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
<link rel="stylesheet" href="rel/css/indexcss.css">
</head>
<body id="blog-article-sidebar">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新建相册</h4>
				</div>
				<!-- 新建相册 start -->
				<div style="margin-left: 3%;" id="builtimgs">
					<form id="alform" action="album/newimgs" method="post">
						<p>
							<input name="abname" placeholder="标题" type="text"
								required="required"> <input name="alcontent"
								class="alcontent" type="hidden"> <input name="strimg"
								class="strimg" type="hidden"> <input name="aaid"
								class="aaid" type="hidden">
						</p>
						<p>
							<textarea id="ueditor" name="ueditor" rows="2" cols="30"
								placeholder="描述"></textarea>
						</p>
						<p>
							<a href="javascript:void(0)" onclick="addAlbum()">添加</a>
						</p>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!--模态框 end  -->


	<!-- content srart data-am-figure="{  pureview: 'true' }" -->
	<div class="am-g am-g-fixed blog-fixed blog-content">
		<div style="margin-left: 2.5%; width: 60%;">
			<span><span class="spanimg">我的</span>相册(<a
				href="javascript:void(0)" class="spcount">0</a>)</span>
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />
		</div>
		<button class="addimgs" data-toggle="modal" data-target="#myModal"
			style="width: 8%; margin-left: 5%;">创建相册</button>
		<div id="container"
			style="margin-top: 5%; font-size: 18px; margin-left: 5%;">
			<!-- 如果用户没有相册  -->
			<span>还没有相册哦~~~~~~~</span>
		</div>
	</div>
	<!-- content end -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script src="rel/js/imgs.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>