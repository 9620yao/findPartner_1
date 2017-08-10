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
		<input id="AlbumselectCount" value="姓名查询">
		<input id="paramterAC" name="paramter">
		<input value="查询" type="button" onclick="unclearQueryAlbumCount()"/>
	</div>
	<table id="albumInfo"></table>
	<div id="albumDetail">
	</div>
	<script type="text/javascript" src="rel/js/album_count.js"></script>
</body>
</html>