//根据说说编号去查说说下的评论
function comments(data) {
	for(var i=0;i<data.length;i++){
		if (data[i].comments == null || data[i].comments == ""||JSON.stringify(data[i].comments)=="{}") {
			return false;
		}
		var com = $('.comment' + data[i].sid);
		for (var j = 0; j < data[i].comments.length; j++) {
			if(data[i].comments[j].user.picture == null || data[i].comments[j].user.picture == ""){
				com.append('<div><img onclick="showuser(\'' + data[i].comments[j].comuserid + '\')" class="picture" src="images/timg.jpg">');
			}else{
				com.append('<div><img onclick="showuser(\'' + data[i].comments[i].comuserid + '\')" class="picture" src="'+data[i].comments[j].user.picture+'">');
			}
			com.append('<a class="uname" href="javascript:showuser(\'' + data[i].comments[j].comuserid+ '\')">'+ data[i].comments[j].user.nickname + '</a>');
			com.append('<span class="time">' + data[i].comments[j].comTime+ '</span>');
			com.append('<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data[i].comments[j].detail + '</div>');
			com.append('<a class="del" href="javascript:void(0)"></a>');
			com.append('<a href="javascript:addcr(\''+ data[i].comments[j].cid+ '\',\''+ data[i].comments[j].comuserid+ '\')" class="rep"  data-toggle="modal"'
					+' data-target="#addreply">回复</a></div>');
			if(data[i].comments[j].cid!=null&&data[i].comments[j].cid!=""){
				com.append('<div class="reply' + data[i].comments[j].cid+ '" style="margin-left: 5%;"></div>');
				replys(data[i].comments[j].replys);// 取到该评论下的回复
			}
		}
	}
}

//根据评论和回复，找到它下的所有回复
function replys(data) {
	if (data == null || data == "" || JSON.stringify(data)=="{}" || JSON.stringify(data)=="") {
		return false;
	}
	var rep = $(".reply" + data[0].rcid);
	for (var i = 0; i < data.length; i++) {
		if(data[i].user.picture == null || data[i].user.picture == ""){
			rep.append('<div><img onclick="showuser(\'' + data[i].ruserid + '\')" class="picture" src="images/timg.jpg">');
		}else{
			rep.append('<div><img onclick="showuser(\'' + data[i].ruserid + '\')" class="picture" src="'+data[i].user.picture+'">');
		}
		rep.append('<a class="uname" href="javascript:showuser(\'' + data[i].ruserid+ '\')">'+ data[i].user.nickname + '</a>');
		rep.append(' 回复<a href="javascript:showuser(\'' + data[i].rtargetid+ '\')">'+ data[i].puser.nickname+ '</a>:');
		rep.append('<span class="time">' + data[i].rtime+ '</span>');
		rep.append('<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'
				+ data[i].rcontent + '</div>');
		rep.append(+'<a class="del" href="javascript:void(0)"></a>');
		rep.append('<a href="javascript:addreplys(\''+ data[i].rid+ '\',\''+ data[i].ruserid+ '\')"'
				+' class="rep" data-toggle="modal" data-target="#addreply">回复</a></div>');
		if(data[i].rid!=null&&data[i].rid!=""){
			rep.append('<div class="reply' + data[i].rid + '"></div>');
			replys(data[i].replys);//取到该回复下的回复
		}
	}
}