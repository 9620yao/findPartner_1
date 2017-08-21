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
	$
	.post(
			"homepage/selflist",
			{
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
function homepage(data) {
	for (var i = 0; i < data.rows.length; i++) {
		findspeack(data.rows[i].hpid, data.rows[i].hpuseid, data.rows[i].hpdate);
		findalbumpic(data.rows[i].hpid, data.rows[i].hpuseid,
				data.rows[i].hpdate)
	}
}
function findspeack(sid, speakman, senddate) {
	$
	.ajax({
		type : "POST",
		url : "speaks/hpspeaks",
		data : {
			"sid" : sid,
			"speakman" : speakman
		},
		async : false,
		dataType : "json",
		success : function(data) {
			if (data == null || data == "") {
				return false
			}
			var speaksStr = "";
			speaksStr += "<div><img onclick=\"showuser('"
				+ data.speakman + '\')" class="picture uPic'
				+ data.speakman + '" src="images/timg.jpg">';
			speaksStr += "<a onclick=\"showuser('"
				+ data.speakman
				+ '\')" class="uname'
				+ data.speakman
				+ '" href="javascript:void(0)" style="margin-left: 1%;">'
				+ data.speakman + "</a>";
			speaksStr += '<br><span style="margin-left: 5%;">'
				+ data.senddate + "</span>";
			speaksStr += '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'
				+ data.content + "</div>";
			speaksStr += '<a style="margin-left: 23%;" href="javascript:void(0)"> </a>';
			speaksStr += "<a onclick=\"addcomment('"
				+ data.sid
				+ '\')" href="javascript:void(0)" style="margin-left: 5%;" data-toggle="modal"';
			speaksStr += ' data-target="#addcoment">评论</a></p>';
			speaksStr += '</div><div class="comment' + data.sid
			+ '" style="margin-left: 5%;"></div>';
			comments(data.sid);
			$("#showspeak").append(speaksStr);
			openPicture("" + data.speakman + "")
		}
	})
}
function comments(sid) {
	$
	.post(
			"comments/list",
			{
				"sid" : sid
			},
			function(data) {
				if (data == null || data == "") {
					return false
				}
				var commentStr = "";
				for (var i = 0; i < data.length; i++) {
					commentStr += "<div><img onclick=\"showuser('"
						+ data[i].comuserid
						+ '\')" class="picture uPic'
						+ data[i].comuserid
						+ '" src="images/timg.jpg">';
					commentStr += "<a onclick=\"showuser('"
						+ data[i].comuserid
						+ '\')" class="uname'
						+ data[i].comuserid
						+ '" href="javascript:void(0)" style="margin-left: 1%;">'
						+ data[i].comuserid + "</a>";
					commentStr += '<br><span style="margin-left: 5%;">'
						+ data[i].comTime + "</span>";
					commentStr += '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'
						+ data[i].detail + "</div>";
					commentStr += '<a style="margin-left: 23%;" href="javascript:void(0)"> </a>';
					commentStr += "<a onclick=\"addcr('"
						+ data[i].cid
						+ "','"
						+ data[i].comuserid
						+ '\')" href="javascript:void(0)" style="margin-left: 5%;"  data-toggle="modal"';
					commentStr += ' data-target="#addreply">回复</a>';
					commentStr += '</div><div class="reply'
						+ data[i].cid
						+ '" style="margin-left: 5%;"></div>';
					replys(data[i].cid);
					openPicture("" + data[i].comuserid + "")
				}
				$(".comment" + sid)[0].innerHTML = commentStr
			}, "json")
}
function replys(cid) {
	$
	.post(
			"replys/list",
			{
				"cid" : cid
			},
			function(data) {
				if (data == null || data == "") {
					return false
				}
				var replysStr = "";
				for (var i = 0; i < data.length; i++) {
					replysStr += "<div><img onclick=\"showuser('"
						+ data[i].ruserid
						+ '\')" class="picture uPic'
						+ data[i].ruserid
						+ '" src="images/timg.jpg">';
					replysStr += "<a onclick=\"showuser('"
						+ data[i].ruserid
						+ '\')" class="uname'
						+ data[i].ruserid
						+ '" href="javascript:void(0)" style="margin-left: 1%;">'
						+ data[i].ruserid + "</a> 回复";
					replysStr += '<a class="uname'
						+ data[i].rtargetid
						+ '" href="javascript:void(0)" style="margin-left: 1%;">'
						+ data[i].rtargetid + "</a>:";
					replysStr += '<br><span style="margin-left: 5%;">'
						+ data[i].rtime + "</span>";
					replysStr += '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'
						+ data[i].rcontent + "</div>";
					replysStr += '<a style="margin-left: 23%;" href="javascript:void(0)"> </a>';
					replysStr += "<a onclick=\"addreplys('"
						+ data[i].rid
						+ "','"
						+ data[i].ruserid
						+ '\')"  href="javascript:void(0)" style="margin-left: 5%;"  data-toggle="modal"';
					replysStr += ' data-target="#addreply">回复</a></div>';
					replysStr += '<div class="reply' + data[i].rid
					+ '"></div>';
					replys(data[i].rid);
					openPicture("" + data[i].ruserid + "")
				}
				$(".reply" + cid)[0].innerHTML = replysStr
			}, "json")
}
function findalbumpic(abid, speakman, apicdate) {
	$.ajax({
		type : "POST",
		url : "albumpic/hpalbumpic",
		data : {
			"abid" : abid,
			"apicdate" : apicdate
		},
		async : false,
		dataType : "json",
		success : function(data) {
			if (data == null || data == "") {
				return false
			}
			var imgpic = "";
			imgpic += "<div><img onclick=\"showuser('" + speakman
			+ '\')" class="picture uPic' + speakman
			+ '" src="images/timg.jpg">';
			imgpic += "<a onclick=\"showuser('" + speakman
			+ '\')" class="uname' + speakman
			+ '" href="javascript:void(0)" style="margin-left: 1%;">'
			+ speakman + "</a>";
			imgpic += '<br><span style="margin-left: 5%;">' + data.apicdate
			+ "</span>";
			imgpic += '<div id="imgs" class="imgs">';
			imgpic += '<img src="' + data.apic + '">';
			imgpic += '</div><p style="margin-left: 3%;">上传图片到《';
			imgpic += "<a onclick=\"openpic('" + speakman + "','" + data.abid
			+ '\')" href="javascript:void(0)">相册' + data.abid
			+ "</a>》</p></div>";
			$("#showspeak").append(imgpic);
			openPicture("" + speakman + "")
		}
	})
}
function addcomment(obj) {
	$(".strcomment").val(url);
	$(".callid").attr("value", obj)
}
function Getdetail() {
	var text = $(".democomment").text();
	$(".detail").attr("value", text);
	$("#faddcomment").submit()
}
function addcr(cid, comuserid) {
	$(".rcid").val(cid);
	$(".strreplys").val(url);
	$(".rtargetid").val(comuserid)
}
function addreplys(rid, ruserid) {
	$(".rcid").val(rid);
	$(".strreplys").val(url);
	$(".rtargetid").val(ruserid)
}
function Getrcontent() {
	var text = $(".democomment").text();
	$(".rcontent").val(text);
	$("#rform").submit()
}
function openPicture(aid) {
	$.post("user/aid", {
		"aid" : aid
	}, function(data) {
		if (data == null || data == "") {
			return false
		}
		$(".uPic" + data.uid).attr(
				"src",
				data.picture == null || data.picture == "" ? "images/timg.jpg"
						: data.picture);
		$(".uname" + data.uid).html(data.nickname)
	}, "JSON")
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