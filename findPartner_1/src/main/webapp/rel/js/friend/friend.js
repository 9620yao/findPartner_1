var url = window.location.href;
var faid = url.split("?")[1].split("=")[1];
if (faid != null && faid != "") {
	$(".homepage").attr("href", "page/lw-index.jsp?aid=" + faid);
	$(".myfriends").attr("href", "page/lw-friend.jsp?aid=" + faid);
	$(".addfriend").attr("href", "page/lw-findFriend.jsp?aid=" + faid);
	$(".myspeaks").attr("href", "page/lw-speaks.jsp?aid=" + faid);
	$(".myword").attr("href", "page/message.jsp?aid=" + faid);
	$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
	$(".updatepwd").attr("href", "page/lw-modifyPwd.jsp?aid=" + faid)
}

var currPage = 1;
listfriends(currPage);
function listfriends(currPage) {
	$.get("friend/list", {
		"currPage" : currPage
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		var options = {
				alignment : "center", // 居中显示
				currentPage : data.currPage, // 当前页数
				totalPages : data.totalPage,// 总页数 注意不是总条数
				pageUrl : function(type, page, current) {
					if (page == current) {
						return "javascript:void(0)";
					} else {
						return "javascript:listfriends(" + page + ")";
					}
				}
		};
		var fstr = "";
		for (var i = 0; i < data.rows.length; i++) {
			fstr += '<tr><td><img onclick="showuser(' + data.rows[i].fid
			+ ')" class="picture"';
			if (data.rows[i].user.picture == null
					|| data.rows[i].user.picture == "") {
				fstr += ' src="images/timg.jpg"></td>';
			} else {
				fstr += ' src="' + data.rows[i].user.picture + '"></td>';
			}
			fstr += '<td><a href="javascript:showuser(' + data.rows[i].fid
			+ ')">' + data.rows[i].user.nickname + '</a></td>';
			fstr += '<td>' + data.rows[i].fid + '</td></tr>';
		}
		$(".divtable")[0].innerHTML = fstr;
		$('#page').bootstrapPaginator(options);
	}, "json")
}
rec();
function rec(){
	$.get("friend/reqCount",function(data) {
		$(".rc").html(data);
	}, "json")
}
function getrel(){
	$.get("friend/reqadd",function(data) {
		if (data != null) {
			$(".hd").html("好友请求");
			$(".threl").html("请求");
			var freqstr = "";
			for(var i=0;i<data.length;i++){
				freqstr += '<tr><td><img onclick="showuser(' + data[i].uid+ ')" class="picture"';
				if (data[i].user.picture == null || data[i].user.picture == "") {
					freqstr += ' src="images/timg.jpg"></td>';
				} else {
					freqstr += ' src="' + data[i].user.picture + '"></td>';
				}
				freqstr += '<td><a href="javascript:showuser(' + data[i].uid
				+ ')">' + data[i].user.nickname + '</a> 请求添加你为好友</td>';
				freqstr += '<td><a class="btn btn-default" href="javascript:addFriend(\''+ data[i].uid+ '\')">添加</a></div></td></tr>';
			}
			$(".divtable")[0].innerHTML = freqstr;
		}
	}, "json")
}

function friendKnow() {
	$.get("friend/know",function(data) {
		if (data != null) {
			$(".hd").html("可能认识的人");
			$(".threl").html("请求");
			var fnowstr = "";
			for (var i = 0; i < data.length; i++) {
				fnowstr += '<tr><td><img onclick="showuser(' + data[i].uid+ ')" class="picture"';
				if (data[i].picture == null || data[i].picture == "") {
					fnowstr += ' src="images/timg.jpg"></td>';
				} else {
					fnowstr += ' src="' + data[i].picture + '"></td>';
				}
				fnowstr += '<td><a href="javascript:showuser(' + data[i].uid + ')">' + data[i].nickname + '</a> <span>与你有' + data[i].C + '个共同好友</span></td>';
				fnowstr += '<td><a class="btn btn-default" href="javascript:addFriend(\''+ data[i].uid+ '\')">添加</a></div></td></tr>';
			}
			$(".divtable")[0].innerHTML = fnowstr;
		}
	}, "json")
};


function addFriend(aid) {
	$.post("friend/add", {
		"aid" : aid
	}, function(data) {
		if (data) {
			getrel();
		}
	}, "json")
}

function showuser(date) {
	if (date != null) {
		var url = "page/lw-index.jsp?aid=" + date;
		window.open(url)
	}
};
function loadPage(href) {
	$.ajaxSetup({cache: false });
	$(".other").load(href);
}

function reload(){
	parent.location.reload();// 刷新缓存
}