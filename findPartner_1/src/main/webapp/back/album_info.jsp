<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="UTF-8">
<title>说说管理</title>
</head>
<body>
	<div id="searchAlbum">
		<input id="AlbumselectName" value="姓名/时间查询">
		<input id="paramterA" name="paramter">
		<input value="查询" type="button" onclick="unclearQueryAlbum()"/>
	</div>
	<table id="albumInfo"></table>
	<div id="albumDetail">
		<form action="#" method="post">
			<p>
				<label> 编号</label> <input id="iabid"/>
			</p>
			
			<p>
				<label> 相册名称 </label> <input id="iabname" />
			</p>
			<p>
				<label> 相册发布人 </label> <input id="iaaid" />
			</p>
			<p>
				<label> 内容 </label>
				<div id="ialcontent" style="width: 400px; height: 100px; border: 1px solid gray; overflow: scroll;"></div>
			</p>
			
			<p>
				<label> 地址 </label><input id="iallocation" />
			</p>
			<p>
				<label> 日期 </label><input id="ialdate" />
			</p>
			
			<p>
				<label> 相册封面</label>
				<img src="" style="width:100px;height:100px" id="iaheader">
			</p>
		</form>
	</div>
	<script type="text/javascript" src="rel/js/album_info.js"></script>
</body>
</html>