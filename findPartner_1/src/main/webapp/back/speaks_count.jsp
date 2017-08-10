<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<meta charset="UTF-8">
<title>统计说说</title>
</head>
<body>
	<div id="searchSpeaks">
		<select id="SpeakSelectCount">
			<option value="姓名查询" id="findByName" selected="selected">姓名查询</option>
		</select>	
		<input id="paramterC" name="paramter">
		<input value="查询" type="button" onclick="unclearQuerySpeaksCount()"/>
	</div>
	<table id="speaksCountInfo"></table>
	<div id="speaksCount">
	</div>
	<script type="text/javascript" src="rel/js/speaks_count.js"></script>
</body>
</html>