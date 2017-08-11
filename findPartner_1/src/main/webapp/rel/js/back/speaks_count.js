$('#speaksCountInfo').datagrid({    
	url:'speaks/countSpeaks',  
	fitColumns:true,
	//fit:true,
	singleSelect:true,
	border:false,
	pagination :true,
    columns:[[    
        {field:'speakman',title:'发表人',width:50,align:'center'},
        {field:'counts',title:'说说数量',width:100,align:'center'}
    ]],
});  

function unclearQuerySpeaksCount(){
	var select=$("#SpeakSelectCount").val();
	var param=$("#paramterC").val();
	$('#speaksCountInfo').datagrid({    
		url:'speaks/findunclearing?speakman='+param,
		fitColumns:true,
		//fit:true,
		singleSelect:true,
		border:false,
		pagination :true,
	    columns:[[    
	        {field:'speakman',title:'发表人',width:50,align:'center'},
	        {field:'counts',title:'数量',width:100,align:'center'}
	    ]],
	}); 
}
