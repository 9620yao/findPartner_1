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
			$(".spanword").html("我的");
			$("#divword").hide();//显示留言添加按钮	message.jsp
			
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
			$(".homepage").attr("href","page/lw-index.jsp?aid="+data.faid);
			$(".homepage").html("TA的主页");
			$(".spanword").html("TA的");
			//$(".updatebtn").hide();
			//$(".editdiv").hide();
			$("#divword").show();//隐藏留言添加按钮	message.jsp
			
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

//加载共多少留言
wordcount();
function wordcount(){
	$.post("words/countWords",{"waid":faid},function(data){
		$(".spcount").html(data[0].counts);
	},"json");
}

var currPage = 1;
listWords(currPage);
function listWords(currPage){
	$.post("words/list",{"currPage":currPage,"faid":faid}, function(data){
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		//alert(JSON.stringify(data.rows));
		var wordsStr = "";
		for (var i = 0; i < data.rows.length; i++) {
			wordsStr+='<div style="margin-left: 2%;margin-top: 3%;">';
			wordsStr+='<img onclick="showuser(\''+data.rows[i].wfrendid+'\')" src="images/timg.jpg"  class="picSize uPic'+data.rows[i].wfrendid+'" />';
			wordsStr+='<a onclick="showuser(\''+data.rows[i].wfrendid+'\')" class="uname'+data.rows[i].wfrendid+'" href="javascript:void(0)" style="margin-left: 1%;">'+data.rows[i].wfrendid+'</a>';
			wordsStr+='<br><span style="color: grey;margin-left: 5%;" class="wdate">'+data.rows[i].wdate+'</span>';
			wordsStr+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data.rows[i].wcontent+'</div>';
			wordsStr+='<a class="name" onclick="addcomment(\''+data.rows[i].wid+'\')" href="javascript:void(0)" style="margin-left: 35%;" data-toggle="modal" data-target="#addcoment">评论</a>';
			wordsStr+='<div style="margin-left: 7%;margin-top: 3%;" class="showcomment'+data.rows[i].wid+'"></div><hr style="border:1 dotted" id="link"></div>';
			// alert(data.rows[i].wid);
			comments(data.rows[i].wid);//取到所有的说说编号
			openPicture(''+data.rows[i].wfrendid+'');
		}
		//alert(wordsStr);
		$("#hostAll")[0].innerHTML = wordsStr;
		var pagination="";
		pagination+='<label>每页5条，当前第'+currPage+' 页，共'+data.totalPage+' 页</label>';
		pagination+='<a href="javascript:void(0)" onclick="listWords(1)">首页</a>';
		pagination+='<a href="javascript:void(0)" onclick="listWords('+(data.currPage==1?1:(data.currPage-1))+')">上一页</a>';
		pagination+='<a href="javascript:void(0)" onclick="listWords('+(data.currPage==data.totalPage?data.currPage:(data.currPage+1))+')">下一页</a>';
		pagination+='<a href="javascript:void(0)" onclick="listWords('+data.totalPage+')">尾页</a>';
		$("#page")[0].innerHTML = pagination;
	}, "json");
}
//根据说说编号去查说说下的评论
function comments(sid){
	//alert(sid);
	$.post("comments/list",{"sid":sid}, function(data){
		if(data==null || data==""){
			return false;
		}
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			commentStr+='<div><img onclick="showuser(\''+data[i].comuserid+'\')" class="picSize uPic'+data[i].comuserid+'" src="images/timg.jpg">';
			commentStr+= '<a onclick="showuser(\''+data[i].comuserid+'\')" class="uname'+data[i].comuserid+'" href="javascript:void(0)" style="margin-left: 1%;">'+data[i].comuserid+'</a>';
			commentStr+='<br><span style="margin-left: 5%;" class="commTime">'+data[i].comTime+'</span>';
			commentStr+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data[i].detail+'</div>';
			commentStr+='<a class="name" onclick="addcr(\''+data[i].cid+'\',\''+data[i].comuserid+'\')" href="javascript:void(0)" style="margin-left: 35%;" data-toggle="modal" data-target="#addreply">回复</a>';
			commentStr+='<div style="margin-left: 7%;margin-top: 3%;" class="showreplys'+data[i].cid+'"></div></div>';
			replys(data[i].cid);//取到所有的评论编号
			//alert(data[i].cid);
			openPicture(''+data[i].comuserid+'');
		}
		$(".showcomment"+sid)[0].innerHTML = commentStr;
	}, "json");
}

//根据评论编号，找到评论编号下的所有回复
function replys(cid){
	//alert(cid);
	$.post("replys/list",{"cid":cid}, function(data){
		if(data==null || data==""){
			return false;
		}
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var replysStr = "";
		for (var i = 0; i < data.length; i++) {
			replysStr += '<div><img onclick="showuser(\''+data[i].ruserid+'\')" class="picSize uPic'+data[i].ruserid+'" src="images/timg.jpg">';
			replysStr += '<a onclick="showuser(\''+data[i].ruserid+'\')" class="uname'+data[i].ruserid+'" href="javascript:void(0)"  style="margin-left: 1%;">'+data[i].ruserid+'</a> 回复';
			replysStr += '<span style="margin-left: 1%;" class="commId name'+data[i].rtargetid+'">'+data[i].rtargetid+'</span>:';
			replysStr += '<br><span style="margin-left: 5%;" class="replayTime">'+data[i].rtime+'</span>';
			replysStr += '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+data[i].rcontent+'</div>';
			replysStr += '<a class="name" onclick="addreplys(\''+data[i].rid+'\',\''+data[i].ruserid+'\')" href="javascript:void(0)" style="margin-left: 35%;" data-toggle="modal"';
			replysStr += ' data-target="#addreply">回复</a></div>';
			replysStr += '<div class="showreplys'+data[i].rid+'"></div>';
			replys(data[i].rid);
			openPicture(''+data[i].ruserid+'');
		}
		
		$(".showreplys"+cid)[0].innerHTML = replysStr;
	}, "json");
}


var ue = UE.getEditor('ueditor');
//添加留言点击提交
function addword() {
	// alert(ue.getContentTxt());
	$("#wcontent").val(ue.getContentTxt());
	$(".waid").val(faid);
	$(".strword").val(url);
	$("#myword").submit();
}
//点击评论
function addcomment(obj){
	//alert(obj);
	$(".strcomment").val(url);
	$(".callid").attr("value",obj);
}

//点击评论的提交
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

//点击回复的提交
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