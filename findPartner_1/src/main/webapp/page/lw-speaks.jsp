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

	<!-- Modal comment -->
	<div class="modal fade" id="addcoment" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog" style="width: 50%;">
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
						<form id="faddcomment">
							<input name="callid" class="callid" type="hidden"> <input
								name="detail" class="detail" type="hidden"> <input
								name="s_uuid" class="s_uuid" type="hidden">
							<div class="democomment" contenteditable="true"></div>
							<a href="javascript:Getdetail()" class="btnclose">提交</a>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
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
					<form id="rform" method="post">
						<input name="rcid" class="rcid" type="hidden"> <input
							name="rtargetid" class="rtargetid" type="hidden"> <input
							name="rcontent" class="rcontent" type="hidden">
						<div class="democomment" contenteditable="true"></div>
						<a href="javascript:Getrcontent()" class="btnclose">提交</a>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!--模态框 end reply -->

	<jsp:include page="/include/foot.jsp" /><!-- 公共底部部分 -->

	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="bootstrap-paginator/bootstrap-paginator.js"></script>

	<script src="assets/js/amazeui.min.js"></script>
	<script src="rel/ueditor/ueditor.config.js"></script>
	<script src="rel/ueditor/ueditor.all.min.js"></script>
	<script src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>

	<script type="text/javascript" src="rel/js/uedit/uedit.js"></script>
	<script type="text/javascript" src="rel/js/speaks.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
	<jsp:include page="/include/injs.jsp"></jsp:include>
</body>
</html>