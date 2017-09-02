var timeObj;
var time;
$(".msg").hide();
function sendMail() {
	var emailBox = $(".email").val();
	var reg = new RegExp(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/);
	if (emailBox == "" || emailBox == null) {
		$('.amsg').html("请输入邮箱！！！");
		$(".msg").show();
	} else {
		if (emailBox.match(reg)) {
			time = 60;
			$.post("login/sendMail", {
				"email" : emailBox
			}, function(data) {
				if (data > 0) {
					timeObj = window.setInterval(timeCode, 1000);
					$(".sendMail").attr("disabled", "false")
				}else {
					$('.amsg').html("异常！！！");
					$(".msg").show();
				}
			})
		} else {
			$('.amsg').html("请输入正确的邮箱！！！");
			$(".msg").show();
		}
	}
}
function timeCode() {
	if (time > 0) {
		$(".sendMail").html(time + "s");
		time = time - 1;
	} else {
		window.clearInterval(timeObj);
		$(".sendMail").html("发送邮箱验证码");
		$(".sendMail").removeAttr("disabled")
	}
};
