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
<link rel="stylesheet" href="rel/css/indexcss.css">
</head>
<body>
	<jsp:include page="/include/header.jsp" /><!-- 公共头部部分 -->

	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-12 am-u-sm-12">
			<div>
				<article class="am-g blog-entry-article">
					<div style="margin-left: 2.5%; width: 60%;">
						<span><span class="spanword">我的</span>留言(<a
							href="javascript:void(0)" class="spcount">0</a>)</span>
						<hr
							style="height: 1px; border: none; border-top: 1px solid #555555;" />
					</div>
					<div id="divword" style="width: 60%; margin-left: 2.5%;">
						<span>发表您的留言</span>
						<div style="margin-top: 3%;">
							<form id="myword" method="post" action="words/add">
								<textarea id="ueditor" name="ueditor" rows="3" cols="39"
									placeholder="发表一个留言"></textarea>
								<input name="waid" class="waid" type="hidden"> <input
									name="strword" class="strword" type="hidden"> <input
									name="wcontent" id="wcontent" type="hidden"> <a
									onclick="addword()" class="speakbtn">发表</a>
							</form>
						</div>
					</div>
				</article>
			</div>

			<!-- 留言 start -->
			<div id="hostAll" style="margin-top: 2.5%;"></div>
			<!-- 留言 end -->

			<!-- 分页 start -->
			<div style="margin-left: 20%; margin-top: 3%;" id="page"></div>
			<!-- 分页 end -->
		</div>
		<div id="page"></div>
	</div>


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
					<div class="showcomment">
						<form id="faddcomment" action="comments/add" method="post">
							<input name="strcomment" class="strcomment" type="hidden" /> <input
								name="callid" class="callid" type="hidden" /> <input
								name="detail" class="detail" type="hidden" />
							<div class="democomment" contenteditable="true"></div>
							<a onclick="Getdetail()" href="javascript:void(0)">提交</a>
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
					<form id="rform" action="replys/add" method="post">
						<input name="strreplys" class="strreplys" type="hidden"> <input
							name="rcid" class="rcid" type="hidden"> <input
							name="rtargetid" class="rtargetid" type="hidden"> <input
							name="rcontent" class="rcontent" type="hidden">
						<div class="democomment" contenteditable="true"></div>
						<a onclick="Getrcontent()" href="javascript:void(0)">提交</a>
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

	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="rel/js/message.js"></script>
	<script type="text/javascript" src="rel/js/indexcss.js"></script>
</body>
</html>