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
<link rel="stylesheet" href="rel/css/indexcss.css">
</head>
<body id="blog">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<!-- content srart -->
	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-8 am-u-sm-12">
			<div class="alert alert-danger" role="alert">该用户已经被封禁</div>
			<!-- 个人中心和他的主页 start -->
			<div style="margin-top: 5%;" id="showspeak"></div>
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
				<img src="images/not_pic.jpg" class="pic" width="100" height="100">
				<p>个人简介</p>
				<!-- 显示个人信息 -->
				<div id="myself">
					<!--个人简介 -->
					<table style="margin-left: 10px;">
						<tr>
							<td>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;：</td>
							<td id="inickname"></td>
						</tr>
						<tr>
							<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄&nbsp;&nbsp;：</td>
							<td id="iage"></td>
						</tr>
						<tr>
							<td>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;：</td>
							<td id="ibirthday"></td>
						</tr>
						<tr>
							<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;：</td>
							<td id="igender"></td>
						</tr>
						<tr>
							<td>星&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;座&nbsp;&nbsp;：</td>
							<td id="istar"></td>
						</tr>
						<tr>
							<td>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好&nbsp;&nbsp;：</td>
							<td id="ihobby"></td>
						</tr>
						<tr>
							<td>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;：</td>
							<td id="ijob"></td>
						</tr>
						<tr>
							<td>公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;：</td>
							<td id="icompany"></td>
						</tr>
						<tr>
							<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校&nbsp;&nbsp;：</td>
							<td id="ischool"></td>
						</tr>
						<tr>
							<td>国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;籍&nbsp;&nbsp;：</td>
							<td id="iastate"></td>
						</tr>
						<tr>
							<td>现居地址：</td>
							<td id="iaddress"></td>
						</tr>
						<tr>
							<td>家&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乡&nbsp;&nbsp;：</td>
							<td id="ihometown"></td>
						</tr>
					</table>
					<button class="updatebtn" data-toggle="modal"
						data-target="#myModal">修改个人信息</button>
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
							<h4 class="modal-title" id="myModalLabel">修改个人信息</h4>
						</div>
						<!-- addInfo修改个人信息 -->
						<div id="addInfo">
							<h1 id="opt_type">修改个人信息</h1>
							<form action="user/update" id="updateUserInfo" method="post"
								enctype="multipart/form-data">
								<span style="margin-left: 3%;">个人信息：</span> <input id="aid"
									name="aid" type="text" style="display: block; margin-left: 3%;"
									readonly="readonly" />
								<ul>
									<li><input id="pictrue" type="file" name="picData"
										onchange="chgPic(this)" /><br> <img
										src="images/not_pic.jpg" class="pic" width="100" height="100"></li>
									<li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;：<input
										type="text" id="nickname" name="nickname"></li>
									<li>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄&nbsp;&nbsp;：<input
										type="text" id="age" name="age"><label id="errAge"
										style="color: red;"></label></li>
									<li>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;：<input
										type="text" id="birthday" name="birthday" class="Wdate"
										onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyyMMdd'})" /></li>
									<li>星&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;座&nbsp;&nbsp;：<input
										type="text" id="star" name="star"></li>
									<li>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好&nbsp;&nbsp;：<input
										type="text" id="hobby" name="hobby"></li>
									<li>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;：<input
										type="text" id="job" name="job"></li>
									<li>公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;：<input
										type="text" id="company" name="company"></li>
									<li>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校&nbsp;&nbsp;：<input
										type="text" id="school" name="school"></li>
									<li>现居地址：<input type="text" id="address" name="address"></li>
									<li>家&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乡&nbsp;&nbsp;：<input
										type="text" id="hometown" name="hometown"></li>
									<li>国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;籍&nbsp;&nbsp;：<input
										type="text" id="astate" name="astate"></li>
								</ul>
								<!-- <a class="updateBtn" href="javascript:void(0)">修改</a> -->
								<a onclick="updateInfo()" href="javascript:void(0)">修改</a>
							</form>
						</div>
						<!-- addInfo修改个人信息  end-->
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
			<!--模态框 end  -->

			<!-- Modal comment -->
			<div class="modal fade" id="addcoment" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<span class="modal-title" id="myModalLabel">添加评论</span>
						</div>
						<div id="comentInfo">
							<div class="showcomment"">
								<form id="faddcomment" action="comments/add" method="post">
									<input name="strcomment" class="strcomment" type="hidden">
									<input name="callid" class="callid" type="hidden"> <input
										name="detail" class="detail" type="hidden">
									<div class="democomment" contenteditable="true"></div>
									<a onclick="Getdetail()" href="javascript:void(0)">提交</a>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
			<!--模态框 end comment -->

			<!-- Modal reply -->
			<div class="modal fade" id="addreply" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<span class="modal-title" id="myModalLabel">添加回复</span>
						</div>
						<div id="comentInfo">
							<form id="rform" action="replys/add" method="post">
								<input name="strreplys" class="strreplys" type="hidden">
								<input name="rcid" class="rcid" type="hidden"> <input
									name="rtargetid" class="rtargetid" type="hidden"> <input
									name="rcontent" class="rcontent" type="hidden">
								<div class="democomment" contenteditable="true"></div>
								<a onclick="Getrcontent()" href="javascript:void(0)">提交</a>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
			<!--模态框 end reply -->

		</div>
	</div>
	<!-- content end -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script src="assets/js/amazeui.min.js"></script>
	<script src="rel/layer/jquery.js?v=1.83.min"></script>
	<script src="rel/layer/layer.min.js"></script>
	<script type="text/javascript" src="rel/js/indexpower.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</body>
</html>