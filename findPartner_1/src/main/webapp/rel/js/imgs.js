var url = window.location.href;
var faid = url.split("?")[1].split("=")[1];
GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},function(data) {
		if (data.faid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();
			$(".homepage").val("个人中心");
			$(".spanimg").html("我的");
			$(".addimgs").show();
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
					"page/lw-modifyPwd.jsp?aid=" + faid)
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").html("TA的主页");
			$(".spanimg").html("TA的");
			$(".addimgs").hide();
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
					"page/lw-modifyPwd.jsp?aid=" + data.faid)
		}
	}, "json")
}
imgcount();
function imgcount() {
	$.post("album/countAlbum", {
		"aaid" : faid
	}, function(data) {
		if (data == null || data == "") {
			return false
		}
		$(".spcount").html(data[0].counts)
	}, "json")
}
function showalbum() {
	$.post("album/list",{
		"faid" : faid
	},
	function(data) {
		if (data == null || data == "") {
			return false
		}
		var album = '';
		for (var i = 0; i < data.length; i++) {
			album += "<div><img onclick=\"openpic("+ data[i].abid+ ")\" ";
			if(data[i].aheader == null || data[i].aheader == ""){
				album += " src=\"images/pic-none.png\"/>";
			}else{
				album += " src=\""+data[i].aheader+"\"/>";
			}
			album += "<span>"+ data[i].abname + "</span></div>"
		}
		$("#container").html(album)
	}, "json")
}
showalbum();
function openpic(date) {
	if (date != null) {
		var url = "page/albumpic.jsp?aid=" + faid + "&abid=" + date;
		self.location = url;
	}
}
var ue = UE.getEditor("ueditor");
function addAlbum() {
	$(".alcontent").val(ue.getContentTxt());
	$(".strimg").val(url);
	$(".aaid").val(faid);
	$("#alform").submit()
};