$('#albumInfo').datagrid({    
	url:'album/countAlbum',  
	fitColumns:true,
	//fit:true,
	singleSelect:true,
	border:false,
	pagination :true,
    columns:[[    
        {field:'aaid',title:'发表人',width:100,align:'center'},   
        {field:'counts',title:'相册数量',width:100,align:'center'}
    ]],
});  

function unclearQueryAlbumCount(){
	var select=$("#AlbumselectCount").val();
	var param=$("#paramterAC").val();
	$('#albumInfo').datagrid({    
		url:'album/findunclearing?aaid='+param,
		fitColumns:true,
		//fit:true,
		singleSelect:true,
		border:false,
		pagination :true,
		 columns:[[    
		           {field:'aaid',title:'发表人',width:100,align:'center'},   
		           {field:'alcontent',title:'相册数量',width:100,align:'center'}
		       ]],
	}); 
}
