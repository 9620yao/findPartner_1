<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<!doctype html>
<html>
<head>
</head>
<body id="blog-article-sidebar">

	<!-- content srart -->
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


	<script type="text/javascript" src="rel/js/modifyPwd.js"></script>
</body>
</html>