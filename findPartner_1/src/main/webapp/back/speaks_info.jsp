<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<meta charset="UTF-8">
<title>说说管理</title>
</head>
<body>
	<div id="searchSpeaks">
		<select id="SpeakSelectName">
			<option value="姓名/时间查询" id="findByName" selected="selected">姓名/时间查询</option>
		</select>	
		<input id="paramterS" name="paramter">
		<input value="查询" type="button" onclick="unclearQuerySpeaks()"/>
	</div>
	<table id="speaksInfo"></table>
	<div id="speaksDetail">
		<form action="#" method="post">
			<p>
				<label> 编号</label> <input id="isid"/>
			</p>
			
			<p>
				<label> 说说发表人 </label> <input id="ispeakman" />
			</p>
			<p>
				<label> 内容 </label>
				<div id="icontent" style="width: 300px; height: 100px; border: 1px solid gray; overflow: scroll;"></div>
			</p>
			
			<p>
				<label> 上传文件 </label><input id="ifiles" />
			</p>
			<p>
				<label> 日期 </label><input id="isenddate" sortable="true"/>
			</p>
		</form>
	</div>
	<script type="text/javascript" src="rel/js/speaks_info.js"></script>
</body>
</html>