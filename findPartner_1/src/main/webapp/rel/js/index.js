function loadAdminInfo() {
	// 以异步的方式取到个人的信息
	$.get("user/getByid",{"faid":faid}, function(data) {
		// alert("请求响应成功。。"+data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串

		showUserInfo(data);
		showUser(data);
	}, "json");
}
loadAdminInfo();

// 显示个人信息
function showUserInfo(data) {
	$("#pictrue").val("");
	if (data.picture) {
		$(".pic").attr("src", data.picture);
	} else {
		$(".pic").attr("src", "images/not_pic.jpg");
	}
	$("#inickname").append(data.nickname);
	$("#iage").append(data.age);
	$("#ibirthday").append(data.birthday);
	$("#igender").append(data.partner.gender);
	$("#istar").append(data.star);
	$("#ihobby").append(data.hobby);
	$("#ijob").append(data.job);
	$("#icompany").append(data.company);
	$("#ischool").append(data.school);
	$("#iastate").append(data.astate);
	$("#iaddress").append(data.address);
	$("#ihometown").append(data.hometown);
	$("#iastate").append(data.astate);
}

// 显示个人信息
function showUser(data) {
	$("#pictrue").val("");
	if (data.picture) {
		$(".pic").attr("src", data.picture);
	} else {
		$(".pic").attr("src", "images/not_pic.jpg");
	}
	// alert(data.aid)
	$("#aid").val(data.aid);
	$("#nickname").val(data.nickname);
	$("#age").val(data.age);
	$("#birthday").val(data.birthday);
	$("#star").val(data.star);
	$("#hobby").val(data.hobby);
	$("#job").val(data.job);
	$("#company").val(data.company);
	$("#school").val(data.school);
	$("#astate").val(data.astate);
	$("#address").val(data.address);
	$("#hometown").val(data.hometown);
	$("#astate").val(data.astate);
}

function chgPic(obj) {
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}

$(function() {
	$("#head li a").on("click", function() {
		$("#head li a").css("background-color", "white");
		$(this).css("background-color", "green");
	})
});

function updateInfo(){
	var age=$("#age").val();
	//alert(age);
	if((age>=6 && age<=100)||age==""||age==null){
		$("#updateUserInfo").submit();
	}else{
		$("#errAge").html("年龄限制6-100");
	}
}
