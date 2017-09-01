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
			pagination += '<div><a class="addmore" href="javascript:showhomepage('+ (data.currPage + 1)+ ')">点击加载更多</a></div>'
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
			pagination += '<div><a class="addmore" href="javascript:selfhomepage('+ (data.currPage + 1)+ ')">点击加载更多</a></div>'
		}
		$("#page")[0].innerHTML = pagination;
	}, "json")
}
function showpage(){
	
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
	hps+='<a class="uname" href="javascript:showuser(\''+ obj.speakman+ '\')">'+ obj.user.nickname+ '</a>';
	hps+='<span class="time">'+ obj.senddate+ '</span>';
	hps+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ obj.content+ '</div>';
	hps+='<a class="del" href="javascript:void(0)"></a>';
	hps+='<a class="com" onclick="addcomment(\''+ obj.sid+ '\',\''+ obj.s_uuid+ '\')" href="javascript:void(0)"'
			+ 'data-toggle="modal" data-target="#addcoment">评论</a></p></div>';
	hps+='<div class="dcom comment'+ obj.sid+'"></div>';
	showhp.append(hps);
	objcom(obj);
}

function hpapic(obj) {
	var hap=''
	hap+='<div><img onclick="showuser(' + obj.user.uid+ ')" class="picture"';
	if(obj.user.picture == null|| obj.user.picture == ""){
		hap+=' src="images/timg.jpg">';
	}else{
		hap+=' src="'+obj.user.picture+'">';
	}
	hap+='<a class="uname" href="javascript:showuser(' + obj.user.uid+ ')">'+ obj.user.nickname + "</a>";
	hap+='<span  class="time">' + obj.apicdate+ "</span>";
	hap+='<div class="demo-gallery"><ul id="lightgallery">'
	+'<li data-src="' + obj.apic+ '"><a href="javascript:void(0)">'
	+'<img src="' +obj.apic + '"/></a></li></ul></div>';
	hap+='<p style="margin-left: 3%;">上传图片到《'
	+'<a onclick="openpic(' +  obj.user.uid + ',' + obj.abid+ ')" href="javascript:void(0)">相册' + obj.abid+ '</a>》</p></div>';
	showhp.append(hap);
}

function lightGallery() {
	$(document).ready(function() {
		$("#lightgallery").lightGallery();
	});
}
