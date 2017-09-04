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
<link rel="stylesheet" href="rel/css/index.css">
<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="album/css/lightgallery.css" />
<link type="text/css" rel="stylesheet" href="album/css/demo-gallery.css" />
</head>
<body id="blog">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<!-- content srart -->
	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-8 am-u-sm-12">
			<!-- 个人中心和他的主页 start -->
			<div style="margin-top: 5%;" id="showhp"></div>
			<!-- 个人中心和他的主页  end -->

			<!-- 分页显示数据 start -->
			<div id="page"></div>
			<!-- 分页显示数据 end -->
		</div>

		<div class="am-u-md-4 am-u-sm-12 blog-sidebar">
			<div class="blog-sidebar-widget blog-bor">
				<h2 class="blog-text-center blog-title">
					<span>About ME</span>
				</h2>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<span name="nickname" id="nickname"></span>
					</div>
					<br>
					<br>
					<div class="col-md-10 col-md-offset-1">
						<img src="images/timg.jpg"
							class="pic img-responsive img-thumbnail">
					</div>
					<br>
					<br>
					<div class="col-md-5 col-md-offset-5">
						<button class="updatebtn btn btn-primary" data-toggle="modal"
							data-target="#myModal">点击修改个人头像</button>
					</div>
				</div>
			</div>
			<!-- 显示个人信息 end -->
		</div>

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
						<h4 class="modal-title" id="myModalLabel">修改头像</h4>
					</div>
					<!-- addInfo修改个人信息 -->
					<div id="addInfo">
						<form action="user/update" id="updateUserInfo" method="post"
							enctype="multipart/form-data" class="form-horizontal">
							<input id="uid" name="uid" type="hidden" />
							<div class="form-group">
								<label class="col-sm-2 col-md-offset-2 control-label">头像:</label>
								<div class="col-sm-8">
									<input id="pictrue" type="file" name="picData"
										onchange="chgPic(this)" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-3 col-md-offset-3">
									<img src="images/timg.jpg"
										class="pic img-responsive img-thumbnail uimg">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-5 col-sm-offset-5">
									<button class="btn btn-default">点击确认修改</button>
								</div>
							</div>
						</form>
					</div>
					<!-- addInfo修改个人信息  end-->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>
		<!--模态框 end  -->
	</div>
	</div>
	<!-- content end -->

	<jsp:include page="/include/model.jsp" /><!-- 公共模特框 -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="assets/js/amazeui.min.js"></script>

	<script type="text/javascript" src="album/js/lightgallery.min.js"></script>
	<script type="text/javascript" src="album/js//jquery.mousewheel.min.js"></script>
	<script type="text/javascript" src="album/js/lg-thumbnail.min.js"></script>
	<script type="text/javascript" src="album/js/lg-fullscreen.min.js"></script>

	<script type="text/javascript" src="rel/js/index/first.js"></script>
	<script type="text/javascript" src="rel/js/hpindex.js"></script>
	<script type="text/javascript" src="rel/js/index/index.js"></script>

	<script type="text/javascript" src="rel/js/indexcss.js"></script>
	<jsp:include page="/include/injs.jsp"></jsp:include><!-- 公共js -->
</body>
</html>