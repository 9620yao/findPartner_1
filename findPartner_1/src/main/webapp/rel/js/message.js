wordcount();
function wordcount() {
	$.post("words/countWords", {
		"waid" : faid
	}, function(data) {
		if (data == null || data == "") {
			return false
		}
		$(".spcount").html(data[0].counts)
	}, "json")
}

var currPage = 1;
listWords(currPage);
function listWords(currPage) {
	$.post("words/list",{
		"currPage" : currPage,
		"faid" : faid
	},
	function(data) {
		if (data == null || data == "") {
			return false
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
		var wstr = '';
		for (var i = 0; i < data.rows.length; i++) {
			wstr+='<div><img onclick="showuser(' + data.rows[i].wfrendid+ ')" class="picture"';
			if(data.rows[i].puser.picture==null||data.rows[i].puser.picture==""){
				wstr+=' src="images/timg.jpg" />'
			}else{
				wstr+=' src="'+data.rows[i].puser.picture+'"/>'
			}
			wstr+= '<a class="uname" href="javascript:showuser('+ data.rows[i].wfrendid+ ')">'+ data.rows[i].puser.nickname + "</a>";
			wstr+= '<span class="time">'+ data.rows[i].wdate + '</span>';
			wstr+= '<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data.rows[i].wcontent + '</div>';
			wstr+= '<a class="del" href="javascript:void(0)"></a>';
			wstr+= '<a class="com" onclick="addcomment(\''+ data.rows[i].wid+ '\',\''+data.rows[i].w_uuid+'\')" href="javascript:void(0)"';
			wstr+= ' data-toggle="modal" data-target="#addcoment">回复</a>';
			wstr+= '<div class="dcom comment'+ data.rows[i].wid+ '"></div><hr style="border:1 dotted" id="link"></div>';
		}
		$("#hostAll")[0].innerHTML = wstr;
		comments(data.rows);
		$('#page').bootstrapPaginator(options);
	}, "json")
}

function addword() {
	var wcontent= ue.getContentTxt();
	$.ajax({
		url:"words/add",
		type:"post",
		data:{"waid":faid,"wcontent":wcontent},
		dataType:"json",
		success:function(data){
			if(data){
				listWords(1);
				clearmyedit();
			}
		}
	});
}
