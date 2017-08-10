$(function() {
	$('#log-form').validator({
		onValid: function(validity) {
			$(validity.field).closest('.am-input-group').find('.am-alert').hide();
		},

		onInValid: function(validity) {
			var $field = $(validity.field);
			var $group = $field.closest('.am-input-group');
			var $alert = $group.find('.am-alert');
			// 使用自定义的提示信息 或 插件内置的提示信息
			var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

			if (!$alert.length) {
				$alert = $('<div class="log-alert am-alert am-alert-danger am-radius"></div>').hide().
				appendTo($group);
			}
			$alert.html(msg).show();
		}
	});
});

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
			$.post("partner/sendMail",{"email":emailBox},function(data){
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


