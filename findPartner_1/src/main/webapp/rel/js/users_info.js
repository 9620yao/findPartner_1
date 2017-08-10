$("#dg").datagrid({
	url : 'user/mlist',
	fitColumns:true,
	//fit:true,
	pagination:true,
	singleSelect:true,
	columns:[[    
	          {field:'aid',title:'编号',width:50,align:'center'},
	          {field:'nickname',title:'昵称',width:50,align:'center'},
	          {field:'gender',title:'性别',width:40,align:'center',
	        	  formatter: function(value,row,index){
	        		  return row.partner.gender;
	        	  }
	          }, 
	          {field:'email',title:'邮箱',width:90,align:'center',
	        	  formatter: function(value,row,index){
	        		  return row.partner.email;
	        	  }
	          },
	          {field:'birthday',title:'生日',width:50,align:'center'},
	          {field:'star',title:'星座',width:50,align:'center'},
	          {field:'hobby',title:'愛好',width:50,align:'center'},
	          {field:'picture',title:'头像',width:100,align:'center',
	        	  formatter: function(value,row,index){
	        		  if(value == null){
	        			  return "<img width='100' src='images/not_pic.jpg'/>"
	        		  }else{
	        			  return "<img width='100' src='" + value + "'/>"
	        		  }
	        	  }
	          },
	          {field:'regdate',title:'注册时间',width:50,align:'center',
	        	  formatter: function(value,row,index){
	        		  return row.partner.regdate;
	        	  }
	          },
	          {field:'operator',title:'操作',width:70,align:'center',
	        	  formatter: function(value,row,index){
	        		  return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+index+')">详情</a>'+
	        		  '<script>$(".detailBtn").linkbutton({iconCls:"icon-search"});</script>';
	        	  }
	          },
	          {field:'power',title:'权限',width:70,align:'center',
	        	  formatter: function(value,row,index){
	        		  return '<a class="power" href="javascript:void(0)" onclick="openpower(\''+index+'\')">权限</a>'+
	        		  '<script>$(".power").linkbutton({iconCls:"icon-lock"});</script>';
	        	  }
	          }
	          ]]      
});
$("#usersDetail").dialog({
	title:"用户详情",
	closable:false,
	modal:true,
});
$("#usersDetail").dialog("close");

$(".closeBtn").linkbutton({
	iconCls: "icon-cancel",
	onClick: function(){
		$("#usersDetail").dialog("close");
	} 	
});

function showDetail(index){
	$("#usersDetail").dialog("open");
	var row = $("#dg").datagrid("getRows")[index];
	$("#iaid").val(row.aid);
	$("#inickname").val(row.nickname);
	$("#igender").val(row.partner.gender);
	$("#iemail").val(row.partner.email);
	$("#ibirthday").val(row.birthday);
	$("#istar").val(row.star);
	$("#ihobby").val(row.hobby);
	$("#iregdate").val(row.partner.regdate);
	$("#ipicture").attr("src",row.picture=="" ? "images/not_pic.jpg":row.picture);
}

function unclearQuery(){
	var select=$("#UserselectName").val();
	var param=$("#paramter").val();
	$('#dg').datagrid({    
		url:'user/find?aid='+param,
		fitColumns:true,
		//fit:true,
		pagination:true,
		singleSelect:true,
		columns:[[    
		          {field:'aid',title:'编号',width:50,align:'center'},
		          {field:'nickname',title:'昵称',width:50,align:'center'},
		          {field:'gender',title:'性别',width:50,align:'center',
		        	  formatter: function(value,row,index){
		        		  return row.partner.gender;
		        	  }
		          }, 
		          {field:'email',title:'邮箱',width:100,align:'center',
		        	  formatter: function(value,row,index){
		        		  return row.partner.email;
		        	  }
		          },
		          {field:'birthday',title:'生日',width:50,align:'center'},
		          {field:'star',title:'星座',width:50,align:'center'},
		          {field:'hobby',title:'愛好',width:50,align:'center'},
		          {field:'picture',title:'头像',width:100,align:'center',
		        	  formatter: function(value,row,index){
		        		  if(value == null){
		        			  return "<img width='100' src='images/not_pic.jpg'/>"
		        		  }else{
		        			  return "<img width='100' src='" + value + "'/>"
		        		  }
		        	  }
		          },
		          {field:'regdate',title:'注册时间',width:50,align:'center',
		        	  formatter: function(value,row,index){
		        		  return row.partner.regdate;
		        	  }
		          },
		          {field:'operator',title:'操作',width:50,align:'center',
		        	  formatter: function(value,row,index){
		        		  return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+index+')">详情</a>'+
		        		  '<script>$(".detailBtn").linkbutton({iconCls:"icon-search"});</script>';
		        	  }
		          },
		          {field:'power',title:'权限',width:70,align:'center',
		        	  formatter: function(value,row,index){
		        		  return '<a class="power" href="javascript:void(0)" onclick="openpower(\''+index+'\')">权限</a>'+
		        		  '<script>$(".power").linkbutton({iconCls:"icon-lock"});</script>';
		        	  }
		          }
		    ]],     
	}); 
}

function openpower(index){
	var row = $("#dg").datagrid("getRows")[index];
	var faid = row.aid;
	$.post("power/sure",{"faid":faid},function(data){
		if(data){
			$.messager.alert('权限提示','该用户有封禁记录，您可以在权限管理查看和解封..');
			return false;
		}
		power(faid);
	},"json");
}

function power(faid){
	$.post("power/add",{"faid":faid},function(data){
		if(data){
			$.messager.alert('权限提示','封禁成功，您可以在权限管理查看..');
			return false;
		}
		$.messager.alert('权限提示','封禁失败，请您在确认后操作..');
	},"json");
}

