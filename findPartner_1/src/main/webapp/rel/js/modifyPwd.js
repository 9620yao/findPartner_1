$(".mgdiv").hide();
function strupdate() {
	var email = $("#email").html();;
	var password = $("#password").val();
	var newPassword = $('#newPassword').val();
	if(password==null ||password=="" || newPassword==null || newPassword==""){
		$(".mgdiv").show();
		$(".mgdiv").html("请输入密码...");
	}else{
		$.post("login/sure", {
			"email" : email,
			"password" : password
		}, function(data) {
			if (data) {
				$(".fmodifyPwd").submit();
			} else {
				$(".mgdiv").show();
				$(".mgdiv").html("原密码错误，请确认后操作...");
			}
		});
	}
};