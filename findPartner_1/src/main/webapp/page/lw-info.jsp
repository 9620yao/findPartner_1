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
<link rel="stylesheet" type="text/css"
	href="distpicker-master/css/main.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
</head>
<body id="blog-article-sidebar">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<div class="row">
		<div class="col-xs-2 col-xs-offset-1">
			<ul id="myTab" class="nav nav-pills nav-stacked">
				<li class="active"><a href="#basicinfo" data-toggle="tab">基本资料</a></li>
				<li><a href="#modifpwd" data-toggle="tab">修改密码</a></li>
			</ul>
			<!-- <div class="sidebar-module">
					<ol class="list-unstyled">
						<li><a href="javascript:reload()">基本资料</a></li>
						<li><a href="javascript:loadPage('page/info-modifyPwd.jsp')">修改密码</a></li>
					</ol>
				</div> -->
		</div>
		<div class="col-xs-9 tab-content" id="myTabContent">
			<!-- 中间第一模块刷 start -->
			<div class="tab-pane fade in active" id="basicinfo">
				<h3 class="hd">基本资料</h3>
				<form class="form-horizontal uform" action="user/change"
					method="post">
					<div>
						<div class="form-group">
							<label for="nickname" class="col-sm-1 control-label">昵称：</label>
							<div class="col-sm-3">
								<input name="nickname" id="nickname" class="form-control"
									type="text" placeholder="用户昵称..">
							</div>
							<label for="email" class="col-sm-1 col-md-offset-2 control-label">Email：</label>
							<div name="email" id="email" class="col-sm-4">
								<p class="form-control-static"></p>
							</div>
							<input name="lid" id="lid" type="hidden">
						</div>
						<div class="form-group">
							<label for="uname" class="col-sm-1 control-label">姓名：</label>
							<div class="col-sm-3">
								<input id="uname" name="uname" class="form-control" type="text"
									placeholder="真实姓名..">
							</div>
							<label class="col-sm-1 col-md-offset-2 control-label">年龄：</label>
							<div class="col-sm-4">
								<p id="age" name="age" class="form-control-static">21</p>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-1 control-label">iPhone：</label>
							<div class="col-sm-3">
								<input id="phone" name="phone" class="form-control" type="text"
									placeholder="联系电话..">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label">性别：</label>
							<div class="col-sm-3 opdiv">
								<label class="radio-inline"> <input type="radio"
									name="inlineRadioOptions" id="inlineRadio1" value="男">
									男
								</label> <label class="radio-inline"> <input type="radio"
									name="inlineRadioOptions" id="inlineRadio2" value="女" checked>
									女
								</label> <input name="gender" id="gender" type="hidden">
							</div>
						</div>
						<!-- 日期start	 -->
						<div class="form-group">
							<label for="dtp_input2" class="col-sm-1 control-label">生日：</label>
							<div class="col-sm-3 input-group date form_date" data-date=""
								data-date-format="yyyy mm dd" data-link-field="dtp_input2"
								data-link-format="yyyy-mm-dd">
								<input class="form-control birthday1" type="text" readonly>
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-remove"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-calendar"></span></span>
							</div>
							<input type="hidden" name="birthday" class="birthday"
								id="dtp_input2" value="1111-1-1" />
						</div>
						<!-- 日期 end	 -->
						<div class="form-group">
							<label for="star" class="col-sm-1 control-label">星座：</label>
							<div class="col-sm-3">
								<!-- <select class="col-sm-4 hprovince" name="star" required></select> -->
								<input id="star" name="star" class="form-control" type="text"
									placeholder="星座..">
							</div>
						</div>
						<div class="form-group">
							<label for="company" class="col-sm-1 control-label">公司：</label>
							<div class="col-sm-5">
								<input id="company" name="company" class="form-control"
									type="text" placeholder="公司...">
							</div>
						</div>
						<div class="form-group">
							<label for="job" class="col-sm-1 control-label">职位：</label>
							<div class="col-sm-5">
								<input id="job" name="job" class="form-control" type="text"
									placeholder="职位...">
							</div>
						</div>
						<div class="form-group">
							<label for="school" class="col-sm-1 control-label">学校：</label>
							<div class="col-sm-5">
								<input id="school" name="school" class="form-control"
									type="text" placeholder="学校..">
							</div>
						</div>
						<div class="form-group">
							<label for="hobby" class="col-sm-1 control-label">爱好：</label>
							<div class="col-sm-5">
								<input id="hobby" name="hobby" class="form-control" type="text"
									placeholder="爱好...">
							</div>
						</div>
						<!-- 省市县 start -->
						<div class="form-group">
							<label class="col-sm-1 control-label">家乡：</label>
							<div class="col-sm-6 hometown" id="distpicker"
								data-toggle="distpicker">
								<select class="col-sm-4 hprovince" required></select> <select
									class="col-sm-4 hcity" required></select> <select
									class="col-sm-4 hdistrict" required></select>
							</div>
							<input name="hprovince" id="hprovince" type="hidden"> <input
								name="hcity" id="hcity" type="hidden"> <input
								name="hdistrict" id="hdistrict" type="hidden"> <input
								id="hometown" type="hidden">
						</div>
						<!-- 省市县 end -->
						<!-- 省市县 start -->
						<div class="form-group">
							<label class="col-sm-1 control-label">住址：</label>
							<div class="col-sm-6 address" id="distpicker"
								data-toggle="distpicker">
								<select class="col-sm-4 province" required></select> <select
									class="col-sm-4 city" required></select> <select
									class="col-sm-4 district" required></select>
							</div>
							<input name="province" id="province" type="hidden"> <input
								name="city" id="city" type="hidden"> <input
								name="district" id="district" type="hidden"> <input
								id="address" type="hidden">
						</div>
						<!-- 省市县 end -->
					</div>
					<div class="form-group mgdiv">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<span class="mg"></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-5 col-sm-5">
							<span onclick="update()" class="btn btn-default btna">保存修改</span>
							<!-- <button class="btn btn-default btna">保存修改</button> -->
						</div>
					</div>
				</form>
			</div>
			<div class="tab-pane fade" id="modifpwd">
				<div class="am-g am-g-fixed blog-fixed">
					<div class="am-u-md-8 am-u-sm-12">
						<article class="am-g blog-entry-article">
							<!-- 修改密码 start -->
							<div id="modifyPwd">
								<form class="fmodifyPwd form-horizontal" method="post"
									id="modifyForm" action="login/modifyPwd">
									<div class="form-group">
										<div class="alert alert-danger mgdiv" role="alert">${errorpwd}</div>
										<label class="col-sm-2 control-label">Email：</label>
										<div class="col-sm-4">
											<p class="form-control-static" id="email">${loginUser.email}</p>
										</div>
										<input name="lid" id="lid" type="hidden">
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-2 control-label">原密码：</label>
										<div class="col-sm-5">
											<input type="password" id="password" name="password"
												class="form-control" placeholder="请输入原密码....."
												required="required">
										</div>
									</div>
									<div class="form-group">
										<label for="newPassword" class="col-sm-2 control-label">新密码：</label>
										<div class="col-sm-5">
											<input type="password" id="newPassword" name="newPassword"
												class="form-control" placeholder="请输入新密码....."
												required="required">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-5">
											<a href="javascript:void(0)" onclick="strupdate()"
												class="btn btn-primary">修改</a>
										</div>
									</div>
								</form>
							</div>
							<!-- 修改密码  end -->
						</article>
					</div>
				</div>
			</div>
			<!-- 中间第一模块刷 end -->
		</div>
	</div>
	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="validate/jquery.validate.min.js"></script>
	<script src="validate/messages_zh.min.js"></script>
	<script src="validate/additional-methods.js"></script>
	<script src="assets/js/amazeui.min.js"></script>

	<script src="distpicker-master/js/distpicker.js"></script>
	<script src="distpicker-master/js/main.js"></script>
	<script
		src="bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src="bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="bootstrap-datetimepicker-master/datetimepicker.js"></script>

	<script type="text/javascript" src="rel/js/index/first.js"></script>
	<script src="rel/js/info.js"></script>
	<script type="text/javascript" src="rel/js/modifyPwd.js"></script>
	<!-- <script type="text/javascript" src="rel/js/indexcss.js"></script> -->
</body>
</html>
