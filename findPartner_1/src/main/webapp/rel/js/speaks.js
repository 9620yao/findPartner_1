var url = window.location.href;
var faid = url.split('?')[1].split('=')[1];

GetFinallyAid();// 判断是否隐藏
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},
	function(data) {
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify()
		// ,把json对象转换成json字符串
		// alert(data.finalaid);
		if (data.faid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();// 修改密码按钮
			$(".homepage").val("个人中心");
			$(".spanspeak").html("我的");
			// $(".updatebtn").show();//修改个人信息按钮
			$(".editdiv").show();

			$(".homepage")
			.attr("href", "page/lw-index.jsp?aid=" + faid);
			$(".myfriends").attr("href",
					"page/lw-friend.jsp?aid=" + faid);
			$(".addfriend").attr("href",
					"page/lw-findFriend.jsp?aid=" + faid);
			$(".myspeaks").attr("href",
					"page/lw-speaks.jsp?aid=" + faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
			$(".updatepwd").attr("href",
					"page/lw-modifyPwd.jsp?aid=" + faid);
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").html("TA的主页");
			$(".spanspeak").html("TA的");
			// $(".updatebtn").hide();
			$(".editdiv").hide();

			$(".homepage").attr("href",
					"page/lw-index.jsp?aid=" + data.faid);
			$(".myfriends").attr("href",
					"page/lw-friend.jsp?aid=" + data.faid);
			$(".addfriend").attr("href",
					"page/lw-findFriend.jsp?aid=" + data.faid);
			$(".myspeaks").attr("href",
					"page/lw-speaks.jsp?aid=" + data.faid);
			$(".myword").attr("href",
					"page/message.jsp?aid=" + data.faid);
			$(".myalbum").attr("href",
					"page/lw-img.jsp?aid=" + data.faid);
			$(".updatepwd").attr("href",
					"page/lw-modifyPwd.jsp?aid=" + data.faid);

		}
	}, "json")
}
speakcount();
function speakcount() {
	$.post("speaks/countSpeaks", {
		"speakman" : faid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		$(".spcount").html(data[0].counts);
	}, "json");
}

var currPage = 1;
function listSpeaks(currPage) {
	var div = $("#speaksInfo");
	$.post("speaks/list",{
		"currPage" : currPage,
		"faid" : faid
	},
	function(data) {
		if (data == null || data == "" ||JSON.stringify(data)=="{}") {
			return false;
		}
		for (var i = 0; i < data.rows.length; i++) {
			div.append('<div><img onclick="showuser(\''+ data.rows[i].speakman+ '\')" class="picture" '
				+ '" src="'+(data.rows[i].user.picture == null || data.rows[i].user.picture == "" ? "images/timg.jpg": data.rows[i].user.picture)+'"> '
				+'<a onclick="showuser(\''+ data.rows[i].speakman+'\')" class="uname" href="javascript:void(0)" style="margin-left: 1%;">'
				+ data.rows[i].user.nickname + '</a><br><span style="margin-left: 5%;">'+ data.rows[i].senddate + '</span>'
				+ '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'
				+ data.rows[i].content + '</div><a style="margin-left: 23%;" href="javascript:void(0)"> </a>'
				+'<a onclick="addcomment(\''+ data.rows[i].sid+ '\')" href="javascript:void(0)" style="margin-left: 5%;" '
				+'data-toggle="modal" data-target="#addcoment">评论</a></p></div><div class="comment'+ data.rows[i].sid
				+ '" style="margin-left: 5%;"></div>');
			comments(data.rows[i].comments);//取到该说说下的所有评论
		}
		
		var pagination = "";
		pagination += '<label>当前第' + currPage + ' 页，共'
		+ data.totalPage + ' 页</label>';
		pagination += '<a href="javascript:void(0)" onclick="listSpeaks(1)">首页</a>';
		pagination += '<a href="javascript:void(0)" onclick="listSpeaks('
			+ (data.currPage == 1 ? 1 : (data.currPage - 1))
			+ ')">上一页</a>';
		pagination += '<a href="javascript:void(0)" onclick="listSpeaks('
			+ (data.currPage == data.totalPage ? data.currPage
					: (data.currPage + 1)) + ')">下一页</a>';
		pagination += '<a href="javascript:void(0)" onclick="listSpeaks('
			+ data.totalPage + ')">尾页</a>';
		$("#page")[0].innerHTML = pagination;
	}, "json");
}
listSpeaks(currPage);

var ue = UE.getEditor('ueditor');

//点击添加说说
function addSpeak() {
	$("#content").val(ue.getContentTxt());
	$("#strspeaks").val(url);
	$("#myspeak").submit();
}

//点击说说的评论
function addcomment(obj) {
	$(".callid").attr("value", obj);
	$(".strcomment").val(url);
}

//评论点击提交
function Getdetail() {
	var text = $(".democomment").text();
	$(".detail").attr("value", text);
	$("#faddcomment").submit();
}

//点击评论的回复
function addcr(cid, comuserid) {
	$(".rcid").val(cid);
	$(".strreplys").val(url);
	$(".rtargetid").val(comuserid);
}

//点击回复的回复
function addreplys(rid, ruserid) {
	$(".rcid").val(rid);
	$(".strreplys").val(url);
	$(".rtargetid").val(ruserid);
}
//回复点击提交
function Getrcontent() {
	var text = $(".democomment").text();
	// alert(text);
	$(".rcontent").val(text);
	$("#rform").submit();
}

//点击用户头像 用户昵称 进入他的主页
function showuser(date) {
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		window.open(url);
	}
}
