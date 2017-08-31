var url = window.location.href;
var faid = url.split("?")[1].split("&")[0].split("=")[1];
if (faid != null && faid != "") {
	$(".amyimg").attr("href", "page/lw-img.jsp?aid=" + faid)
}
GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},function(data) {
		if (data.faid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();
			$(".homepage").val("个人中心");
			$(".addimgbtn").show();
			$(".newimgbtn").show();
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
			$(".addimgbtn").hide();
			$(".newimgbtn").hide();
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
listalbumpic();
function listalbumpic() {
	$.post("albumpic/list", function(data) {
		if (data == null || data == "") {
			$(".imgnotnull").show();
			return false
		}
		$("#imgnotnull").hide();
		var apicStr = '';
		for (var i = 0; i < data.length; i++) {
			apicStr += '<li data-src="' + data[i].apic
			+ '"><a href="javascript:void(0)">';
			apicStr += '<img src="' + data[i].apic + '"></a></li>';
		}
		$("#lightgallery")[0].innerHTML = apicStr;
		lightGallery();
	}, "json")
}
function lightGallery() {
	$(document).ready(function() {
		$("#lightgallery").lightGallery();
	});
}
function chgPic(obj) {
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]))
}
