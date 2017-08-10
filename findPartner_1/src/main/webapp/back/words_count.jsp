<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="UTF-8">
<title>留言统计</title>
</head>
<body>
	<div id="searchWords">
		<select id="WordselectCount">
			<option value="姓名查询" id="findByName" selected="selected">姓名查询</option>
		</select>	
		<input id="paramterWC" name="paramter">
		<input value="查询" type="button" onclick="unclearQueryWordsCount()"/>
	</div>
	<table id="wordsInfo"></table>
	<br>
	<div id="wordsDetail"></div>
	<br><br>
	<script type="text/javascript" src="rel/js/words_count.js"></script>
</body>
</html>