$('#wordsInfo').datagrid({    
	url:'words/showWords',  
	fitColumns:true,
	//fit:true,
	singleSelect:true,
	border:false,
	pagination :true,
	columns:[[    
	          {field:'wid',title:'编号',width:50,align:'center'},    
	          {field:'wfrendid',title:'留言人',width:50,align:'center'},
	          {field:'wcontent',title:'内容',width:100,align:'center'},   
	          {field:'waddress',title:'地址',width:100,align:'center'},
	          {field:'wdate',title:'时间',width:100,align:'center'},

	          {field:'operator',title:'操作',width:100,align:'center',
	        	  formatter: function(value,row,index){
	        		  //alert(row + "==>" + JSON.stringify(row));
	        		  return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+index+')">详情</a>' + 
	          		'<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});</script>';
	        	  }
	          }
	          ]],
});  
$("#wordsDetail").dialog({
	title:"留言预览",
	left:10,
	closed:true,
});

function showDetail(index){
	$("#wordsDetail").dialog("open");
	var row = $("#wordsInfo").datagrid("getRows")[index];
	$("#iwid").val(row.wid);
	$("#iwfrendid").val(row.wfrendid);
	$("#iwcontent").html(row.wcontent);
	$("#iwaddress").val(row.waddress);
	$("#iwdate").val(row.wdate);
}
function unclearQueryWords(){
	var select=$("#WordselectName").val();
	var param=$("#paramterW").val();
	$('#wordsInfo').datagrid({    
		url:'words/findunclear?wfrendid='+param,
		fitColumns:true,
		fit:true,
		singleSelect:true,
		border:false,
		pagination :true,
		columns:[[    
		          {field:'wid',title:'编号',width:50,align:'center'},    
		          {field:'wfrendid',title:'留言人',width:50,align:'center'},
		          {field:'wcontent',title:'内容',width:100,align:'center'},   
		          {field:'waddress',title:'地址',width:100,align:'center'},
		          {field:'wdate',title:'时间',width:100,align:'center'},

		          {field:'operator',title:'操作',width:100,align:'center',
		        	  formatter: function(value,row,index){
		        		  //alert(row + "==>" + JSON.stringify(row));
		        		  return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+index+')">详情</a>' + 
		          		'<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});</script>';
		        	  }
		          }
		          ]],
	}); 
}

