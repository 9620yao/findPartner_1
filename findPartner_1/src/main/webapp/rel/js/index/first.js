function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
}

var faid = getUrlParam('aid');

GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},function(data) {
		if (data.faid == "-1") {
			$(".homepage").val("个人中心");
			$(".homepage").attr("href", "page/lw-index.jsp?aid=" + faid);
			$(".myfriends").attr("href",
					"page/lw-friend.jsp?aid=" + faid);
			$(".myspeaks").attr("href",
					"page/lw-speaks.jsp?aid=" + faid);
			$(".myword").attr("href", "page/message.jsp?aid=" + faid);
			$(".myalbum").attr("href", "page/lw-img.jsp?aid=" + faid);
			$(".uinfo").attr("href", "page/lw-info.jsp?aid=" + faid);
			
			$(".spanspeak").html("我的");
			
			$(".spanword").html("我的");
			fhide($("#divword"));
			
			$(".spanimg").html("我的");
			fshow($(".addimgs"));
			
			fshow($(".addimgbtn"));
			fshow($(".newimgbtn"));

			fshow($(".updatebtn"));
			fshow($(".myfriends"));
			fshow($(".uinfo"));
			fshow($(".editdiv"));
		} else {
			$(".homepage").html("TA的主页");
			$(".homepage").attr("href", "page/lw-index.jsp?aid=" + faid);
			$(".myfriends").attr("href",
					"page/lw-friend.jsp?aid=" + faid);
			$(".myspeaks").attr("href",
					"page/lw-speaks.jsp?aid=" + faid);
			$(".myword").attr("href",
					"page/message.jsp?aid=" + faid);
			$(".myalbum").attr("href",
					"page/lw-img.jsp?aid=" + faid);
			$(".uinfo").attr("href", "page/lw-info.jsp?aid=" + faid);
			
			$(".spanspeak").html("TA的");
			
			$(".spanword").html("TA的");
			fshow($("#divword"));
			
			$(".spanimg").html("TA的");
			fhide($(".addimgs"));
			
			fhide($(".addimgbtn"));
			fhide($(".newimgbtn"));

			fhide($(".updatebtn"));
			fhide($(".myfriends"));
			fhide($(".uinfo"));
			fhide($(".editdiv"));
		}
	}, "json")
}

function fshow(obj){
	if(obj==null||obj==""){
		return false;
	}else{
		obj.show();
	}
}
function fhide(obj){
	if(obj==null||obj==""){
		return false;
	}else{
		obj.hide();
	}
}