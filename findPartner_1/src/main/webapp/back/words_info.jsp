<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="UTF-8">
<title>说说管理</title>
</head>
<body>
	<div id="searchWords">
		<select id="WordselectName">
			<option value="姓名/时间查询" id="findByName" selected="selected">姓名/时间查询</option>
		</select>	
		<input id="paramterW" name="paramter">
		<input value="查询" type="button" onclick="unclearQueryWords()"/>
	</div>
	<table id="wordsInfo"></table>
	<br>
	<div id="wordsDetail">
		<form action="#" method="post">
			<p>
				<label> 留言编号</label> <input id="iwid"/>
			</p>
			
			<p>
				<label> 留言人</label> <input id="iwfrendid" />
			</p>
			<p>
				<label> 留言内容 </label>
				<div id="iwcontent" style="width: 400px; height: 100px; border: 1px solid gray; overflow: scroll;"></div>
			</p>
			
			<p>
				<label> 留言地址 </label><input id="iwaddress" />
			</p>
			<p>
				<label> 留言日期 </label><input id="iwdate" />
			</p>
		</form>
	</div>
	<br><br>
	<script type="text/javascript" src="rel/js/words_info.js"></script>
</body>
</html>