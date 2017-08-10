var url = window.location.href;
var faid = url.split('?')[1].split('=')[1];

GetFinallyAid();// 判断是否隐藏
function GetFinallyAid() {
	$.post("friend/finalAid",{"faid":faid}, function(data) {
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		// alert(data.finalaid);
		if (data.faid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();// 修改密码按钮
			$(".homepage").val("个人中心");
			$(".spanimg").html("我的");
			$(".addimgs").show();//添加相册按钮 imgs.jsp

			$(".homepage").attr("href", "page/lw-index.jsp?aid=" + faid);
			$(".myfriends").attr("href", "page/lw-friend.jsp?aid=" + faid);
			$(".addfriend").attr("href", "page/lw-findFriend.jsp?aid=" + faid);
			$(".myspeaks").attr("href", "page/lw-speaks.jsp?aid=" + faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
			$(".updatepwd").attr("href", "page/lw-modifyPwd.jsp?aid=" + faid);
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").html("TA的主页");
			$(".spanimg").html("TA的");
			$(".addimgs").hide();

			$(".homepage").attr("href", "page/lw-index.jsp?aid=" + data.faid);
			$(".myfriends").attr("href", "page/lw-friend.jsp?aid=" + data.faid);
			$(".addfriend").attr("href", "page/lw-findFriend.jsp?aid=" + data.faid);
			$(".myspeaks").attr("href", "page/lw-speaks.jsp?aid=" + data.faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + data.faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + data.faid);
			$(".updatepwd").attr("href", "page/lw-modifyPwd.jsp?aid=" + data.faid);
		}
	}, "json")
}

imgcount();
function imgcount(){
	$.post("album/countAlbum",{"aaid":faid},function(data){
		if(data==null||data==""){
			return false;
		}
		//alert(data[0].counts);
		$(".spcount").html(data[0].counts);
	},"json");
}

//加载所有相册
function showalbum() {
	$.post("album/list",{"faid":faid}, function(data) {
		// alert("请求响应成功。。"+data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		if (data == null || data == "") {//当用户没有相册的时候
			return false;
		}
		var album = '';
		var imgsrc = '';
		//album += '<div><img onclick="addImgs()" src="images/01.jpg"></div>'
		for (var i = 0; i < data.length; i++) {
			album += '<div><img onclick="openpic(\'' + data[i].abid
			+ '\')" src="' + ((data[i].aheader==null || data[i].aheader=="")?"images/pic-none.png":data[i].aheader) + '"><h2>'
			+ data[i].abname + '</h2></div>';
		}
		$("#container").html(album);
	}, "json");
}
showalbum();

//点击相册
function openpic(date) {
	if (date != null) {
		var url = "page/albumpic.jsp?aid="+faid+"&abid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		self.location = url;// 挑战页面
	}
}

//添加相册 form表单提交的时候
var ue = UE.getEditor('ueditor');

function addAlbum() {
	// alert(ue.getContentTxt());
	$(".alcontent").val(ue.getContentTxt());
	$(".strimg").val(url);
	$(".aaid").val(faid);
	$("#alform").submit();
}
