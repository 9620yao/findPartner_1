//发送邮件
var timeObj;
var time;
var codeFlag=false;
function sendMail(){
	var emailBox=$("#doc-vld-email-2-1").val();
	//alert(emailBox);
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	if(emailBox=="" || emailBox==null){
		//alert("您还没有输入邮箱!!!");
		$.messager.alert('错误提示','您还没有输入邮箱!!!','error');
	}else{
		if(emailBox.match(reg)){
			time=60;
			$.post("login/sendMail",{"email":emailBox},function(data){
				//alert(data);
				if(data>0){
					timeObj=window.setInterval(timeCode, 1000);
					$(".sendMail").attr("disabled","false");
				}
			})
		}else{
			$.messager.alert('错误提示','邮箱格式不正确!!!','error');
		}
	}
}

function timeCode(){
	if(time>0){
		$(".sendMail").html(time+"s");
		time=time-1;
	}else{
		window.clearInterval(timeObj);
		$(".sendMail").html("发送邮箱验证码");
		$(".sendMail").removeAttr("disabled");
	}
}