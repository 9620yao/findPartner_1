var url = window.location.href;
var faid = url.split('?')[1].split('&')[0].split('=')[1];

if (faid != null && faid != "") {
	$(".amyimg").attr("href", "page/lw-img.jsp?aid=" + faid);
}

GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", {
		"faid" : faid
	},function(data) {
				// alert(data);
				// alert(JSON.stringify(data)); //JSON.stringify()
				// ,把json对象转换成json字符串
				// alert(data.finalaid);
				if (data.faid == "-1") {
					$("#myfriend").show();
					$(".updatepwd").show();
					$(".homepage").val("个人中心");
					$(".addimgbtn").show();
					$(".newimgbtn").show();

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
					$(".addimgbtn").hide();
					$(".newimgbtn").hide();

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

// 加载相册
listalbumpic();
function listalbumpic() {
	$.post("albumpic/list", function(data) {
		if (data == null || data == "") {
			$(".imgnotnull").show();// 显示添加图片img标签
			return false;
		}
		$("#imgnotnull").hide();// 显示添加图片img标签
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify()// ,把json对象转换成json字符串
		var albumpicStr = "";
		for (var i = 0; i < data.length; i++) {
			albumpicStr += '<img src="' + data[i].apic
					+ '" layer-pname="代码笔记 - ' + data[i].apic + '">';
			albumpicStr += '<input type="hidden" class="apiccontent"  value="'
					+ data[i].apiccontent + '">';
		}
		$("#imgs")[0].innerHTML = albumpicStr;
	}, "json")
}
// alert($(".apiccontent").html());

function chgPic(obj) {
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}

function newpic(){
	$(".strpic").val(url);
	$("#fnewpic").submit();
}

;
!function() {
	layer.use('extend/layer.ext.js', function() {
		// 初始加载即调用，所以需放在ext回调里
		layer.ext = function() {
			layer.photosPage({
				html : '<div style="padding:20px;">'
						+ '<p>相册支持左右方向键，支持Esc关闭</p><p id="change"></p></div>',
				id : 100, // 相册id，可选
				parent : '#imgs'
			});
		};
	});
}();
// <div
// style="padding:20px;">这里传入自定义的html<p>相册支持左右方向键，支持Esc关闭</p><p>另外还可以通过异步返回json实现相册。更多用法详见官网。</p><p>'+
// unescape("代码笔记 www.198zone.com") +'</p><p id="change"></p></div>

