function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
}

var faid = getUrlParam('aid');

GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},function(data) {
		if (data.faid == "-1") {
			$("#myspeaks").show();
			$(".updatepwd").show();
			$(".updatebtn").show();
			$(".homepage").val("个人中心");
			$(".homepage")
			.attr("href", "page/lw-index.jsp?aid=" + faid);
			$(".myfriends").attr("href",
					"page/lw-friend.jsp?aid=" + faid);
			$(".myspeaks").attr("href",
					"page/lw-speaks.jsp?aid=" + faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
			$(".updatepwd").attr("href",
					"page/lw-modifyPwd.jsp?aid=" + faid);
			selfhomepage(currPage)
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".updatebtn").hide();
			$(".homepage").html("TA的主页");
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
			showhomepage(currPage)
		}
	}, "json")
}