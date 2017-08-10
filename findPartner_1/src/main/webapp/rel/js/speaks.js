var url = window.location.href;
var faid = url.split('?')[1].split('=')[1];

GetFinallyAid();//判断是否隐藏
function GetFinallyAid(){
	$.post("friend/finalAid",{"faid":faid},function(data){
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		//alert(data.finalaid);
		if(data.faid=="-1"){
			$("#myfriend").show();
			$(".updatepwd").show();//修改密码按钮
			$(".homepage").val("个人中心");
			$(".spanspeak").html("我的");
			//$(".updatebtn").show();//修改个人信息按钮
			$(".editdiv").show();

			$(".homepage").attr("href", "page/lw-index.jsp?aid=" + faid);
			$(".myfriends").attr("href", "page/lw-friend.jsp?aid=" + faid);
			$(".addfriend").attr("href", "page/lw-findFriend.jsp?aid=" + faid);
			$(".myspeaks").attr("href", "page/lw-speaks.jsp?aid=" + faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
			$(".updatepwd").attr("href", "page/lw-modifyPwd.jsp?aid=" + faid);
		}else{
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").html("TA的主页");
			$(".spanspeak").html("TA的");
			//$(".updatebtn").hide();
			$(".editdiv").hide();

			$(".homepage").attr("href", "page/lw-index.jsp?aid=" + data.faid);
			$(".myfriends").attr("href", "page/lw-friend.jsp?aid=" + data.faid);
			$(".addfriend").attr("href", "page/lw-findFriend.jsp?aid=" + data.faid);
			$(".myspeaks").attr("href", "page/lw-speaks.jsp?aid=" + data.faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + data.faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + data.faid);
			$(".updatepwd").attr("href", "page/lw-modifyPwd.jsp?aid=" + data.faid);

		}
	},"json")
}
speakcount();
function speakcount(){
	$.post("speaks/countSpeaks",{"speakman":faid},function(data){
		//alert(JSON.stringify(data));
		//alert(data[0].counts);
		if(data==null ||data==""){
			return false;
		}
		$(".spcount").html(data[0].counts);
	},"json");
}

var currPage = 1;
function listSpeaks(currPage) {
	$.post("speaks/list",
			{"currPage" : currPage,"faid":faid},
			function(data) {
				if(data==null||data==""){
					return false;
				}
				// alert(data);
				// alert(JSON.stringify(data)); //JSON.stringify()
				// ,把json对象转换成json字符串
				// alert(JSON.stringify(data.rows));
				var speaksStr = "";
				/* var speaksStr2 = ""; */
				for (var i = 0; i < data.rows.length; i++) {
					speaksStr+='<div><img onclick="showuser(\''+data.rows[i].speakman+'\')" class="picture uPic'+data.rows[i].speakman+'" src="images/timg.jpg">';
					speaksStr+='<a onclick="showuser(\''+data.rows[i].speakman+'\')" class="uname'+data.rows[i].speakman+'" href="javascript:void(0)" style="margin-left: 1%;">'+data.rows[i].speakman+'</a>';
					speaksStr+='<br><span style="margin-left: 5%;">'+data.rows[i].senddate+'</span>';
					speaksStr+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data.rows[i].content+'</div>';
					speaksStr+='<a style="margin-left: 23%;" href="javascript:void(0)"> </a>';
					speaksStr+='<a onclick="addcomment(\''+data.rows[i].sid+'\')" href="javascript:void(0)" style="margin-left: 5%;" data-toggle="modal"';
					speaksStr+=' data-target="#addcoment">评论</a></p>';
					speaksStr+='</div><div class="comment'+data.rows[i].sid+'" style="margin-left: 5%;"></div>';
					//alert(data[i].sid);
					comments(data.rows[i].sid);//取到所有的说说编号
					openPicture(''+data.rows[i].speakman+'');
				}
				$("#speaksInfo")[0].innerHTML = speaksStr;

				var pagination="";
				pagination+='<label>当前第'+currPage+' 页，共'+data.totalPage+' 页</label>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks(1)">首页</a>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks('+(data.currPage==1?1:(data.currPage-1))+')">上一页</a>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks('+(data.currPage==data.totalPage?data.currPage:(data.currPage+1))+')">下一页</a>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks('+data.totalPage+')">尾页</a>';
				$("#page")[0].innerHTML = pagination;
			}, "json");

}
listSpeaks(currPage);
//根据说说编号去查说说下的评论
function comments(sid) {
	// alert(sid);
	$.post("comments/list", {
		"sid" : sid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			commentStr += '<div><img onclick="showuser(\''+data[i].comuserid+'\')" class="picture uPic'+data[i].comuserid+'" src="images/timg.jpg">';
			commentStr += '<a onclick="showuser(\''+data[i].comuserid+'\')" class="uname'+data[i].comuserid+'" href="javascript:void(0)" style="margin-left: 1%;">'+data[i].comuserid+'</a>';
			commentStr += '<br><span style="margin-left: 5%;">'+data[i].comTime+'</span>';
			commentStr += '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data[i].detail+'</div>';
			commentStr += '<a style="margin-left: 23%;" href="javascript:void(0)"> </a>';
			commentStr += '<a onclick="addcr(\''+data[i].cid+'\',\''+data[i].comuserid+'\')" href="javascript:void(0)" style="margin-left: 5%;"  data-toggle="modal"';
			commentStr += ' data-target="#addreply">回复</a>';
			commentStr += '</div><div class="reply'+data[i].cid+'" style="margin-left: 5%;"></div>';
			replys(data[i].cid);// 取到所有的评论编号
			openPicture(''+data[i].comuserid+'');
		}
		$(".comment"+sid)[0].innerHTML = commentStr;
	}, "json");
}

//根据评论编号，找到评论编号下的所有回复
function replys(cid) {
	// alert(cid);
	$.post("replys/list", {
		"cid" : cid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var replysStr = "";
		for (var i = 0; i < data.length; i++) {
			replysStr += '<div><img onclick="showuser(\''+data[i].ruserid+'\')" class="picture uPic'+data[i].ruserid+'"  src="images/timg.jpg">';
			replysStr += '<a onclick="showuser(\''+data[i].ruserid+'\')" class="uname'+data[i].ruserid+'" href="javascript:void(0)" style="margin-left: 1%;">'+data[i].ruserid+'</a> 回复';
			replysStr += '<a href="javascript:void(0)">'+data[i].rtargetid+'</a>:';
			replysStr += '<br><span style="margin-left: 5%;">'+data[i].rtime+'</span>';
			replysStr += '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data[i].rcontent+'</div>';
			replysStr += '<a style="margin-left: 23%;" href="javascript:void(0)"> </a>';
			replysStr += '<a onclick="addreplys(\''+data[i].rid+'\',\''+data[i].ruserid+'\')"  href="javascript:void(0)" style="margin-left: 5%;"  data-toggle="modal"';
			replysStr += ' data-target="#addreply">回复</a></div>';
			replysStr += '<div class="reply'+data[i].rid+'"></div>';
			replys(data[i].rid);
			openPicture(''+data[i].ruserid+'');
		}
		$(".reply"+cid)[0].innerHTML = replysStr;
	}, "json");
}

var ue = UE.getEditor('ueditor');

//点击添加说说
function addSpeak() {
	// alert(ue.getContentTxt());
	$("#content").val(ue.getContentTxt());
	$("#strspeaks").val(url);
	$("#myspeak").submit();
}

//点击说说的评论
function addcomment(obj){
	//alert(obj);
	//$(".callid").attr("value",sid);
	$(".callid").attr("value",obj);
	$(".strcomment").val(url);
}

//评论点击提交
function Getdetail(){
	var text = $(".democomment").text();
	//alert(text);
	$(".detail").attr("value",text);
	$("#faddcomment").submit();
}

//点击评论的回复
function addcr(cid,comuserid){
	//alert(JSON.stringify(obj)); //JSON.stringify() ,把json对象转换成json字符串
	$(".rcid").val(cid);
	$(".strreplys").val(url);
	$(".rtargetid").val(comuserid);
}

//点击回复的回复
function addreplys(rid,ruserid){
	//alert(JSON.stringify(obj)); //JSON.stringify() ,把json对象转换成json字符串
	$(".rcid").val(rid);
	$(".strreplys").val(url);
	$(".rtargetid").val(ruserid);
}
//回复点击提交
function Getrcontent(){
	var text = $(".democomment").text();
	//alert(text);
	$(".rcontent").val(text);
	$("#rform").submit();
}

//获取用户头像，昵称
function openPicture(aid){
	//alert(date);
	$.post("user/aid",{"aid":aid},function(data){
		if(data==null||data==""){
			return false;
		}
		//alert(JSON.stringify(data));
		//alert($(".uname"+data.aid).val(data.nickname));
		$(".uPic"+data.aid).attr("src",data.picture==null||data.picture==""?"images/timg.jpg":data.picture);
		$(".uname"+data.aid).html(data.nickname);
	},"JSON")
}

//点击用户头像 用户昵称 进入他的主页
function showuser(date){
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		window.open(url);
	}
}
