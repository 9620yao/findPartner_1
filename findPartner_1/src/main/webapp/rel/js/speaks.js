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
