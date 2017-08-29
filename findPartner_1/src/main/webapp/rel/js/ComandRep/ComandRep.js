//根据说说编号去查说说下的评论
function comments(data) {
	if (data == null || data == ""||JSON.stringify(data)=="{}") {
		return false;
	}
	var com = $('.comment' + data[0].callid);
	for (var i = 0; i < data.length; i++) {
		com.append('<div><img onclick="showuser(\'' + data[i].comuserid + '\')" class="picture"'
				+ '" src="'+(data[i].user.picture == null || data[i].user.picture == "" ? "images/timg.jpg": data[i].user.picture)+'">'
				+'<a class="uname" href="javascript:showuser(\'' + data[i].comuserid+ '\')">'
				+ data[i].user.nickname + '</a>'
				+'<span class="time">' + data[i].comTime+ '</span><div value="onfocus=this.blur()"'
				+' onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data[i].detail + '</div>'
				+'<a class="del" href="javascript:void(0)"></a><a href="javascript:addcr(\''
				+ data[i].cid+ '\',\''+ data[i].comuserid+ '\')" class="rep"  data-toggle="modal"'
				+' data-target="#addreply">回复</a></div><div class="reply' + data[i].cid+ '" style="margin-left: 5%;"></div>');
		replys(data[i].replys);// 取到该评论下的回复
	}
}

//根据评论和回复，找到它下的所有回复
function replys(data) {
	if (data == null || data == "" || JSON.stringify(data)=="{}" || JSON.stringify(data)=="") {
		return false;
	}
	var rep = $(".reply" + data[0].rcid);
	for (var i = 0; i < data.length; i++) {
		rep.append( '<div><img onclick="showuser(\'' + data[i].ruserid+ '\')" class="picture"'
				+ 'src="'+(data[i].user==null || data[i].user.picture == null || data[i].user.picture == "" ? "images/timg.jpg": data[i].user.picture)+'">'
				+'<a class="uname" href="javascript:showuser(\'' + data[i].ruserid+ '\')">'
				+ data[i].user.nickname + '</a> 回复<a href="javascript:showuser(\'' + data[i].rtargetid+ '\')">'
				+ data[i].puser.nickname+ '</a>:<span class="time">' + data[i].rtime+ '</span>'
				+'<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'
				+ data[i].rcontent + '</div><a class="del" href="javascript:void(0)"></a>'
				+'<a href="javascript:addreplys(\''+ data[i].rid+ '\',\''+ data[i].ruserid+ '\')"'
				+' class="rep" data-toggle="modal" data-target="#addreply">回复</a></div>'
				+'<div class="reply' + data[i].rid + '"></div>');
		replys(data[i].replys);//取到该回复下的回复
	}
}