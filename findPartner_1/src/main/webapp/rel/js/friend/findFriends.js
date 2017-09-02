function addFriend(aid) {
	$.post("friend/add", {
		"aid" : aid
	}, function(data) {
		if (data) {
			friendIntro();
		}
	}, "json")
}

friendIntro();
function friendIntro() {
	$.get("friend/intro",function(data) {
		//alert(JSON.stringify(data));
		if (data == null||data == "") {
			return false;
		}
		var itstr = '';
		for (var i = 0; i < data.length; i++) {
			itstr+='<div class="sdiv pull-left"><img onclick="showuser('+data[i].uid+')" class="pic"';
			if(data[i].picture==null||data[i].picture==""){
				itstr+=' src="images/timg.jpg" >';
			}else{
				itstr+=' src="'+data[i].picture+'" >';
			}
			itstr+='<a href="javascript:showuser('+data[i].uid+')">'+data[i].nickname+'</a><br>';
			itstr+='<a class="btn btn-default" href="javascript:addFriend(\''+ data[i].uid+ '\')">添加</a></div>';
		}
		$(".sfpage").html(itstr);
	}, "json")
}
