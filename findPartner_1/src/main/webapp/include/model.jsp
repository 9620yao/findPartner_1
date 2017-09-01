<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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