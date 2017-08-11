$('#albumInfo').datagrid({    
	url:'album/showAlbums',  
	fitColumns:true,
	//fit:true,
	singleSelect:true,
	border:false,
	pagination :true,
    columns:[[    
        {field:'abid',title:'编号',width:50,align:'center'},    
        {field:'abname',title:'相册名',width:50,align:'center'},
        {field:'aaid',title:'发表人',width:100,align:'center'},   
        {field:'alcontent',title:'内容',width:100,align:'center'},
        {field:'allocation',title:'地址',width:100,align:'center'},
        {field:'aldate',title:'时间',width:100,align:'center'},
        {field:'aheader',title:'封面',width:100,align:'center',
        	formatter: function(value,row,index){
      		  if(value == null){
    			  return "<img width='100' src='images/not_pic.jpg'/>"
    		  }else{
    			  return "<img width='100' src='" + value + "'/>"
    		  }
        	}
        },
        {field:'operator',title:'操作',width:100,align:'center',
        	formatter: function(value,row,index){
				//alert(row + "==>" + JSON.stringify(row));
        		return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+index+')">详情</a>' + 
        		'<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});</script>';
        	}
        }
    ]],
});  
$("#albumDetail").dialog({
	title:"说说预览",
	left:10,
	closed:true,
});

function showDetail(index){
	$("#albumDetail").dialog("open");
	var row = $("#albumInfo").datagrid("getRows")[index];
	$("#iabid").val(row.abid);
	$("#iabname").val(row.abname);
	$("#iaaid").val(row.aaid);
	$("#ialcontent").html(row.alcontent);
	$("#iallocation").val(row.allocation);
	$("#ialdate").val(row.aldate);
	$("#iaheader").val("");
	if(row.aheader){
		$("#iaheader").attr("src", row.aheader);
	}else{
		$("#iaheader").attr("src", "images/not_pic.jpg");
	}
	
}

function unclearQueryAlbum(){
	var select=$("#AlbumselectName").val();
	var param=$("#paramterA").val();
	$('#albumInfo').datagrid({    
		url:'album/findunclear?aaid='+param,
		fitColumns:true,
		fit:true,
		singleSelect:true,
		border:false,
		pagination :true,
		 columns:[[    
		           {field:'abid',title:'编号',width:50,align:'center'},    
		           {field:'abname',title:'相册名',width:50,align:'center'},
		           {field:'aaid',title:'发表人',width:100,align:'center'},   
		           {field:'alcontent',title:'内容',width:100,align:'center'},
		           {field:'allocation',title:'地址',width:100,align:'center'},
		           {field:'aldate',title:'时间',width:100,align:'center'},
		           {field:'aheader',title:'封面',width:100,align:'center',
		           	formatter: function(value,row,index){
		         		  if(value == null){
		       			  return "<img width='100' src='images/not_pic.jpg'/>"
		       		  }else{
		       			  return "<img width='100' src='" + value + "'/>"
		       		  }
		           	}
		           },
		           {field:'operator',title:'操作',width:100,align:'center',
		           	formatter: function(value,row,index){
		           		return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+index+')">详情</a>' + 
		        		'<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});</script>';
		   			}
		           }
		       ]],
	}); 
}
