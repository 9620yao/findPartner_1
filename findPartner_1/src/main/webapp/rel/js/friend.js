var url = window.location.href;
var faid = url.split('?')[1].split('=')[1];
if(faid!=null && faid!=""){
	$(".homepage").attr("href", "page/lw-index.jsp?aid=" + faid);
	$(".myfriends").attr("href", "page/lw-friend.jsp?aid=" + faid);
	$(".addfriend").attr("href", "page/lw-findFriend.jsp?aid=" + faid);
	$(".myspeaks").attr("href", "page/lw-speaks.jsp?aid=" + faid);
	$(".myword").attr("href", "page/message.jsp?aid=" + faid);
	$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
	$(".updatepwd").attr("href", "page/lw-modifyPwd.jsp?aid=" + faid);
}
function loadFriendsInfo(){
	//以异步的方式取到个人的信息
	$.get("friend/list", function(data){
		//alert("请求响应成功。。"+data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var friendList="";
		for (var i = 0; i < data.length; i++) {
			friendList+='<div style="width:300px;float:left;margin-top:10px;"><div class="testdiv" style="float:left;margin-left:20px;">';
			friendList+=data[i].picture==null?'<img style="width:100px;height:100px;border:none;" onclick="showuser(\''+data[i].aid+'\')" src="images/not_pic.jpg">':'<img style="width:100px;height:100px;border:none;" onclick="showuser(\''+data[i].aid+'\')" src="'+data[i].picture+'">';
			friendList+='</div><div style="float:left;margin-left:5px;width:150px;"><h3 style="color:green;">'+data[i].nickname+'</h3>';
			friendList+='<span style="display:block;">'+data[i].address+'</span><span style="display:block;margin-left:3px;">'+data[i].star+'</span></div></div>'
		}
		$("#divmyfriend")[0].innerHTML = friendList;

	}, "json");
}
loadFriendsInfo();

function showuser(date){
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		window.open(url);
	}
}

