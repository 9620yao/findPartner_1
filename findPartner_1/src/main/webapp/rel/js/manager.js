$("#main").tabs({
	fit:true,
	border:false,
});

$("#sideNav").accordion({
	fit:true,
	border:false,	
});

$(".treeNav").tree({
	onClick: function(node){  // node是指树节点， node.text是节点文本内容
		var nodeContent = node.text;
		if($("#main").tabs('exists', nodeContent)){
			$("#main").tabs('close', nodeContent)
		}
		
		if(nodeContent=="用户信息"){
			$("#main").tabs('add',{
				title:nodeContent,
				//content:nodeContent,
				href:"back/users_info.jsp",
				iconCls:"icon-mini-add",
				closable:true
			});
		}else if(nodeContent == "说说信息"){
			$("#main").tabs('add',{
				title: nodeContent,
				href:"back/speaks_info.jsp",
				iconCls:"icon-mini-add",
				closable:true,
			});
		}else if(nodeContent == "留言信息"){
			$("#main").tabs('add',{
				title: nodeContent,
				href:"back/words_info.jsp",
				iconCls:"icon-mini-add",
				closable:true,
			});
		}else if(nodeContent == "相册信息"){
			$("#main").tabs('add',{
				title: nodeContent,
				href:"back/album_info.jsp",
				iconCls:"icon-mini-add",
				closable:true,
			});
		}else if(nodeContent == "统计说说"){
			$("#main").tabs('add',{
				title: nodeContent,
				href:"back/speaks_count.jsp",
				iconCls:"icon-mini-add",
				closable:true,
			});
		}else if(nodeContent == "统计留言"){
			$("#main").tabs('add',{
				title: nodeContent,
				href:"back/words_count.jsp",
				iconCls:"icon-mini-add",
				closable:true,
			});
		}else if(nodeContent == "统计相册"){
			$("#main").tabs('add',{
				title: nodeContent,
				href:"back/album_count.jsp",
				iconCls:"icon-mini-add",
				closable:true,
			});
		}else if(nodeContent == "权限管理"){
			$("#main").tabs('add',{
				title: nodeContent,
				href:"back/userpower.jsp",
				iconCls:"icon-mini-add",
				closable:true,
			});
		}
	}
});


$.extend($.fn.layout.methods,{
	full:function(jq){
		return jq.each(function(){
			var layout=$(this);
			var center=layout.layout("panel","center");
			center.panel("maximize");
			center.parent().css("z-index",10);
			
			$(window).on("resize.full",function(){
				layout.layout("unFull").layout("resize");
			})
		});
	},
	unfull:function(jq){
		return jq.each(function(){
			var layout=$(this);
			var center=layout.layout("panel","center");
			center.parent().css("z-index","inherit");
			center.panel("restore");
			$(window).off("resize.full");
		});
	}
});

$("#personalInfo").dialog({	
	title:"",
	width:260,
	border:false,
	modal:true,
	closed:true,
	closable:false,
});

$('#modifyBtn').linkbutton({    
    iconCls: 'icon-ok',
    width: 80,
    onClick: function(){    	
    	/*$("#loginForm").submit();*/
    }
}); 

$('#closeBtn').linkbutton({    
    iconCls: 'icon-cancel',
    width: 80,
    onClick: function(){    	
    	$("#personalInfo").dialog("close", true);
    }
}); 

$("#personalInfo input[type=password]").textbox({
	width:160,
});

function full(){
	$("body").layout("full");
	$("#center_content").addClass("panel-fit");
}

function unfull(){
	$("body").layout("unfull");
}

function reLogin(){
	//显示重新登录确认框
	$.messager.confirm('', '您是否确定要切换用户吗？', function(r){
		if (r){
		    // 切换用户操作;
			location.href="back/login.jsp";
		}
	});
}

function aboutUs(){
	//显示关于我们的dialog
	$.messager.alert('','<table><tr><td align="right">手机：</td><td>17773488663</td></tr><tr><td  align="right">QQ：</td><td>413670706</td></tr><tr><td align="right">版本所有：</td><td>姜平</td></tr></table>','info');
}

function logoutFun() {
	//显示退出系统确认框
	$.messager.confirm('', '您确定要退出系统吗？', function(r){
		if (r){
		    //退出系统操作;
			location.replace("back/login.jsp");
		}
	});
}

function userInfoFun() {
	//显示修改密码框
	$('#personalInfo').window('open');
}