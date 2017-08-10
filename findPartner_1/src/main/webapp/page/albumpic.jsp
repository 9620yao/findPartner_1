<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!doctype html>
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" /><!-- 公共图标 -->
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="rel/css/albumpic.css">
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
					<h4 class="modal-title" id="myModalLabel">添加图片</h4>
				</div>
				<!-- 添加图片 start -->
				<div class="modal-body">
					<form id="fnewpic" action="albumpic/newpic" method="post"
						enctype="multipart/form-data">
						<p>
							<input id="pictrue" type="file" name="picData"
								onchange="chgPic(this)" /> <input name="strpic" class="strpic"
								type="hidden">
						</p>
						<p>
							<img src="images/not_pic.jpg" class="pic" width="100"
								height="100">
						</p>
						<p>
							<a onclick="newpic()" href="javascript:void(0)">添加</a>
						</p>
					</form>
				</div>
				<!-- 添加图片 end -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!--模态框 end  -->

	<!-- content 展示图片 srart -->
	<div class="am-g am-g-fixed blog-fixed blog-content">
		<div id="albumpicdiv">
			<div class="box">
				<div>
					<p>
						<a class="amyimg" href="page/lw-img.jsp">相册</a> | &nbsp;&nbsp;<a
							href="javascript:void(0)">当前相册</a>
						<button data-toggle="modal" data-target="#myModal"
							class="addimgbtn">上传图片</button>
					</p>
				</div>
				<div id="imgnotnull">
					<!-- 如果用户下该相册没有图片  -->
					<span>还没有图片哦~~~~~~~</span>
				</div>
				<!-- 展示相册下面的图片 -->
				<div id="imgs" class="imgs">
					<!-- <img src="images/1.jpg"> <img
						src="images/2.jpg" layer-pname="代码笔记 - 2"> <img
						src="images/3.jpg" layer-pname="代码笔记 - 3"> <img
						src="images/4.jpg" layer-pname="代码笔记 - 4"> -->
				</div>
			</div>
		</div>
	</div>
	<!-- content 展示图片 end -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script src="assets/js/amazeui.min.js"></script>
	<script src="rel/layer/jquery.js?v=1.83.min"></script>
	<script src="rel/layer/layer.min.js"></script>
	<script src="rel/js/albumpic.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>