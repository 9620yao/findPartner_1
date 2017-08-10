<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
	<div class="am-u-sm-8 am-u-sm-centered">
		<h2 class="am-hide-sm-only">findPartner | 校园首个交互网站</h2>
	</div>
</header>
<hr>
<!-- nav start -->
<nav class="am-g am-g-fixed blog-fixed blog-nav">
	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only blog-button"
		data-am-collapse="{target: '#blog-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<!--工具栏  -->
	<div class="am-collapse am-topbar-collapse" id="blog-collapse">
		<ul class="am-nav am-nav-pills am-topbar-nav" id="head">
			<li class="am-active"><a class="homepage"
				href="page/lw-index.jsp">个人中心</a></li>
			<li id="myfriend" class="am-dropdown" data-am-dropdown><a
				class="am-dropdown-toggle" data-am-dropdown-toggle
				href="javascript:void(0)">好友信息 <span class="am-icon-caret-down"></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a class="myfriends" href="page/lw-friend.jsp">我的好友</a></li>
					<li><a class="addfriend" href="page/lw-findFriend.jsp">添加好友</a></li>
				</ul></li>
			<li><a class="myspeaks" href="page/lw-speaks.jsp">说说</a></li>
			<li><a class="myword" href="page/message.jsp">留言</a></li>
			<li><a class="myalbum" href="page/lw-img.jsp">相册</a></li>
			<li><a class="updatepwd" href="page/lw-modifyPwd.jsp">修改密码</a></li>
		</ul>
		<span class="target"></span>
		<form class="am-topbar-form am-topbar-right am-form-inline"
			role="search">
			<div class="am-form-group">
				<input type="text" class="am-form-field am-input-sm"
					placeholder="搜索">
			</div>
		</form>
	</div>
</nav>
<hr>
<!-- nav end -->