//根据说说编号去查说说下的评论
function comments(data) {
	for(var i=0;i<data.length;i++){
		 objcom(data[i]);
	}
}

function objcom(obj){
	var cstr='';
	for (var j = 0; j < obj.comments.length; j++) {
		if (obj.comments[j] == null || obj.comments[j] == ""||JSON.stringify(obj.comments[j])=="{}") {
			return false;
		}
		cstr+='<div><img onclick="showuser(\'' + obj.comments[j].comuserid + '\')" class="picture"';
		if(obj.comments[j].user.picture == null || obj.comments[j].user.picture == ""){
			cstr+=' src="images/timg.jpg">';
		}else{
			cstr+=' src="'+obj.comments[j].user.picture+'">';
		}
		cstr+='<a class="uname" href="javascript:showuser(\'' + obj.comments[j].comuserid+ '\')">'+ obj.comments[j].user.nickname + '</a>';
		cstr+='<span class="time">' + obj.comments[j].comTime+ '</span>';
		cstr+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ obj.comments[j].detail + '</div>';
		cstr+='<a class="del" href="javascript:void(0)"></a>';
		if(obj.sid==null||obj.sid==""){
			$('.comment' + obj.wid).append(cstr);
		}else{
			cstr+='<a onclick="addcr(\''+ obj.comments[j].cid+ '\',\''+ obj.comments[j].comuserid+ '\')" class="rep"  data-toggle="modal"'
			+' data-target="#addreply" href="javascript:void(0)">回复</a></div>';
			cstr+='<div class="divrep reply' + obj.comments[j].cid+ '" style="margin-left: 5%;"></div>';
			$('.comment' + obj.sid).append(cstr);
			replys(obj.comments[j].replys);// 取到该评论下的回复
		}
	}
}

//根据评论和回复，找到它下的所有回复
function replys(data) {
	if (data == null || data == "" || JSON.stringify(data)=="{}" || JSON.stringify(data)=="") {
		return false;
	}
	var rstr='';
	for (var i = 0; i < data.length; i++) {
		rstr+='<div><img onclick="showuser(\'' + data[i].ruserid + '\')" class="picture"';
		if(data[i].user.picture == null || data[i].user.picture == ""){
			rstr+=' src="images/timg.jpg">';
		}else{
			rstr+=' src="'+data[i].user.picture+'">';
		}
		rstr+='<a class="uname" href="javascript:showuser(\'' + data[i].ruserid+ '\')">'+ data[i].user.nickname + '</a>';
		rstr+=' 回复<a href="javascript:showuser(\'' + data[i].rtargetid+ '\')">'+ data[i].puser.nickname+ '</a>:';
		rstr+='<span class="time">' + data[i].rtime+ '</span>';
		rstr+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'
				+ data[i].rcontent + '</div>';
		rstr+='<a class="del" href="javascript:void(0)"></a>';
		rstr+='<a onclick="addcr(\''+ data[i].rcid+ '\',\''+ data[i].ruserid+ '\')" href="javascript:void(0)"'
				+' class="rep" data-toggle="modal" data-target="#addreply">回复</a></div>';
		$(".reply" + data[0].rcid).append(rstr);
	}
}

//点击说说的评论
function addcomment(obj,uuid) {
	$(".callid").attr("value", obj);
	$('.s_uuid').attr("value",uuid);
	$(".btnclose").attr("data-dismiss","");
}

//评论点击提交
function Getdetail(){
	var text = $(".democomment").text();
	var callid = $(".callid").val();
	var s_uuid = $('.s_uuid').val();
	$.post("comments/add",{"detail":text,"callid":callid,"c_uuid":s_uuid},function(data){
		if(data){
			alonecom(callid,s_uuid);
			$(".btnclose").attr("data-dismiss","modal");
			$(".btnclose").click();
			$(".democomment").html("");
		}
	},"json");
}

//点击评论的回复
function addcr(cid, comuserid) {
	$(".rcid").val(cid);
	$(".rtargetid").val(comuserid);
	$(".btnclose").attr("data-dismiss","");
}

//回复点击提交
function Getrcontent() {
	var rcontent = $(".democomment").text();
	var rcid = $(".rcid").val();
	var rtargetid = $(".rtargetid").val();
	$.post("replys/add",{"rcid":rcid,"rtargetid":rtargetid,"rcontent":rcontent},function(data){
		if(data){
			alonerel(rcid);
			$(".btnclose").attr("data-dismiss","modal");
			$(".btnclose").click();
			$(".democomment").html("");
		}
	},"json");
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
			if($('.com').html()!="回复"){
				alcom+='<a href="javascript:addcr(\''+ data[i].cid+ '\',\''+ data[i].comuserid+ '\')" class="rep"  data-toggle="modal"'
				+' data-target="#addreply">回复</a></div>';
				alcom+='<div class="reply' + data[i].cid+ '" style="margin-left: 5%;"></div>';
			}
		}
		$(".comment"+callid).html(alcom);
	},"json");
}

function alonerel(rcid){
	$.post("replys/list",{"rcid":rcid},function(data){
		if(data==null || data==""){
			return false;
		}
		var alrel = '';
		for (var i = 0; i < data.length; i++) {
			alrel+='<div><img onclick="showuser(\'' + data[i].comuserid + '\')" class="picture"';
			if(data[i].user.picture == null || data[i].user.picture == ""){
				alrel+=' src="images/timg.jpg">';
			}else{
				alrel+=' src="'+data[i].user.picture+'">';
			}
			alrel+='<a class="uname" href="javascript:showuser(\'' + data[i].ruserid+ '\')">'+ data[i].user.nickname + '</a>';
			alrel+=' 回复<a href="javascript:showuser(\'' + data[i].rtargetid+ '\')">'+ data[i].puser.nickname+ '</a>:';
			alrel+='<span class="time">' + data[i].rtime+ '</span>';
			alrel+='<div value="onfocus=this.blur()" onfocus="this.blur()" class="demoEdit" contenteditable="true">'+ data[i].rcontent + '</div>';
			alrel+='<a class="del" href="javascript:void(0)"></a>';
			alrel+='<a onclick="addcr(\''+ data[i].rcid+ '\',\''+ data[i].ruserid+ '\')" href="javascript:void(0)"'
			+' class="rep" data-toggle="modal" data-target="#addreply">回复</a></div>';
		}
		$(".reply"+rcid).html(alrel);
	},"json");
}
