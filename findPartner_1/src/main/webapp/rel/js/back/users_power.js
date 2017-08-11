$("#powerInfo").datagrid({
	url : 'power/list',
	fitColumns:true,
	//fit:true,
	pagination:true,
	singleSelect:true,
	columns:[[    
	          {field:'upid',title:'编号',width:50,align:'center'},
	          {field:'upuid',title:'用户',width:50,align:'center'},
	          {field:'upower',title:'权限',width:40,align:'center',
	        	  formatter: function(value,row,index){
	        		  if(row.upower=="-1"){
	        			  return "封禁状态";
	        		  }
	        		  return "解封状态";
	        	  }
	          }, 
	          {field:'updata',title:'权限时间',width:50,align:'center',
	        	  formatter: function(value,row,index){
	        		  return row.updata;
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

function openpower(index){
	var row = $("#powerInfo").datagrid("getRows")[index];
	var upid = row.upid;
	var faid = row.upuid;
	//alert(faid);
	$.post("power/sure",{"faid":faid},function(data){
		if(data){
			updatepower(upid);
			return false;
		}
		$.messager.alert('权限提示','该用户已经处于解封状态，不需要解封！！！');
	},"json");
}

function updatepower(upid){
	$.post("power/update",{"faid":upid},function(data){
		if(data){
			$.messager.alert('权限提示','解除该用户封禁状态成功..');
			$('#powerInfo').datagrid("reload");
			return false;
		}
		$.messager.alert('权限提示','解除该用户封禁状态失败，请您在确认后操作!!!');
	},"json");
}

