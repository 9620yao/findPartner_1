<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<jsp:include page="/include/Icon.jsp" /><!-- 加载公共图标 -->
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="rel/css/indexcss.css">
</head>

<body id="blog-article-sidebar">
	<jsp:include page="/include/header.jsp" /><!-- 加载公共头部 -->
	<!-- content srart -->
	<div style="margin-left: 200px;">
		<div id="divmyfriend" style="width: 900px; height: 800px;">
			<!-- 好友列表 -->
		</div>
	</div>
	<!-- content end -->
	<footer class="blog-footer">
		<div
			class="am-g am-g-fixed blog-fixed am-u-sm-centered blog-footer-padding">
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h3>模板简介</h3>
				<p class="am-text-sm">
					这是一个使用amazeUI做的简单的前端模板。<br> 博客/ 资讯类 前端模板 <br>
					支持响应式，多种布局，包括主页、文章页、媒体页、分类页等<br>嗯嗯嗯，不知道说啥了。外面的世界真精彩<br> <br>
					Amaze UI 使用 MIT 许可证发布，用户可以自由使用、复制、修改、合并、出版发行、散布、再授权及贩售 Amaze UI
					及其副本。
				</p>
			</div>
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h3>社交账号</h3>
				<p>
					<a href=""><span
						class="am-icon-qq am-icon-fw am-primary blog-icon blog-icon"></span></a>
					<a href=""><span
						class="am-icon-github am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-weibo am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-reddit am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-weixin am-icon-fw blog-icon blog-icon"></span></a>
				</p>
				<h3>Credits</h3>
				<p>我们追求卓越，然时间、经验、能力有限。Amaze UI
					有很多不足的地方，希望大家包容、不吝赐教，给我们提意见、建议。感谢你们！</p>
			</div>
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h1>我们站在巨人的肩膀上</h1>
				<h3>Heroes</h3>
				<p>
				<ul>
					<li>jQuery</li>
					<li>Zepto.js</li>
					<li>Seajs</li>
					<li>LESS</li>
					<li>...</li>
				</ul>
				</p>
			</div>
		</div>
		<div class="blog-text-center">© 2015 AllMobilize, Inc. Licensed
			under MIT license. Made with love By LWXYFER</div>
	</footer>


	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
	<script src="assets/js/amazeui.min.js"></script>
	<script src="assets/js/pinto.min.js"></script>
	<script src="assets/js/img.js"></script>
	<script src="rel/js/friend.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>
