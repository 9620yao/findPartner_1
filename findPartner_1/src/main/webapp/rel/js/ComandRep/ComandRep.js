//根据说说编号去查说说下的评论
function comments(data) {
	for(var i=0;i<data.length;i++){
		if (data[i].comments == null || data[i].comments == ""||JSON.stringify(data[i].comments)=="{}") {
			return false;
		}
		for (var j = 0; j < data[i].comments.length; j++) {
			if(data[i].comments[j].user.picture == null || data[i].comments[j].user.picture == ""){
				$('.comment' + data[i].sid).append('<div><img onclick="showuser(\'' + data[i].comments[j].comuserid + '\')" class="picture" src="images/timg.jpg">');
			}else{
				$('.comment' + data[i].sid).append('<div><img onclick="showuser(\'' + data[i].comments[j].comuserid + '\')" class="picture" src="'+data[i].comments[j].user.picture+'">');
			}
			$('.comment' + data[i].sid).append('<a class="uname" href="javascript:showuser(\'' + data[i].comments[j].comuserid+ '\')">'+ data[i].comments[j].user.nickname + '</a>');
			$('.comment' + data[i].sid).append('<span class="time">' + data[i].comments[j].comTime+ '</span>');
			$('.comment' + data[i].sid).append('<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data[i].comments[j].detail + '</div>');
			$('.comment' + data[i].sid).append('<a class="del" href="javascript:void(0)"></a>');
			$('.comment' + data[i].sid).append('<a onclick="addcr(\''+ data[i].comments[j].cid+ '\',\''+ data[i].comments[j].comuserid+ '\')" class="rep"  data-toggle="modal"'
					+' data-target="#addreply" href="javascript:void(0)">回复</a></div>');
			$('.comment' + data[i].sid).append('<div class="reply' + data[i].comments[j].cid+ '" style="margin-left: 5%;"></div>');
			replys(data[i].comments[j].replys);// 取到该评论下的回复
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
		rep.append('<a onclick="addcr(\''+ data[i].rcid+ '\',\''+ data[i].ruserid+ '\')" href="javascript:void(0)"'
				+' class="rep" data-toggle="modal" data-target="#addreply">回复</a></div>');
	}
}

function alonecom(callid,s_uuid){
	$.post("comments/list",{"callid":callid,"c_uuid":s_uuid},function(data){
		if(data==null||data==""){
			return false;
		}
		var alcom = '';
		for (var i = 0; i < data.length; i++) {
			alcom+='<div><img onclick="showuser(\'' + data[i].comuserid + '\')" class="picture"';
			if(data[i].user.picture == null || data[i].user.picture == ""){
				alcom+=' src="images/timg.jpg">';
			}else{
				alcom+=' src="'+data[i].user.picture+'">';
			}
			alcom+='<a class="uname" href="javascript:showuser(\'' + data[i].comuserid+ '\')">'+ data[i].user.nickname + '</a>';
			alcom+='<span class="time">' + data[i].comTime+ '</span>';
			alcom+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data[i].detail + '</div>';
			alcom+='<a class="del" href="javascript:void(0)"></a>';
			alcom+='<a href="javascript:addcr(\''+ data[i].cid+ '\',\''+ data[i].comuserid+ '\')" class="rep"  data-toggle="modal"'
			+' data-target="#addreply">回复</a></div>';
			alcom+='<div class="reply' + data[i].cid+ '" style="margin-left: 5%;"></div>';
		}
		$(".comment"+callid).html(alcom);
	},"json");
}

