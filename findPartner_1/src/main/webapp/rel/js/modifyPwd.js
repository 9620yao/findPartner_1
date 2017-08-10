var url = window.location.href;
var faid = url.split('?')[1].split('=')[1];
if (faid != null && faid != "") {
	$(".homepage").attr("href", "page/lw-index.jsp?aid=" + faid);
	$(".myfriends").attr("href", "page/lw-friend.jsp?aid=" + faid);
	$(".addfriend").attr("href", "page/lw-findFriend.jsp?aid=" + faid);
	$(".myspeaks").attr("href", "page/lw-speaks.jsp?aid=" + faid);
	$(".myword").attr("href", "page/message.jsp?aid=" + faid);
	$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
	$(".updatepwd").attr("href", "page/lw-modifyPwd.jsp?aid=" + faid);
}
$(".rback").attr("href", "page/lw-index.jsp?aid=" + faid);

function strupdate() {
	$(".strmdpwd").val(url);
	var email = $("#email").val();
	var password = $("#password").val();
	//alert(email);
	$.post("user/sure", {
		"email" : email,
		"password" : password
	}, function(data) {
		//alert(data);
		if (data) {
			$(".fmodifyPwd").submit();
		} else {
			alert("原密码错误！！！");
		}
	});
}