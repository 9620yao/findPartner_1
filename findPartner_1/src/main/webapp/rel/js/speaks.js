var url = window.location.href;
var faid = url.split('?')[1].split('=')[1];

GetFinallyAid();// 判断是否隐藏
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},
	function(data) {
		if (data.faid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();// 修改密码按钮
			$(".homepage").val("个人中心");
			$(".spanspeak").html("我的");
			// $(".updatebtn").show();//修改个人信息按钮
			$(".editdiv").show();

			$(".homepage")
			.attr("href", "page/lw-index.jsp?aid=" + faid);
			$(".myfriends").attr("href",
					"page/lw-friend.jsp?aid=" + faid);
			$(".addfriend").attr("href",
					"page/lw-findFriend.jsp?aid=" + faid);
			$(".myspeaks").attr("href",
					"page/lw-speaks.jsp?aid=" + faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
			$(".updatepwd").attr("href",
					"page/lw-modifyPwd.jsp?aid=" + faid);
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").html("TA的主页");
			$(".spanspeak").html("TA的");
			// $(".updatebtn").hide();
			$(".editdiv").hide();

			$(".homepage").attr("href",
					"page/lw-index.jsp?aid=" + data.faid);
			$(".myfriends").attr("href",
					"page/lw-friend.jsp?aid=" + data.faid);
			$(".addfriend").attr("href",
					"page/lw-findFriend.jsp?aid=" + data.faid);
			$(".myspeaks").attr("href",
					"page/lw-speaks.jsp?aid=" + data.faid);
			$(".myword").attr("href",
					"page/message.jsp?aid=" + data.faid);
			$(".myalbum").attr("href",
					"page/lw-img.jsp?aid=" + data.faid);
			$(".updatepwd").attr("href",
					"page/lw-modifyPwd.jsp?aid=" + data.faid);

		}
	}, "json")
}
speakcount();
function speakcount() {
	$.post("speaks/countSpeaks", {
		"speakman" : faid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		$(".spcount").html(data[0].counts);
	}, "json");
}

var currPage = 1;
function listSpeaks(currPage) {
	var div = $("#speaksInfo");
	$.post("speaks/list",{
		"currPage" : currPage,
		"faid" : faid
	},
	function(data) {
		if (data == null || data == "") {
			return false;
		}
		var options = {
				alignment:"center", // 居中显示
				currentPage: data.currPage, // 当前页数
				totalPages: data.totalPage,// 总页数 注意不是总条数
				pageUrl: function(type, page, current){
					if (page==current) {
						return "javascript:void(0)";
					} else {
						return "javascript:listSpeaks("+page+")";
					}
				}
		};
		var str = '';
		for (var i = 0; i < data.rows.length; i++) {
			str+='<div><img onclick="showuser(\''+ data.rows[i].speakman+ '\')" class="picture"';
			if(data.rows[i].user.picture == null|| data.rows[i].user.picture == ""){
				str+=' src="images/timg.jpg">';
			}else{
				str+=' src="'+ data.rows[i].user.picture+'">';
			}
			str+='<a class="uname" href="javascript:showuser(\''+ data.rows[i].speakman+ '\')">'+ data.rows[i].user.nickname+ '</a>';
			str+='<span class="time">'+ data.rows[i].senddate+ '</span>';
			str+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data.rows[i].content+ '</div>';
			str+='<a class="del" href="javascript:void(0)"></a>';
			str+='<a class="com" onclick="addcomment(\''+ data.rows[i].sid+ '\',\''+ data.rows[i].s_uuid+ '\')" href="javascript:void(0)"'
			+ 'data-toggle="modal" data-target="#addcoment">评论</a></p></div>';
			str+='<div class="dcom comment'+ data.rows[i].sid+'"></div>';
		}
		div.html(str);
		comments(data.rows);
		$('#page').bootstrapPaginator(options);
	}, "json");
}
listSpeaks(currPage);


//点击添加说说
function addSpeak() {
	var content = ue.getContentTxt();
	$.post("speaks/" + faid, {
		"content" : content
	}, function(data) {
		if (data) {
			listSpeaks(1);
			//parent.location.reload();// 刷新缓存
			clearmyedit();
		}
	}, "json")
}

//点击说说的评论
function addcomment(obj,uuid) {
	$(".callid").attr("value", obj);
	$('.s_uuid').attr("value",uuid);
	$(".btnclose").attr("data-dismiss","");
}


//评论点击提交
function Getdetail(){
	var text = $(".democomment").text();
	var callid = $(".callid").val();
	var s_uuid = $('.s_uuid').val();
	$.post("comments/add",{"detail":text,"callid":callid,"c_uuid":s_uuid},function(data){
		if(data){
			alonecom(callid,s_uuid);
			$(".btnclose").attr("data-dismiss","modal");
			$(".btnclose").click();
			$(".democomment").html("");
		}
	},"json");
}

//点击评论的回复
function addcr(cid, comuserid) {
	$(".rcid").val(cid);
	$(".rtargetid").val(comuserid);
	$(".btnclose").attr("data-dismiss","");
}

//回复点击提交
function Getrcontent() {
	var rcontent = $(".democomment").text();
	var rcid = $(".rcid").val();
	var rtargetid = $(".rtargetid").val();
	$.post("replys/add",{"rcid":rcid,"rtargetid":rtargetid,"rcontent":rcontent},function(data){
		if(data){
			alonerel(rcid);
			$(".btnclose").attr("data-dismiss","modal");
			$(".btnclose").click();
			$(".democomment").html("");
		}
	},"json");
}

function alonerel(rcid){
	$.post("replys/list",{"rcid":rcid},function(data){
		//alert(JSON.stringify(data));
		if(data==null || data==""){
			return false;
		}
		var alrel = '';
		for (var i = 0; i < data.length; i++) {
			alrel+='<div><img onclick="showuser(\'' + data[i].comuserid + '\')" class="picture"';
			if(data[i].user.picture == null || data[i].user.picture == ""){
				alrel+=' src="images/timg.jpg">';
			}else{
				alrel+=' src="'+data[i].user.picture+'">';
			}
			alrel+='<a class="uname" href="javascript:showuser(\'' + data[i].ruserid+ '\')">'+ data[i].user.nickname + '</a>';
			alrel+=' 回复<a href="javascript:showuser(\'' + data[i].rtargetid+ '\')">'+ data[i].puser.nickname+ '</a>:';
			alrel+='<span class="time">' + data[i].rtime+ '</span>';
			alrel+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data[i].rcontent + '</div>';
			alrel+='<a class="del" href="javascript:void(0)"></a>';
			alrel+='<a onclick="addcr(\''+ data[i].rcid+ '\',\''+ data[i].ruserid+ '\')" href="javascript:void(0)"'
			+' class="rep" data-toggle="modal" data-target="#addreply">回复</a></div>';
		}
		$(".reply"+rcid).html(alrel);
	},"json");
}

//点击用户头像 用户昵称 进入他的主页
function showuser(date) {
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		// window.open(url); //打开新的页面并带参数过去
		window.open(url);
	}
}
