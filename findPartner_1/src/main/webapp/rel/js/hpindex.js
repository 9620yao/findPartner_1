var url = window.location.href;
var faid = url.split("?")[1].split("=")[1];
GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},function(data) {
		if (data.faid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();
			$(".updatebtn").show();
			$(".homepage").val("个人中心");
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
			selfhomepage(currPage)
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".updatebtn").hide();
			$(".homepage").html("TA的主页");
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
			showhomepage(currPage)
		}
	}, "json")
}
var currPage = 1;
function showhomepage(currPage) {
	$.post("homepage/list",{
		"currPage" : currPage,
		"faid" : faid
	},
	function(data) {
		if (data == null || data == "") {
			return false
		}
		homepage(data);
		var pagination = "";
		if (data.currPage == data.totalPage) {
			pagination += '<div><a class="addmore" href="javascript:void(0)">已经到底部</a></div>'
		} else {
			pagination += '<div><a class="addmore" href="javascript:void(0)" onclick="showhomepage('
				+ (data.currPage + 1)
				+ ')">点击加载更多</a></div>'
		}
		$("#page")[0].innerHTML = pagination;
	}, "json")
}
function selfhomepage(currPage) {
	$.post("homepage/selflist",{
		"currPage" : currPage,
		"faid" : faid
	},
	function(data) {
		if (data == null || data == "") {
			return false
		}
		homepage(data);
		var pagination = "";
		if (data.currPage == data.totalPage) {
			pagination += '<div><a class="addmore" href="javascript:void(0)">已经到底部</a></div>'
		} else {
			pagination += '<div><a class="addmore" href="javascript:void(0)" onclick="selfhomepage('
				+ (data.currPage + 1)
				+ ')">点击加载更多</a></div>'
		}
		$("#page")[0].innerHTML = pagination
	}, "json")
}

var showhp = $('#showhp');
function homepage(data) {
	for (var i = 0; i < data.rows.length; i++) {
		if(data.rows[i].speak!=null){
			hpspeak(data.rows[i].speak);
		}else{
			hpapic(data.rows[i].albumpic);
		}
	}
	lightGallery();
}

function hpspeak(obj){
	var hps = '';
	hps+='<div><img onclick="showuser(\''+ obj.speakman+ '\')" class="picture"';
	if(obj.user.picture == null|| obj.user.picture == ""){
		hps+=' src="images/timg.jpg">';
	}else{
		hps+=' src="'+ obj.user.picture+'">';
	}
	showhp.append('<a class="uname" href="javascript:showuser(\''+ obj.speakman+ '\')">'+ obj.user.nickname+ '</a>');
	showhp.append('<span class="time">'+ obj.senddate+ '</span>');
	showhp.append('<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ obj.content+ '</div>');
	showhp.append('<a class="del" href="javascript:void(0)"></a>');
	showhp.append('<a class="com" onclick="addcomment(\''+ obj.sid+ '\',\''+ obj.s_uuid+ '\')" href="javascript:void(0)"'
			+ 'data-toggle="modal" data-target="#addcoment">评论</a></p></div>');
	showhp.append('<div class="dcom comment'+ obj.sid+'"></div>');
}

function hpapic(obj) {
	if(obj.user.picture == null|| obj.user.picture == ""){
		showhp.append('<div><img onclick="showuser(' + obj.user.uid+ ')" class="picture" src="images/timg.jpg">');
	}else{
		showhp.append('<div><img onclick="showuser(' + obj.user.uid+ ')" class="picture" src="'+obj.user.picture+'">');
	}
	showhp.append('<a onclick="showuser(' + obj.user.uid+ ')" class="uname' + obj.user.uid+ '" href="javascript:void(0)">'+ obj.user.uid + "</a>");
	showhp.append('<br><span  class="time">' + obj.apicdate+ "</span>");
	showhp.append('<div class="demo-gallery"><ul id="lightgallery">'
			+'<li data-src="' + obj.apic+ '"><a href="javascript:void(0)">'
			+'<img src="' +obj.apic + '"/></a></li></ul></div>');
	showhp.append('<p style="margin-left: 3%;">上传图片到《');
	showhp.append('<a onclick="openpic(' +  obj.user.uid + ',' + obj.abid+ ')" href="javascript:void(0)">相册' + obj.abid+ '</a>》</p></div>');
}

function lightGallery() {
	$(document).ready(function() {
		$("#lightgallery").lightGallery();
	});
}

function showuser(date) {
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		window.open(url)
	}
}
function openpic(speakman, date) {
	if (date != null) {
		var url = "page/albumpic.jsp?aid=" + speakman + "&abid=" + date;
		window.open(url)
	}
};