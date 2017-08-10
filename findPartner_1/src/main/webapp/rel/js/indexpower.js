var url = window.location.href;
var faid = url.split('?')[1].split('=')[1];

GetFinallyAid();
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
			$(".updatepwd").show();
			$(".updatebtn").show();
			$(".homepage").val("个人中心");
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
		}
	}, "json")
}