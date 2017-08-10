<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ page import="com.yc.servlet.entity.*"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${deployName }">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
</head>
<body>

	<div id="searchUsers">
		<select id="UserselectName">
			<option value="用户编号查询" id="findByName" selected="selected">用户编号查询</option>
		</select>	
		<input id="paramter" name="paramter">
		<input value="查询" type="button" onclick="unclearQuery()"/>
	</div>
	<table id="dg"></table>
	
	<!-- 用户详情 -->
	<div id="usersDetail">
			<p>
				<label> 编号 </label> <input id="iaid" readonly="readonly"/>
			</p>
			<p>
				<label> 昵称 </label> <input id="inickname" readonly="readonly"/>
			</p>
			<p>
				<label> 性别 </label> <input id="igender" readonly="readonly"/>
			</p>
			<p>
				<label> 邮箱 </label> <input id="iemail" readonly="readonly"/>
			</p>
			<p>
				<label> 生日 </label> <input id="ibirthday" readonly="readonly"/>
			</p>
			<p>
				<label> 星座 </label> <input id="istar" readonly="readonly"/>
			</p>
			<p>
				<label> 愛好 </label> <input id="ihobby" readonly="readonly"/>
			</p>
			<p>
				<label> 头像 </label>
				<img src="images/not_pic.jpg" style="width:100px;height:100px" id="ipicture">
			</p>
			<p>
				<label> 注册时间 </label><input id="iregdate" readonly="readonly"/>
			</p>
			<p><a class="closeBtn" href="javascript:void(0)">关闭</a>&nbsp;&nbsp;
	</div>
	<script type="text/javascript" src="rel/js/users_info.js"></script>
</body>
</html>