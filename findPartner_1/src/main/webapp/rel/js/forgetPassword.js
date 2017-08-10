$("#forgrtPwdDiv").dialog({
	title:"",
	border:false,
	modal:true,
	width:200,
	top:80
});
//发送邮件
var timeObj;
var time;
var codeFlag=false;
function sendMail(){
	var emailBox=$("#email").val();
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	if(emailBox=="" || emailBox==null){
		//alert("您还没有输入邮箱!!!");
		$.messager.alert('错误提示','您还没有输入邮箱!!!','error');
		return false;
	}else if(!emailBox.match(reg)){
		$.messager.alert('错误提示','邮箱格式不正确!!!','error');
		return false;
	}
	$.post("partner/emailExist",{"email":emailBox},function(data){
		//alert(data);
		if(data){
			sendEmail(emailBox);
		}else{
			$('#laerror').html("该用户不存在，请先注册！！！");
		}
	})
	//alert(emailBox);

}

function sendEmail(emailBox){
	time=60;
	$.post("partner/sendForgetMail",{"email":emailBox},function(data){
		//alert(data);
		if(data>0){
			timeObj=window.setInterval(timeCode, 1000);
			$(".sendMail").attr("disabled","false");
		}
	})
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
