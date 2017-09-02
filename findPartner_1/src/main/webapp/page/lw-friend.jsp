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
<link rel="stylesheet" href="rel/css/dashboard.css">
<link rel="stylesheet" href="rel/css/friend.css">
</head>
<body id="blog-article-sidebar">
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module">
					<ol class="list-unstyled">
						<li><a href="javascript:reload()">好友首页</a></li>
						<li><a href="javascript:loadPage('page/seekfriend.jsp')">寻找好友</a></li>
						<li><a href="javascript:getrel()">好友请求(<span class="rc">0</span>)</a></li>
						<li><a href="javascript:friendKnow()">可能认识的人</a></li>
					</ol>
				</div>
			</div>
			<div class="col-sm-8 main">
				<!-- 中间第一模块刷 start -->
				<div class="other">
					<h3 class="hd page-header">我的好友</h3>
					<div class="table-responsive">
						<table class="ta table table-striped">
							<thead>
								<tr>
									<th>头像</th>
									<th>昵称</th>
									<th class="threl">账号</th>
								</tr>
							</thead>
							<tbody class="divtable"></tbody>
						</table>
						<!-- 分页 -->
						<ul id="page">
						</ul>
					</div>
				</div>
				<!-- 中间第一模块刷 end -->
			</div>
		</div>
	</div>
	
	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="bootstrap-paginator/bootstrap-paginator.js"></script>

	<script src="assets/js/amazeui.min.js"></script>

	<script type="text/javascript" src="rel/js/index/first.js"></script>
	<script src="rel/js/friend/friend.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>
